package com.example.tasks.data;

import java.sql.Date;

public interface TasksDataInterface {
	public int getId();
	public void setId(int id);
	public String getName();
	public void setName(String name);
	public java.sql.Date getDate();
	public void setDate(Date date);
	public boolean getCompleted();
	public void setCompleted(boolean completed);
}
