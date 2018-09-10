package com.metacube.training.set_injection;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Course course = (Course) factory.getBean("course");
        Set<String> setOfSubjects = course.getSetOfSubjects();
        System.out.println(setOfSubjects.toString());

    }

}
