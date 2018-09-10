package com.metacube.training.auto_wire_by_constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		TextEditor textEditor = (TextEditor) factory.getBean("textEditor");
		textEditor.showStatus();
	}

}
