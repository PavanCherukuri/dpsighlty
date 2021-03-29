package com.mindtree.sightlySling.core.services;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.mindtree.sightly.core.excels.Page2Excel;
import com.mindtree.sightly.core.excels.PagePojos2;


@Component(service = PageCreation23.class, immediate = true)
public class PageCreationImpl23 implements PageCreation23 {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Reference
	ResourceResolverFactory resolverFactory;
	ResourceResolver resolver;

	@Activate
	@Modified
	public void activate() {


		logger.info("Entered Activate Method at 6:00");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ResourceResolverFactory.SUBSERVICE, "sightlyslingmanagement");
		ResourceResolver resourceResolver=null;
		
		
		try {
			logger.info("in Activate Method at 6:00");
			resourceResolver = resolverFactory.getServiceResourceResolver(param);
			// creating a resource
			Resource pageResource = resourceResolver.getResource("/content/sightlySling/e");
			if(pageResource == null) {
				logger.info("resource is null at 6:00");
				return;
			}
			
			//creating a session a using the above resource
			Session session = pageResource.getResourceResolver().adaptTo(Session.class);
			if(session == null) {
				logger.info("pageManager is null");
				return;
			}
			
			// creating a page manager using the above resource
			logger.info("Page Resource have some value in it, at 6:00");
			PageManager pageManager= pageResource.getResourceResolver().adaptTo(PageManager.class);
			if(pageManager == null) {
				logger.info("pageManager is null");
				return;
			}
			
			logger.info("all good, going to create a newPage, at 6:00");
			
			List<PagePojos2> datas=new ArrayList<>();
			Page2Excel obj=new Page2Excel();
			try {
				datas.addAll(obj.returnDataToService());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			for(PagePojos2 items:datas) {
			String pageName=items.getPageName();
			String pagePath = items.getPagePath();
			String templatePath = items.getTemplatePath();
			String pageTitle = items.getPageTitle();
			
			Page newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
			
			if(newPage != null) {
				logger.info("new page is not null, it has some information. ");
				
				Node newNode= newPage.adaptTo(Node.class);
				Node cont= newNode.getNode("jcr:content");
				if(cont != null) {
					logger.info("content node has some information.");
					
					Node rootNode= session.getRootNode();
					String path = rootNode.getPath();
					Node parNode = JcrUtils.getNodeIfExists(cont, "root");
					Node textNode = JcrUtils.getNodeIfExists(parNode, "o2pdp");
					textNode.setProperty("category",items.getCategory());
					textNode.setProperty("title", items.getTitle());
					textNode.setProperty("description", items.getDescription());
					textNode.setProperty("aboutPoint1", items.getAbt1());
					textNode.setProperty("aboutPoint2", items.getAbt2());
					textNode.setProperty("aboutPoint2", items.getAbt3());
					textNode.setProperty("price", items.getPrice());
					textNode.setProperty("fileReference", items.getImagePath());
					textNode.setProperty("offer1", items.getOffer1());
					textNode.setProperty("offer2", items.getOffer2());
					
					session.save();
				}
			}
			}
			
			logger.info("Session is saved.... ");
			
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (WCMException e) {
			e.printStackTrace();
		} catch (PathNotFoundException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
		logger.info("End of activate method at 6:00");
		return;
	}


}
