package ba.actis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ba.actis.models.Role;
import ba.actis.models.User;
import ba.actis.repositories.RoleRepository;
import ba.actis.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserServiceInterface {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		Set<Role> roles = new HashSet<>(((JpaRepository<Role, Long>) roleRepository).findAll());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoleId(roles.iterator().next());
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByEmail(username);
	}
}
