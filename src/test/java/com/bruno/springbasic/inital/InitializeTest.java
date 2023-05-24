package com.bruno.springbasic.inital;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class InitializeTest {


    @Test
    void test(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class, LifeCycleConfigV2.class);
        NetworkClientV1 networkClientV1 = ac.getBean(NetworkClientV1.class);
        networkClientV1.call("테스트");

        NetworkClientV2 networkClientV2 = ac.getBean(NetworkClientV2.class);
        networkClientV2.call("테스트2");

        ac.close();
    }


    @Configuration
    static class LifeCycleConfig {

        // implements InitializingBean, DisposableBean 사용
        @Bean
        public NetworkClientV1 networkClientV1() {
            NetworkClientV1 networkClientV1 = new NetworkClientV1();
            networkClientV1.setUrl("http://hello-spring.dev");
            return networkClientV1;
        }

    }


    @Configuration
    static class LifeCycleConfigV2 {

//        @Bean의 destroyMethod 속성에는 아주 특별한 기능이 있다.
//        라이브러리는 대부분 close , shutdown 이라는 이름의 종료 메서드를 사용한다.
//        @Bean의 destroyMethod 는 기본값이 (inferred) (추론)으로 등록되어 있다.
//        이 추론 기능은 close , shutdown 라는 이름의 메서드를 자동으로 호출해준다. 이름 그대로 종료
//        메서드를 추론해서 호출해준다.
//        따라서 직접 스프링 빈으로 등록하면 종료 메서드는 따로 적어주지 않아도 잘 동작한다.
//        추론 기능을 사용하기 싫으면 destroyMethod="" 처럼 빈 공백을 지정하면 된다.

        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClientV2 networkClientV2() {
            NetworkClientV2 networkClient = new NetworkClientV2();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }

    }



    @Configuration
    static class LifeCycleConfigV3 {


//        @PostConstruct, @PreDestroy 애노테이션 특징
//        최신 스프링에서 가장 권장하는 방법이다.
//        애노테이션 하나만 붙이면 되므로 매우 편리하다.
//        패키지를 잘 보면 javax.annotation.PostConstruct 이다. 스프링에 종속적인 기술이 아니라 JSR-250 라는 자바 표준이다.
//        따라서 스프링이 아닌 다른 컨테이너에서도 동작한다.
//        컴포넌트 스캔과 잘 어울린다.
//        유일한 단점은 외부 라이브러리에는 적용하지 못한다는 것이다. 외부 라이브러리를 초기화, 종료 해야 하면
//        @Bean의 기능을 사용하자.

//        정리
//        @PostConstruct, @PreDestroy 애노테이션을 사용하자
//        코드를 고칠 수 없는 외부 라이브러리를 초기화, 종료해야 하면 @Bean 의 initMethod , destroyMethod 를 사용하자

        @Bean
        public NetworkClientV3 networkClientV3() {
            NetworkClientV3 networkClient = new NetworkClientV3();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }

    }



}
