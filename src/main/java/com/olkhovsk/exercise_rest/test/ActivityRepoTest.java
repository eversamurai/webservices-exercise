package com.olkhovsk.exercise_rest.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.olkhovsk.exercise_rest.repository.ActivityRepositoryStub;

public class ActivityRepoTest {

	ActivityRepositoryStub data = new ActivityRepositoryStub();

	@Test
	public void activityRepoTest() {

		assertEquals(3, data.findAllActivity().size());

	}

	@Test
	public void findeActivityById() {

		assertEquals(data.findAllActivity().get(1), data.getActivity("2"));

	}

}
