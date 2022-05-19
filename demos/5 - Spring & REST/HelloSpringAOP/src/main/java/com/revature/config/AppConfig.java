package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.revature.repos", "com.revature.services", "com.revature.aspects" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
