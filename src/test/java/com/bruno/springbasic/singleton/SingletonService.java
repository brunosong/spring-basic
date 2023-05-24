package com.bruno.springbasic.singleton;

public class SingletonService {

    private static final SingletonService singleTonService = new SingletonService();

    private SingletonService() {}

    public static SingletonService getInstance(){
        return singleTonService;
    }

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }

}
