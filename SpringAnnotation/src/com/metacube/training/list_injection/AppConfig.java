package com.metacube.training.list_injection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Course course() {
		Course course = new Course();
		List<String> listOfSubjects = new ArrayList<String>();
		listOfSubjects.add("Physics");
		listOfSubjects.add("Chemistry");
		listOfSubjects.add("Mathematics");
		course.setListOfSubjects(listOfSubjects);
		return course;
	}

}
