package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertoken")
public class UserToken {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "resettoken")
	private String resetToken;

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the resetToken
	 */
	public String getResetToken() {
		return resetToken;
	}

	/**
	 * @param resetToken
	 *            the resetToken to set
	 */
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	@Override
	public String toString() {
		return "UserToken [emailId=" + emailId + ", resetToken=" + resetToken + "]";
	}
}
