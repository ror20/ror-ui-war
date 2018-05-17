package com.ror.model;

import java.util.Date;

public class RORUserToken {

	private String token;
	private Date date;

	public RORUserToken() {

	}

	public RORUserToken(String token, Date date) {
		super();
		this.token = token;
		this.date = date;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "RORUserToken [token=" + token + ", date=" + date + "]";
	}

}
