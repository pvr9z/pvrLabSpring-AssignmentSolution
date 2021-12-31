package in.greatlearing.CollegeFest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greatlearing.CollegeFest.entity.User;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long>{
//    @Query("SELECT u FROM User u WHERE u.username = ?")
    public User getByUsername(String username);
}
