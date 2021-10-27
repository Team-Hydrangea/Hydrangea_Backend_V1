package com.su.hydrangea.global.quartz;

import org.quartz.SchedulerException;

import java.util.Map;

public interface QuartzFacade {

    void addCronJob(Class<?> jobClass, String name, Map<String, Object> params, String expression) throws SchedulerException;

}
