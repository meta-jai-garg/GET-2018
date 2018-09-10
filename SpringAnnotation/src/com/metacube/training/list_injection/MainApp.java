package com.metacube.training.list_injection;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Course course = (Course) factory.getBean("course");
		List<String> listOfSubjects = course.getListOfSubjects();
		System.out.println(listOfSubjects.toString());

	}

}
