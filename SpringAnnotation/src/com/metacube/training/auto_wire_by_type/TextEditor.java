package com.metacube.training.auto_wire_by_type;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	private SpellChecker spellChecker;

	/**
	 * @return the spellChecker
	 */
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	/**
	 * @param spellChecker
	 *            the spellChecker to set
	 */
	@Autowired
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	/**
	 * method to show whether spellChecker is on or of
	 */
	public void showStatus() {

		System.out.print("Spell checker is ");
		if (spellChecker.isStatus())
			System.out.println("on");
		else
			System.out.println("off");
	}

}
