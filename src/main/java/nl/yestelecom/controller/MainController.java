package nl.yestelecom.controller;

import nl.yestelecom.model.Task;
import nl.yestelecom.persistence.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@RequestMapping("/")
	public String hello(){
		return "Hello World!";
	}
	
	@RequestMapping("/test")
	public Iterable<Task> test(){
		return taskRepo.findAll();
	}
	
	@RequestMapping("/{taskName}")
	public void insert(@PathVariable String taskName){
		taskRepo.save(new Task(taskName));
	}
	
	
}
