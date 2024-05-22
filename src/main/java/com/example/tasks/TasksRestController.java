package com.example.tasks;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/tasks/find")
    public List<? extends TasksDataInterface> find(@RequestParam(required = false) String dateStr) {
        System.out.println("tasks/find");
        // 文字列から java.sql.Date に変換する
        Date date = null;
        if (dateStr != null && !dateStr.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate = sdf.parse(dateStr);
                date = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                // 例外処理
                e.printStackTrace();
            }
        }
        return service.findBySelectDate(date);
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
	
	@PostMapping("/tasks/delete")
	public void delete(@RequestBody Tasks task) {
		System.out.println("tasks/delete(post)");
		service.delete(task);
	}
		
}
