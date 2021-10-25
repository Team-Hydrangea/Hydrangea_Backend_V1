package com.su.hydrangea.global.quartz;

import org.quartz.SchedulerException;

import java.util.Map;
import java.util.Objects;

public interface QuartzFacade {

    void addCronJob(Class<?> jobClass, String name, String description, Map<String, Objects> params, String expression) throws SchedulerException;

}
