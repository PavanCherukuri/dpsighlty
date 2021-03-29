package com.mindtree.sightlySling.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OutsideData {

	@Inject
	String text;
	
	@Inject
	String text2;
	
	@Inject
	String text3;
	
	@PostConstruct
	protected void init() {
	text="pavan";
	text2="teja";
	text3="prasad";
	}

	public String getText() {
		return text;
	}

	public String getText2() {
		return text2;
	}

	public String getText3() {
		return text3;
	}
	
}
