package com.bruno.springbasic.beanfind;

import com.bruno.springbasic.basic1.AppConfig;
import com.bruno.springbasic.basic1.MemberRepository;
import com.bruno.springbasic.basic1.MemoryDbMemberRepository;
import com.bruno.springbasic.basic1.MysqlDbMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상 있으면 중복오류가 발생한다.")
    void findBeanByParentDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상 있으면 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeBeanName(){
        MemberRepository mysqlRepository = ac.getBean("mysqlRepository", MemberRepository.class);
        assertThat(mysqlRepository).isInstanceOf(MemberRepository.class);
    }


    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        MemberRepository mysqlRepository = ac.getBean(MysqlDbMemberRepository.class);
        assertThat(mysqlRepository).isInstanceOf(MemberRepository.class);
    }


    @Test
    @DisplayName("부모타입으로 모두조회하기")
    void findBeanByParentType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        System.out.println(beansOfType);

        for(String key : beansOfType.keySet()){
            System.out.println("key :" + key + " value : " + beansOfType.get(key));
        }
    }



    @Test
    @DisplayName("부모타입으로 모두조회하기 - Object")
    void findBeanByParentObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        for(String key : beansOfType.keySet()){
            System.out.println("key : " + key + " value : " + beansOfType.get(key));
        }
    }


    @Configuration
    static class TestConfig {

        @Bean
        MemberRepository mysqlRepository() {
            return new MysqlDbMemberRepository();
        }

        @Bean
        MemberRepository memoryRepository() {
            return new MemoryDbMemberRepository();
        }
    }
}
