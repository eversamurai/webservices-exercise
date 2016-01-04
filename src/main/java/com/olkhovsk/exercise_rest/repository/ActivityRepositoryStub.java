package com.olkhovsk.exercise_rest.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import com.olkhovsk.exercise_rest.model.Activity;
import com.olkhovsk.exercise_rest.model.User;

public class ActivityRepositoryStub implements ActivityRepository {
	private static List<Activity> data;
	private static int Id = 1;
	static {
		User user1 = new User();
		user1.setName("Odin");
		user1.setAge(3250);
		User user2 = new User();
		user2.setName("Thor");
		user2.setAge(2900);
		User user3 = new User();
		user3.setName("Loki");
		user3.setAge(2300);
		
		
		data = new ArrayList<Activity>();
		Activity act1 = new Activity();
		act1.setName("Runing");
		act1.setDuration(45);
		act1.setId(idCounter());
		act1.setUser(user3);
		data.add(act1);
		Activity act2 = new Activity();
		act2.setName("Swiming");
		act2.setDuration(120);
		act2.setId(idCounter());
		act2.setUser(user1);
		data.add(act2);
		Activity act3 = new Activity();
		act3.setName("Boxing");
		act3.setDuration(35);
		act3.setId(idCounter());
		act3.setUser(user2);
		data.add(act3);

	}

	
	@Override
	public List<Activity> findAllActivity() {
		return data;
	}

	public Activity getActivity(String activityId) {
		for (Activity activity : data) {
			if (activity.getId() == Integer.parseInt(activityId)) {
				return activity;
			}			
		}
		throw new RuntimeException("Activity NOT_FOUND");
		
	}

	public void createActivity(MultivaluedMap<String, String> formParam) {		
		Activity new_activity =  new Activity();
		new_activity.setName(formParam.getFirst("name"));
		new_activity.setDuration(Integer.parseInt(formParam.getFirst("duration")));
		new_activity.setId(idCounter());		
		data.add(new_activity);
		
	}

	public void createActivity(Activity activity) {
		activity.setId(idCounter());
		data.add(activity);
		
	}
	public static int idCounter(){
		int next_id = Id++; 
		return next_id;
	}

}
