package com.metacube.training.auto_wire_by_constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public TextEditor textEditor() {

		return new TextEditor(spellChecker());
	}

	@Bean
	public SpellChecker spellChecker() {

		return new SpellChecker(true);
	}
}
