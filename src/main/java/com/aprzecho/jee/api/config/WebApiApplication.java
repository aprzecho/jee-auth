package com.aprzecho.jee.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.aprzecho.jee.api.AuctionsApi;
import com.aprzecho.jee.api.HelloApi;

public class WebApiApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(HelloApi.class);
        s.add(AuctionsApi.class);
        return s;
    }
	
}
