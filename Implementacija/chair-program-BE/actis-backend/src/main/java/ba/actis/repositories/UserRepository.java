package ba.actis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ba.actis.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
	@Query("select u from User u where id=?")
	public User findKorisnikById(Long id);
	
	@Query("select u from User u where roleId=3")
	public List<User> findReviewers();
	
	@Query("select u from User u where email=? and password=?")
	public User findByUsernameAndPassword(String email, String password);
	
	@Query("select u from User u where first_name LIKE ? or last_name LIKE ?")
	public List<User> findByName(String name,String lastName);
	
	@Modifying
	@Query("update User u set u.password = ? where oldpassword= ?")
	public void resetPassword(String newpassword, String oldpassword);
}
