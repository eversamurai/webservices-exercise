package com.olkhovsk.exercise_rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.olkhovsk.exercise_rest.model.Activity;
import com.olkhovsk.exercise_rest.model.User;
import com.olkhovsk.exercise_rest.repository.ActivityRepositoryStub;

@Path("activity")
public class ActivityResource {

	ActivityRepositoryStub dataStub = new ActivityRepositoryStub();

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
