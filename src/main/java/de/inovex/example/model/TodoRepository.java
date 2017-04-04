package de.inovex.example.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Data Repository to do CRUD operations on todos
 */
public interface TodoRepository extends CrudRepository<Todo,Long> {

    List<Todo> findByDone(boolean done);

}
