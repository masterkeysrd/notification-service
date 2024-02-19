package com.masterkeys.notificationservice.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class AsyncConfig implements AsyncConfigurer {

    @Value("${async.executor.corePoolSize}")
    private int corePoolSize;

    @Value("${async.executor.maxPoolSize}")
    private int maxPoolSize;

    @Value("${async.executor.queueCapacity}")
    private int queueCapacity;

    @Value("${async.executor.threadNamePrefix}")
    private String threadNamePrefix;

    @Override
    public Executor getAsyncExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            if (corePoolSize < 1) {
                corePoolSize = 1;
            }

            if (maxPoolSize < 1) {
                maxPoolSize = 1;
            }

            if (queueCapacity < 1) {
                queueCapacity = 1;
            }

            if (corePoolSize > maxPoolSize) {
                corePoolSize = maxPoolSize;
            }

            if (threadNamePrefix == null || threadNamePrefix.isEmpty()) {
                threadNamePrefix = "async-executor-";
            }

            executor.setCorePoolSize(corePoolSize);
            executor.setMaxPoolSize(maxPoolSize);
            executor.setQueueCapacity(queueCapacity);
            executor.setThreadNamePrefix(threadNamePrefix);
            executor.initialize();
            return executor;
    }
}
