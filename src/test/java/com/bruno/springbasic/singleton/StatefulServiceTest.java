package com.bruno.springbasic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService userA = ac.getBean(StatefulService.class);
        StatefulService userB = ac.getBean(StatefulService.class);

        //Thread A
        userA.order("itemA", 5000);

        //Thread B
        userA.order("itemB", 7000);

        System.out.println(userA.getPrice());
        System.out.println(userB.getPrice());

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }

}