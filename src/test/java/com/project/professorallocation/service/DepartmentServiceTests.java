package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Department;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentServiceTests {
	@Autowired
	DepartmentService service;

	@Test
	public void findAll() {
		List<Department> items = service.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Department item : items) {
			System.out.println(item);

		}
	}

	@Test
	public void create() {
		Department departmentBeingCreated = new Department();
		departmentBeingCreated.setName("Biotecnology Department");

		departmentBeingCreated = service.create(departmentBeingCreated);
		System.out.println(departmentBeingCreated);
	}

	@Test
	public void update() {
		Department departmentBeingCreated = new Department();
		departmentBeingCreated.setId(12L);
		departmentBeingCreated.setName("Physics Department");

		departmentBeingCreated = service.create(departmentBeingCreated);
		System.out.println(departmentBeingCreated);

	}

	@Test
	public void deleteById() {
		service.deleteById(12L);

	}

	@Test
	public void findById() {
		service.findById(13L);
	}
}
