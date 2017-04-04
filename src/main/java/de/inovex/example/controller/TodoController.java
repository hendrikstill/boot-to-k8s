package de.inovex.example.controller;

import de.inovex.example.model.Todo;
import de.inovex.example.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for Todos
 */
@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/todo/{todoId}")
    Todo getTodo(@PathVariable("todoId") Long id){
        return todoRepository.findOne(id);
    }

}
