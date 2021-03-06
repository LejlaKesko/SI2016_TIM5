package ba.actis.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ba.actis.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	@Query("select r from Role r where id=?")
	public Role findById( Long id);
}
