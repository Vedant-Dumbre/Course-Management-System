package org.tech.repository;

import org.tech.entity.*;


import java.util.*;

public interface CourseRepository {
	public boolean isAddCourse(Course course);
	public List<Course> viewCourse();
	public boolean isDelete(int id);
	public Course getCourseById(int id);
	public boolean isUpdateCourse(UpdateCourse uc);
	public List<Course> searchCourse(String name);
	public List<Course> getCourseName();
	public boolean isAddSubject(Subject sub);
	public List<Subject> viewSubject();
	public boolean isDeleteSub(int id);
	public List<Subject> courseDetails(int id);
	public boolean RegisterUser(User user);
	

}
