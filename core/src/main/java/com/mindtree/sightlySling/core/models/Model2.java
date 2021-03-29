package com.mindtree.sightlySling.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Model2 {

	@ScriptVariable
	Page currentPage;
	
	//@Via("resource")
	//@Self
	//httre
	//@SlingObject
	//ResourceResolver resourceResolver;

	@Inject
	@Via("resource")
	String fname;

	
	@Default(values="pavan")
	@ValueMapValue
	String lname;
	
	@RequestAttribute(name="rAttribute")
	private String reqAttribute;

	@ResourcePath(path="/content/sightlySling/en/de")@Via("resource")
	Resource resource;
	
	@Inject
	@Via("resource")
	@Named("jcr:lastModifiedBy")
	String modifiedBy;
	
	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}
	
	public String getCurrentPage()
	{
		return currentPage.getPath();
	}
	

	public String getReqAttribute() {
		return reqAttribute;
	}

	
	public String getResource() {
		return resource.getName();
	}
	
	
	public String getModifiedBy() {
		return modifiedBy;
	}

	@PostConstruct
	protected void init()
	{
		
	}
}
