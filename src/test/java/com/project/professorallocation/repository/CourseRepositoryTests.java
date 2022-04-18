package com.project.professorallocation.repository;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CourseRepositoryTests {

	@Autowired
	CourseRepository repository;

	@Test
	public void findAll() {
		List<Course> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Course item : items) {
			System.out.println(item);

		}
	}

	@Test
	public void findSpecificCourse() {
		Course cour = repository.findById(6L).orElse(null);
		System.out.println(cour);
	}

	@Test
	public void findCourseByPartOfName() {
		List<Course> cours = repository.findByNameLike("%cs%");
		cours.forEach(System.out::println);
	}

	@Test
	public void create() {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setNome("Biophysics Course");

		courseBeingCreated = repository.save(courseBeingCreated);
		System.out.println(courseBeingCreated);
	}

	@Test
	public void update() {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setId(1L);
		courseBeingCreated.setNome("Physics Course");

		courseBeingCreated = repository.save(courseBeingCreated);
		System.out.println(courseBeingCreated);

	}

	@Test
	public void delete() {
		repository.deleteById(6L);

	}

	@Test
	public void deleteAll() {
		repository.deleteAllInBatch();

	}

}
