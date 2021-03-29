package com.mindtree.sightlySling.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mindtree.sightlySling.core.services.PageCreation23;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageCreationModel {
	
	@OSGiService
	private PageCreation23 service;
    
	private String message;
	
	@PostConstruct
	protected void init()
	{
		message="from page creation model";
		service.activate();
	}

	public String getMessage() {
		return message;
	}	
}
