package in.greatlearing.CollegeFest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.greatlearing.CollegeFest.entity.Student;
import in.greatlearing.CollegeFest.repo.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.getById(id);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> searchBy(String name, String department) {
		// TODO Auto-generated method stub
		return studentRepository.findByNameContainsAndAuthourContainsAllIgnoreCase(name, department);
	}

}
