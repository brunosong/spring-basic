package com.bruno.springbasic.beanfind;

import com.bruno.springbasic.basic1.MemberRepository;
import com.bruno.springbasic.basic1.MysqlDbMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 , 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
    }


    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 , 빈 이름을 지정하면 된다.")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);

    }


    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        System.out.println(beansOfType);

        for(String key : beansOfType.keySet()){
            System.out.println("key :" + key + " value : " + beansOfType.get(key));
        }
    }


    @TestConfiguration
    static class SameBeanConfig {

        @Bean
        MemberRepository memberRepository1() {
            return new MysqlDbMemberRepository();
        }

        @Bean
        MemberRepository memberRepository2() {
            return new MysqlDbMemberRepository();
        }
    }
}
