package org.tech.repository;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.tech.entity.Course;
import org.tech.entity.Subject;
import org.tech.entity.UpdateCourse;
import org.tech.entity.User;

@Repository("courserepo")
public class CourseRepositoryImpl implements CourseRepository {

	@Autowired
	JdbcTemplate template;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public boolean isAddCourse(Course course) {
		int val = template.update("insert into course values('0',?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, course.getCname());

			}

		});

		if (val > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Course> viewCourse() {

		List<Course> list = template.query("select * from course", new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course cs = new Course();
				cs.setId(rs.getInt(1));
				cs.setCname(rs.getString(2));
				return cs;
			}

		});
		return list;
	}

	@Override
	public boolean isDelete(int id) {

		int val = template.update("delete from course where cid=?", new Object[] { id });
		if (val > 0) {
			List list = template.query("select max(cid) from course", (rs, rowNum) -> rs.getInt(1));
			int maxid = (int) list.get(0);
			int temp=template.update("alter table course auto_increment=?", new Object[] {maxid});
			if(temp>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public Course getCourseById(int cid) {

		Course list = template.queryForObject("select * from course where cid=?", new Object[] { cid },
				new RowMapper<Course>() {

					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setId(rs.getInt(1));
						course.setCname(rs.getString(2));
						return course;
					}

				});

		return list;
	}

	@Override
	public boolean isUpdateCourse(UpdateCourse uc) {
		int val = template.update("update course set cname=? where cid=?", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, uc.getUcname());
				ps.setInt(2, uc.getUcid());
			}
		});
		if (val > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Course> searchCourse(String name) {
		List list = template.query("select * from course where cname like '%" + name + "%'", new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course cs = new Course();
				cs.setId(rs.getInt(1));
				cs.setCname(rs.getString(2));
				return cs;
			}

		});
		return list;
	}

	@Override
	public List<Course> getCourseName() {
		List list = template.query("select cname from course", (rs, rowNum) -> rs.getString("cname"));
		return list;
	}

	@Override
	public boolean isAddSubject(Subject sub) {
		int val = template.update("insert into subject values('0',?,?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, sub.getSname());
				ps.setString(2, sub.getPdfPath());

			}

		});

		if (val > 0) {

			List<String> str = sub.getCsVal();
			// System.out.print("String is---"+str);
			List<Integer> list = template.query("select max(sid) from subject", (rs, rowNum) -> rs.getInt(1));
			int maxid = list.get(0);
			// System.out.print("value of max id is--"+maxid);
			//String[] a = str.split(",");
			// System.out.print("String length--"+a.length);
			int temp = 0;
			int val1 = 0;
			for (int i = 0; i < str.size(); i++) {
				temp = Integer.parseInt(str.get(i));
				val1 = template.update("insert into coursesubject values(?,?)", new Object[] { temp, maxid });
				temp = 0;
			}
			if (val1 > 0) 
			{
				return true;
			}
			else
			{
				return false;
			}

		} else {
			return false;
		}
	}

	@Override
	public List<Subject> viewSubject() {
		List list=template.query("select * from subject", new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject s=new Subject();
				s.setId(rs.getInt(1));
				s.setSname(rs.getString(2));
				return s;
			}
			
		});
		return list;
	}

	@Override
	public boolean isDeleteSub(int id) {
		int val=template.update("delete from subject where sid=?", new Object[] {id});
		if(val>0)
		{
			List list = template.query("select max(sid) from subject", (rs, rowNum) -> rs.getInt(1));
			int maxid = (int) list.get(0);
			int temp=template.update("alter table subject auto_increment=?", new Object[] {maxid});
			if(temp>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<Subject> courseDetails(int id) {
		List<Subject> list=template.query("select s.sid,s.sname,s.pdfPath from subject s left join coursesubject cs on s.sid=cs.sid where cid=?", new Object[] {id}, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject s=new Subject();
				s.setId(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setPdfPath(rs.getString(3));
				return s;
			}
			
		});
		return list;
	}

	@Override
	public boolean RegisterUser(User user) {
		
		String originalPass=user.getPassword();
		String encryptedPass=this.passwordEncoder.encode(originalPass);
		int val=template.update("insert into User(name,email,uname,password,contact,roleId,Role) values(?,?,?,?,?,?,?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getUname());
				ps.setString(4, encryptedPass);
				ps.setString(5, user.getContact());
				ps.setInt(6, user.getRid());
				ps.setString(7, user.getRole_Name());
				
			}
			
		});
		if(val>0)
		{
			List<String> str=user.getUsercourse();
			List<Integer> list=template.query("select max(uid) from user", (rs, rowNum) -> rs.getInt(1));
			int max=list.get(0);
			int temp=0;
			int val1=0;
			for(int i=0;i<str.size();i++)
			{
				temp=Integer.parseInt(str.get(i));
				val1=template.update("insert into usersub values(?,?)", new Object[] {max,temp});
				temp=0;
				
			}
			if(val1>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}


}
