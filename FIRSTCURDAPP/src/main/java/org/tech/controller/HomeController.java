package org.tech.controller;

import java.io.File;

import java.io.IOException;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import org.tech.config.WebAppInitilizer;
import org.tech.entity.*;
import org.tech.service.CourseService;

@Controller
public class HomeController {

	List<Course> list;

	@Autowired
	CourseService courseserv;

	@RequestMapping("/")
	public String getLogin() {
		return "HomePage";
	}
	@GetMapping("/dashboard")
	public String getHome()
	{
		return "HomePage";
	}
	@GetMapping("/reg")
	public String getSignupPage(Map<String, List> map)
	{
		list = courseserv.viewCourse();
		map.put("course", list);
		return "Registration";
	}
	@PostMapping("/register")
	public String isSignUp(User user,Map map)
	{
		System.out.println("user role id in controller--"+user.getRid());
		int rid=user.getRid();
		if(rid==1)
		{
			user.setRole_Name("Role_Teacher");
		}
		else
		{
			user.setRole_Name("Role_Student");
		}
		
		boolean b=courseserv.RegisterUser(user);
		if(b)
		{
			map.put("msg", "Registration Sucessfull..");
		}
		else
		{
			map.put("msg", "Registration Failed..");
		}
		return "Registration";
	}
	@GetMapping("/log")
	public String getFirstPage()
	{
		return "Login";
	}
	@GetMapping("/index")
	public String getindexPage()
	{
		
		
		return "index";
		
	}
	@GetMapping("/addcourse")
	public String addCourse() {
		return "AddCourse";
	}

	@PostMapping("/save")
	public String saveCourse(Course course, Map map) {

		boolean b = courseserv.isAddCourse(course);
		if (b)
		{
			map.put("msg", "Record save successfull...");
		} else {
			map.put("msg", "Record not save..");
		}

		return "AddCourse";
	}

	@GetMapping("/view")
	public String viewCourse(Map map) {
		list = courseserv.viewCourse();
		map.put("course", list);
		return "ViewCourse";
	}

	@GetMapping("/delete")
	public RedirectView DeleteRec(@RequestParam("del") Integer cid, Map map) {

		courseserv.isDelete(cid);
		RedirectView rd = new RedirectView();
		rd.setUrl("view");
		return rd;

	}

	// Alternate way to for Delete

	/*
	 * @GetMapping("/delete") public String DeleteRec(@RequestParam("cid") Integer
	 * cid, Map map) { courseserv.isDelete(cid); list=courseserv.viewCourse();
	 * map.put("course", list); return "ViewCourse"; }
	 */

	@GetMapping("/updt")
	public String isUpdate(@RequestParam("upd") Integer cid, Map map) {
		Course course = courseserv.getCourseById(cid);
		if (course != null) {
			map.put("cs", course);
		} else {
			map.put("msg", "Data not found ");
		}

		return "UpdateCourse";
	}

	@PostMapping("/update")
	public String updateDetails(UpdateCourse uc, Map map) {

		boolean b = courseserv.isUpdateCourse(uc);
		if (b) {
			map.put("msg", "Record Update Successfully");

		} else {
			map.put("msg", "Unable to udpate Record ..Some Problem is there");

		}
		list = courseserv.viewCourse();
		map.put("course", list);
		return "ViewCourse";
	}

	@GetMapping("/search")
	@ResponseBody
	public List searchCourse(@RequestParam("name") String name) {
		list = courseserv.searchCourse(name);
		return list;
	}

	@GetMapping("/addSub")
	public String AddSubject(Map map) {
		list = courseserv.viewCourse();
		map.put("course", list);

		return "AddSubject";
	}

	@PostMapping("/savesub")
	public String isSaveSub(Subject sub, Map map) {
		
		
		  MultipartFile pdf=sub.getPdf(); 		//whatever user upload we get in pdf variable
		 
		
		//String uploadDir="D:/Subject_PDF/";  //it shows on which location we have to store file
		
		  String uploadDir=WebAppInitilizer.pdfFilePath;
		  String filename=System.currentTimeMillis()+"_"+pdf.getOriginalFilename();  // it gives current time in minisec to store filename as unique
		File savefile=new File(uploadDir, filename);		//file object is created and at our given location given file name is pass like Path preparation
		try {
			pdf.transferTo(savefile); 				//very IMP method .. Ye actual me file ko server ke folder me save karti hai try-catch block generated automatically
			
		
		} 
		catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sub.setPdfPath(filename);				// we are passing file name to pojo class so that we can get in repository to store in DB
		

		boolean b = courseserv.isAddSubject(sub);
		if (b) {
			map.put("msg", "Subject Added successfully..");

		} else {
			map.put("msg", "Some Problem is there");

		}

		return "AddSubject";
	}

	@GetMapping("/viewsub")
	public String viewSubject(Map map) {
		List<Subject> list = courseserv.viewSubject();
		map.put("subject", list);
		return "ViewSubject";
	}

	@GetMapping("/deletesub")
	public RedirectView isDeleteSubject(@RequestParam("delsub") Integer id, Map map) {
		courseserv.isDeleteSub(id);
		RedirectView rd = new RedirectView();
		rd.setUrl("viewsub");
		return rd;
	}

	@GetMapping("/viewcd")
	public String viewCourseDetails(Map map) {
		list = courseserv.viewCourse();
		map.put("course", list);
		return "ViewCourseDetails";
	}

	@GetMapping("/coursedetail")
	public String CourseDetails(@RequestParam("cd") Integer id, Map map) {
		List<Subject> list = courseserv.courseDetails(id);
		map.put("coursedetail", list);
		Course course = courseserv.getCourseById(id);
		map.put("csname", course);
		return "CourseDetails";
	}

	/*
	 * @GetMapping("upload") public String uploadfile() { return "AddSubjet"; }
	 */
	
}
