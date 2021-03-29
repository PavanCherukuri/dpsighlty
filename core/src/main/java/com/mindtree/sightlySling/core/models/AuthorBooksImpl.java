package com.mindtree.sightlySling.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,adapters = AuthorBooks.class)
public class AuthorBooksImpl implements AuthorBooks {

	@Inject
	private String authorname;
	
	@Inject
	private List<String> books;
	
	@Override
	public String getAuthorName() {
		return authorname;
	}

	@Override
	public List<String> getAuthorBooks() {
		if(books!=null) {
		return new ArrayList<String>(books);
		}else
		{
			return Collections.emptyList();
		}
	}

}
