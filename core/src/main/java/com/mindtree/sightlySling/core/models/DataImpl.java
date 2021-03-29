package com.mindtree.sightlySling.core.models;
import java.util.*;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
@Model(adaptables = Resource.class,adapters = Data.class)
public class DataImpl implements Data {


	@Override
	public DataBean getFlowerInfo() {
        DataBean dataBean=new DataBean();
        dataBean.setFirstName("Pavan");
        dataBean.setLastname("Cherukuri");
        List<String> flowers=new ArrayList<String>();
        flowers.add("rose");
        flowers.add("jasmine");
        flowers.add("cactus");
        dataBean.setFlowers(flowers);
        return dataBean; 
	}

}
