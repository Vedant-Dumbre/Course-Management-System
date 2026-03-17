package org.tech.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tech.entity.Course;
import org.tech.entity.Subject;
import org.tech.entity.UpdateCourse;
import org.tech.entity.User;
import org.tech.repository.CourseRepository;

@Service("courseserv")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courserepo;
	@Override
	public boolean isAddCourse(Course course) {
		return courserepo.isAddCourse(course);
	}
	@Override
	public List<Course> viewCourse() {
		
		return courserepo.viewCourse();
	}
	@Override
	public boolean isDelete(int id) {
		return courserepo.isDelete(id);
	}
	@Override
	public Course getCourseById(int id) {
		
		return courserepo.getCourseById(id);
	}
	@Override
	public boolean isUpdateCourse(UpdateCourse uc) {
		
		return courserepo.isUpdateCourse(uc);
	}
	@Override
	public List<Course> searchCourse(String name) {
		// TODO Auto-generated method stub
		return courserepo.searchCourse(name);
	}
	@Override
	public List<Course> getCourseName() {
		
		return courserepo.getCourseName();
	}
	@Override
	public boolean isAddSubject(Subject sub) {
		
		return courserepo.isAddSubject(sub);
	}
	@Override
	public List<Subject> viewSubject() {
		return courserepo.viewSubject();
	}
	@Override
	public boolean isDeleteSub(int id) {
		
		return courserepo.isDeleteSub(id);
	}
	@Override
	public List<Subject> courseDetails(int id) {
		
		return courserepo.courseDetails(id);
	}
	@Override
	public boolean RegisterUser(User user) {
		
		return courserepo.RegisterUser(user);
	}

}
