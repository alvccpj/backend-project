package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class CourseServiceTests {
	@Autowired
	CourseService service;

	@Test
	public void findAll() {
		List<Course> items = service.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Course item : items) {
			System.out.println(item);

		}
	}

	@Test
	public void create() {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setNome("Engineering Course");

		courseBeingCreated = service.create(courseBeingCreated);
		System.out.println(courseBeingCreated);
	}

	@Test
	public void update() {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setId(5L);
		courseBeingCreated.setNome("Math Course");

		courseBeingCreated = service.create(courseBeingCreated);
		System.out.println(courseBeingCreated);

	}

	@Test
	public void deleteById() {
		service.deleteById(4L);

	}

	@Test
	public void findById() {
		service.findById(5L);
	}
}
