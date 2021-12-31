package in.greatlearing.CollegeFest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greatlearing.CollegeFest.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User getByUsername(String username);
	User getByPassword(String password);
}
