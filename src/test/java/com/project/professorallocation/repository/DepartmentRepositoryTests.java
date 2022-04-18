package com.project.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTests {

	@Autowired
	DepartmentRepository repository;

	@Test
	public void findAll() {
		List<Department> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Department item : items) {
			System.out.println(item);

		}

	}

	@Test
	public void findSpecificDepartment() {
		Department dept = repository.findById(7L).orElse(null);
		System.out.println(dept);
	}

	@Test
	public void findDepartmentByPartOfName() {
		List<Department> depts = repository.findByNameLike("%tec%");
		depts.forEach(System.out::println);
	}

	@Test
	public void create() {
		Department departmentBeingCreated = new Department();
		departmentBeingCreated.setNome("Biotecnology Department");

		departmentBeingCreated = repository.save(departmentBeingCreated);
		System.out.println(departmentBeingCreated);
	}

	@Test
	public void update() {
		Department departmentBeingCreated = new Department();
		departmentBeingCreated.setId(11L);
		departmentBeingCreated.setNome("Tecnology Department");

		departmentBeingCreated = repository.save(departmentBeingCreated);
		System.out.println(departmentBeingCreated);

	}

	@Test
	public void delete() {
		repository.deleteById(8L);

	}

	@Test
	public void deleteAllItems() {
		repository.deleteAllInBatch();

	}

}