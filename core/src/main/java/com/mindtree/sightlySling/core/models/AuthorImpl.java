package com.mindtree.sightlySling.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = Resource.class,adapters = Author.class)
public class AuthorImpl implements Author {
	
	private static final Logger LOG=LoggerFactory.getLogger(AuthorImpl.class);
	
  //@Default(values = "Pavan")
	
    @Inject
	String fname;
	
	@Inject
	String lname;
	
	@Inject
	boolean professor;

	@Override
	public String getFirstName() {
		return fname;
	}

	@Override
	public String getLastName() {
		return lname;
	}

	@Override
	public boolean getIsProfessor() {
		return professor;
	}

}
