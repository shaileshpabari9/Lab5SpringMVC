package com.GL.StudentBookingpr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.GL.StudentBookingpr.DAO.DAO;
import com.GL.StudentBookingpr.Model.Student;

@Controller
@RequestMapping("Student")
public class StudentController {

	@Autowired
	DAO dao;

	@GetMapping("List")
	public String StudentList(Model model) {

		List<Student> students = dao.findAll();
		model.addAttribute("students", students);
		return "List-Student";
	}

	@GetMapping("ShowStudentForm")
	public String ShowStudentform(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "Form-Student";
	}

	@PostMapping("save")
	public String SaveOrUpadate(Model model, @ModelAttribute("student") Student student, BindingResult result) {

		if (result.hasErrors()) {
			return "Form-Student";
		} else {
			dao.save(student);
			return "redirect:/Student/List";

		}
	}

	@GetMapping("Update")
	public String UpdateStudent(Model model, @RequestParam("id") int id) {

		Student student = dao.findbyid(id);
		model.addAttribute("student", student);
		return "Form-Student";

	}

	@GetMapping("Delete")
	public String DeleteStudent(Model model, @RequestParam("id") int id) {

		Student student = dao.findbyid(id);
		dao.Delete(id);
		return "redirect:/Student/List";
	}

}
