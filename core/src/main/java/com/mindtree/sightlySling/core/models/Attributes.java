package com.mindtree.sightlySling.core.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Attributes {

	private Map<String,String> attributes;

	public Map<String, String> getAttributes() {
	    Map<String,String> mapper=new HashMap<>();
	    mapper.put("att1","pavan");
	    mapper.put("att2","teja");
	    mapper.put("att3","prasad");
	    mapper.put("att4","lakshmi");
		return mapper;
	}
	
}
