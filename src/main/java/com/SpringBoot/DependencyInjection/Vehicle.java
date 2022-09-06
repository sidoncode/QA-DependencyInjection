package com.SpringBoot.DependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vehicle {
    IEngine iEngine;
    Tyres tyres;

    public IEngine getiEngine() {
        return iEngine;
    }

    public void setiEngine(IEngine iEngine) {
        this.iEngine = iEngine;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    public Vehicle(IEngine iEngine, Tyres tyres){
        System.out.println("instantiated via constuctor");
        this.iEngine = iEngine;
        this.tyres = tyres;
    }

    public Vehicle(){}

    @Override
    public String toString(){
        return iEngine + "" + tyres;
    }

    public static void main(String[] args) {

        ApplicationContext rootctx = new ClassPathXmlApplicationContext("beans.xml");

        // instantiating the obj1 via constuctor DI
        Vehicle obj1 = (Vehicle) rootctx.getBean("Constructor");


        // instantiating the obj1 via constuctor DI
        Vehicle obj2 = (Vehicle) rootctx.getBean("Setter");

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj1 == obj2);

    }

}
