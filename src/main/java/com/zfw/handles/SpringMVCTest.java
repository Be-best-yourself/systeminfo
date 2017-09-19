package com.zfw.handles;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zfw.entity.Student;
import com.zfw.service.StudentService;

@Controller
@RequestMapping("/test")
public class SpringMVCTest extends AbstractController{
	@Autowired
	private StudentService studentService;

	@RequestMapping("/test.do")
	public void test(HttpServletRequest request) {
		System.out.println("===================" + studentService);
		studentService.addStudent(new Student("zhangsan", 12, 23.0));
	}

	@RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
	public ModelAndView getUserById(@PathVariable int id,ModelMap model) {
		Student student = studentService.findStudentById(id);
		this.success(model, student);
		return new ModelAndView("student");
	}
}
