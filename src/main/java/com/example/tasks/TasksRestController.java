package com.example.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tasks.data.TasksDataInterface;
import com.example.tasks.data.TasksDataService;
import com.example.tasks.model.Tasks;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TasksRestController {
	@Autowired
	TasksDataService service;
	
	@GetMapping("/tasks")
	public List<? extends TasksDataInterface> Tasks() {
		System.out.println("tasks/index");
		return service.getAll();
	}
	

	
	@PostMapping("/tasks/add")
	public int add(@RequestBody Tasks task) {
		System.out.println("tasks/add(post)");
		return service.add(task);
	}
	
	@PostMapping("/tasks/update")
	public void update(@RequestBody Tasks task) {
		System.out.println("Apartment/update(post)");
		service.update(task);
	}
}
