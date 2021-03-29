package com.mindtree.sightlySling.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class SlyTags {

	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@Inject
	private String name;
	
	@Inject
	private boolean gender;
	
	@Inject
	private String path;
	
	@Inject
	private List<String> books;
	
	@Inject
	private String selectit;

	public String getName() {
		return name;
	}

	public List<String> getBooks() {
		if(books!=null)
		{
		return new ArrayList<String>(books);
		}
		else
		{
			return Collections.emptyList();
		}
	}
	
	@PostConstruct
	protected void init()
	{
		logger.info("name : "+name);
		logger.info("gender : "+gender);
		logger.info("path : "+path);
		logger.info("option : "+selectit);
		logger.info("list : "+books);
	}
	
	
	
}
