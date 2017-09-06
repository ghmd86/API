package com.phillips.oitservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class OITServiceApplication extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		System.out.println("HELLOOOO ");
		// TODO Auto-generated method stub
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(OITResource.class);
		return classes;
	}

}
