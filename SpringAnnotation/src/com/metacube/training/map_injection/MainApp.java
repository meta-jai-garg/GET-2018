package com.metacube.training.map_injection;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Exam exam = (Exam) factory.getBean("exam");
        Map<String, Double> averageMarksOfSubjects = exam.getAverageMarksOfSubjects();
        System.out.println(averageMarksOfSubjects.toString());
    }

}
