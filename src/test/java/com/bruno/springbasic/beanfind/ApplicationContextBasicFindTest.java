package com.bruno.springbasic.beanfind;

import com.bruno.springbasic.basic1.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        AppConfig appConfig = ac.getBean("appConfig", AppConfig.class);
        assertThat(appConfig).isInstanceOf(AppConfig.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        AppConfig appConfig = ac.getBean(AppConfig.class);
        assertThat(appConfig).isInstanceOf(AppConfig.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        Assertions.assertThrows( NoSuchBeanDefinitionException.class, () -> ac.getBean("appConfigX", AppConfig.class) );
    }
}
