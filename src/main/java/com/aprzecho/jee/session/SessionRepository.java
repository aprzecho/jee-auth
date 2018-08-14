package com.aprzecho.jee.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SessionRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getCurrentUsername() {
		return "system";
	}
}
