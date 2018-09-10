package com.metacube.training.setter_injection;

public class SpellChecker {

	private boolean status;

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

}
