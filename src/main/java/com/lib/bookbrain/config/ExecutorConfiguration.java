package com.lib.bookbrain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author yunxia
 */
@Configuration
@EnableAsync
public class ExecutorConfiguration {

@Value("${async.executor.thread.core_pool_size}")
private int corePoolSize;
@Value("${async.executor.thread.max_pool_size}")
private int maxPoolSize;
@Value("${async.executor.thread.queue_capacity}")
private int queueCapacity;
@Value("${async.executor.thread.name.prefix}")
private String namePrefix;

@Bean
public Executor asyncServiceExecutor() {
	/* ============================ 配置线程池 ============================ */
	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); // 创建线程池
	executor.setCorePoolSize(corePoolSize); // 配置核心线程数
	executor.setMaxPoolSize(maxPoolSize); // 配置最大线程数
	executor.setQueueCapacity(queueCapacity); // 配置队列大小
	executor.setThreadNamePrefix(namePrefix); // 配置线程池中的线程的名称前缀
	// rejection-policy：当pool已经达到 max size 的时候，如何处理新任务
	// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
	executor.setRejectedExecutionHandler(
			new ThreadPoolExecutor.CallerRunsPolicy());
	executor.initialize(); // 执行初始化
	return executor;
	/* ============================ 配置线程池 ============================ */
}
}
