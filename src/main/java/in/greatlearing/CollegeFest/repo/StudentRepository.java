package in.greatlearing.CollegeFest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import in.greatlearing.CollegeFest.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{


}
