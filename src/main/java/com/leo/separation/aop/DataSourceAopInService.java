package com.leo.separation.aop;

import com.leo.separation.config.dbConfig.DataSourceContextHolder;
import com.leo.separation.config.dbConfig.DataSourceType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * 在service层决定数据源
 * 
 * 必须在事务AOP之前执行，所以实现Ordered,order的值越小，越先执行
 * 如果一旦开始切换到写库，则之后的读都会走写库
 * 
 * @author leo_lei
 *
 */
@Aspect
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@Component
public class DataSourceAopInService implements PriorityOrdered {

private static Logger log = LoggerFactory.getLogger(DataSourceAopInService.class);
	
/*	@Before("execution(* com.fei.springboot.service..*.find*(..)) "
			+ " or execution(* com.fei.springboot.service..*.get*(..)) "
			+ " or execution(* com.fei.springboot.service..*.query*(..))")
    public void setReadDataSourceType() {
		//如果已经开启写事务了，那之后的所有读都从写库读
		if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
			DataSourceContextHolder.setRead();
		}
        
    }

    @Before("execution(* com.fei.springboot.service..*.insert*(..)) "
    		+ " or execution(* com.fei.springboot.service..*.update*(..))"
    		+ " or execution(* com.fei.springboot.service..*.add*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }*/
    

	@Before("execution(* com.leo.separation.service..*.*(..)) "
			+ " and @annotation(com.leo.separation.config.ReadDataSource) ")
	public void setReadDataSourceType() {
		//如果已经开启写事务了，那之后的所有读都从写库读
		if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
			DataSourceContextHolder.setRead();
		}
	    
	}
	
	@Before("execution(* com.leo.separation.service..*.*(..)) "
			+ " and @annotation(com.leo.separation.config.WriteDataSource) ")
	public void setWriteDataSourceType() {
	    DataSourceContextHolder.setWrite();
	}
    
	@Override
	public int getOrder() {
		/**
		 * 值越小，越优先执行
		 * 要优于事务的执行
		 * 在启动类中加上了@EnableTransactionManagement(order = 10) 
		 */
		return 1;
	}

}
