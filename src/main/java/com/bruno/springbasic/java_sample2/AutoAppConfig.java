package com.bruno.springbasic.java_sample2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    //excludeFilters = @ComponentScan.Filter( type= FilterType.ANNOTATION , classes = Configuration.class )  //AppConfig 에 등록되어있어서 처리 한다. 이거는 안해줘도 됨,
    //basePackages = "com.bruno.springbasic.java_sample2"
)
public class AutoAppConfig {



}
