package in.greatlearing.CollegeFest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.greatlearing.CollegeFest.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> findAll();

	Student findById(int id);

	void save(Student student);

	void deleteById(int id);
	
	List<Student> searchBy(String name, String department);

}

