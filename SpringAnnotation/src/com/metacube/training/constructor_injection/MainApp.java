package com.metacube.training.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.showStatus();
	}

}
