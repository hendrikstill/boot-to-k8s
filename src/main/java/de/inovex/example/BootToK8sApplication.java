package de.inovex.example;

import de.inovex.example.model.Todo;
import de.inovex.example.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BootToK8sApplication {

	@Autowired
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootToK8sApplication.class, args);
	}

	@PostConstruct
	public void init(){

		Todo todo = new Todo(1L, "Install Kubernetes", false);
		todoRepository.save(todo);

		todo = new Todo(2L ,"Run Whalesay on docker",true);
		todoRepository.save(todo);
	}
}
