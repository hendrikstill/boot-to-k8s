package de.inovex.example.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Data Repository to do CRUD operations on todos
 */
public interface TodoRepository extends CrudRepository<Todo,Long> {

}
