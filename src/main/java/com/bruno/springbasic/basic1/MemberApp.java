package com.bruno.springbasic.basic1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        //스프링컨테이너를 도데체 쓰는 이유가 뭘까?
        //어마어마한 장점이 있다. 스프링컨테이너가 빈들을 관리해주기 때문에 많은것들을 할수 있다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //OCP랑 DIP를 지키기 위해서는 뭔가가 더 필요했다. 그래서 스프링이 나옴 SOLID를 지키는게 중요하다.

    }

}
