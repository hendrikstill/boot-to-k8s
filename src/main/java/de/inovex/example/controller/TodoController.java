package de.inovex.example.controller;

import de.inovex.example.model.Todo;
import de.inovex.example.model.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for Todos
 */
@RestController
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/todo/{todoId}")
    Todo getTodo(@PathVariable("todoId") Long id){
        logger.info("Accessed single todo {}",id);
        return todoRepository.findOne(id);
    }

    @RequestMapping("/todo")
    Iterable<Todo> getAll(){
        logger.info("Accessed all todos");
        return todoRepository.findAll();
    }

    @RequestMapping("/todo/undone")
    Iterable<Todo> getAllUndone(){
        logger.info("Accessed all undone todos");
        return todoRepository.findByDone(false);
    }

}
