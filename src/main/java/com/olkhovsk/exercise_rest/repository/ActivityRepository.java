package com.olkhovsk.exercise_rest.repository;

import java.util.List;

import com.olkhovsk.exercise_rest.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivity();

}