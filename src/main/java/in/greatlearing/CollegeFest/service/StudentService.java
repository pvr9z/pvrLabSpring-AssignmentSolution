package in.greatlearing.CollegeFest.service;

import java.util.List;

import in.greatlearing.CollegeFest.entity.Student;




//@Service
public interface StudentService {
	
	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);

}

