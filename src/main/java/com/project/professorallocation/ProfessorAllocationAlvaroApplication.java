package com.project.professorallocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfessorAllocationAlvaroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessorAllocationAlvaroApplication.class, args);
	}
//curl -v --request POST --header "Content-Type: application/json" --header "Accept: application/json" --data-raw "{\"name\": \"Chemistry Department\"}" "http://localhost:8080/departments"
}

//curl -v --request POST --header "Content-Type: application/json" --header "Accept: application/json" --data-raw "{\"name\": \"Software Course\"}" "http://localhost:8080/courses"

//curl -v --request POST --header "Content-Type: application/json" --header "Accept: application/json" --data-raw "{\"name\": \"Álvaro\, \"cpf\": \"14486231465\, }" "http://localhost:8080/courses/3"