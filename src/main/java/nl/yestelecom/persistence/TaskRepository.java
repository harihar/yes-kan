package nl.yestelecom.persistence;

import nl.yestelecom.model.Task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {

}
