package com.example.tasks.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tasks.model.Tasks;
import com.example.tasks.repositories.TasksRepository;

@Service
public class TasksDataService {
	@Autowired
	private TasksRepository repository;
	
	public List<? extends TasksDataInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}
	
	public int add(Tasks item) {
		System.out.println("Service:add [" + item + "]");
		if (item instanceof Tasks) {
			Tasks savedItem = repository.saveAndFlush((Tasks) item);
			return savedItem.getId();
		}
		return 0;
	}
	
	public List<? extends TasksDataInterface> findBySelectDate(Tasks task) {
		System.out.println("Service:findBydate");
		return repository.findByDate(task.getDate());
	}
	
	public void update(TasksDataInterface item) {
		System.out.println("Service:update[" + item + "]");
		if (item instanceof Tasks) {
			Tasks task = (Tasks) item;
			if (repository.existsById(task.getId())) {
				repository.saveAndFlush(task);
			} else {
				System.out.println("Fruit not found with id: " + task.getId());
			}
		}
	}
}
