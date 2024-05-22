package com.example.tasks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tasks.model.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
	public List<Tasks> findByNameLike(String key);
	public List<Tasks> findByDate(java.sql.Date date);
}
