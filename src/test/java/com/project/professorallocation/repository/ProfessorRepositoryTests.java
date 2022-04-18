package com.project.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorRepositoryTests {

	@Autowired
	ProfessorRepository repository;

	@Test
	public void findAll() {
		List<Professor> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Professor item : items) {
			System.out.println(item);

		}
	}

	@Test
	public void findSpecificProfessor() {
		Professor prof = repository.findById(2L).orElse(null);
		System.out.println(prof);

	}

	@Test
	public void findProfessorByNameLike() {
		List<Professor> profs = repository.findByNameLike("%al%");
		profs.forEach(System.out::println);

	}

	@Test
	public void create() {
		Professor professorBeingCreated = new Professor();
		professorBeingCreated.setNome("Professor Álvaro");
		professorBeingCreated.setCpf("14486231465");
		professorBeingCreated.setDepartmentId(11L);

		professorBeingCreated = repository.save(professorBeingCreated);
		System.out.println(professorBeingCreated);
	}

	@Test
	public void update() {
		Professor professorBeingCreated = new Professor();
		professorBeingCreated.setId(2L);
		professorBeingCreated.setNome("Professor Juvenal");
		professorBeingCreated.setCpf("98727364754");
		professorBeingCreated.setDepartmentId(7L);

		professorBeingCreated = repository.save(professorBeingCreated);
		System.out.println(professorBeingCreated);

	}

	@Test
	public void delete() {
		repository.deleteById(2L);

	}

	@Test
	public void deleteAll() {
		repository.deleteAllInBatch();

	}

}
