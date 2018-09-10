package com.metacube.training.auto_wire_by_constructor;

public class SpellChecker {

	private boolean status;

	/**
	 * @param status
	 */
	public SpellChecker(boolean status) {

		this.status = status;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

}
