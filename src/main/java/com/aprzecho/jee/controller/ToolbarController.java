package com.aprzecho.jee.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.aprzecho.jee.session.SessionRepository;
import com.aprzecho.jee.web.common.PageContext;

@RequestScoped
@Named
public class ToolbarController {

	@Inject
	SessionRepository sessionRepository;
	
	@Inject
	PageContext pageContext;
	
	public boolean getUserLogged() {
		return pageContext.getFacesContext().getExternalContext().getUserPrincipal() != null;
	}
	
	public String getCurrentUsername() {
		return pageContext.getFacesContext().getExternalContext().getRemoteUser();
	}
}
