package com.olkhovsk.exercise_rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.olkhovsk.exercise_rest.model.Activity;
import com.olkhovsk.exercise_rest.model.User;
import com.olkhovsk.exercise_rest.repository.ActivityRepositoryStub;

@Path("activityes")
public class ActivityResource {

	ActivityRepositoryStub dataStub = new ActivityRepositoryStub();
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Activity createActivity(Activity activity){
		System.out.println(activity.getName());
		System.out.println(activity.getId());
		dataStub.createActivity(activity);
		return activity;
	}
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Activity createActivityForm(MultivaluedMap<String, String> formParam){
		System.out.println("Data size" + dataStub.findAllActivity().size());
		dataStub.createActivity(formParam);
		System.out.println("Activity for name: "+formParam.getFirst("name")+" created");
		Integer id = dataStub.findAllActivity().size();
		return dataStub.getActivity(id.toString());
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> getAllActivities() {
		return dataStub.findAllActivity();
	}
	
	@GET
	@Path("{activityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Activity getActivity(@PathParam("activityId") String activityId){
		return dataStub.getActivity(activityId);
	}
	@GET
	@Path("{activityId}/user")
	@Produces(MediaType.APPLICATION_JSON)
	public User getActivityUser(@PathParam("activityId") String activityId){
		return dataStub.getActivity(activityId).getUser();
	}

}
