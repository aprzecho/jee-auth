package com.aprzecho.jee.web.common;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

public interface PageContext extends Serializable {

  FacesContext getFacesContext();

  Map<String, Object> getSessionMap();

  Map<String, Object> getRequestMap();

  String getRequestParam(String name);

  void invalidateSession();

  void addGlobalOnlyMessage(String message);

  void addGlobalOnlyErrorMessage(String message);

  void addGlobalOnlyInfoMessage(String message);

  void addGlobalOnlyMessageWithKey(String messageKey, Object... parameters);

  void addGlobalOnlyErrorMessageWithKey(String messageKey, Object... parameters);

  void addGlobalOnlyInfoMessageWithKey(String messageKey, Object... parameters);

  String getMessage(String messageKey, Object... parameters);
}
