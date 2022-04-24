package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorServiceTests {
	@Autowired
	ProfessorService service;

	@Test
	public void findAll() {
		List<Professor> items = service.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Professor item : items) {
			System.out.println(item);

		}
	}

	@Test
	public void create() {
		Professor professorBeingCreated = new Professor();
		professorBeingCreated.setNome("English Professor");
		professorBeingCreated.setCpf("19986574532");
		professorBeingCreated.setDepartmentId(11L);

		professorBeingCreated = service.create(professorBeingCreated);
		System.out.println(professorBeingCreated);
	}

	@Test
	public void update() {
		Professor professorBeingCreated = new Professor();
		professorBeingCreated.setId(5L);
		professorBeingCreated.setNome("Logystics Professor");
		professorBeingCreated.setCpf("6574633232");
		professorBeingCreated.setDepartmentId(12L);

		professorBeingCreated = service.create(professorBeingCreated);
		System.out.println(professorBeingCreated);

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
