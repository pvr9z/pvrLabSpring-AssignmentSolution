package in.greatlearing.CollegeFest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.greatlearing.CollegeFest.entity.Student;
import in.greatlearing.CollegeFest.service.StudentService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentContoller {
	// add the student from the service
	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudent(Model model) {

		// get Books from db
		List<Student> student = studentService.findAll();

		// add to the spring model
		model.addAttribute("students", student);

		// send over to our form
		return "student-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Student student = new Student();

		// set student as a model attribute to pre-populate the form

		theModel.addAttribute("students", student);
		// send over to our form
		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		// get the student from the service
		Student student = studentService.findById(theId);

		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("students", student);

		// send over to our form
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else
			student = new Student(name, department, country);
		// save the Book
		studentService.save(student);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the student
		studentService.deleteById(theId);

		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
					+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
					"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
