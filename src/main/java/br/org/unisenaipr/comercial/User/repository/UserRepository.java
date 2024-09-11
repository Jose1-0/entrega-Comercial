package br.org.unisenaipr.comercial.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.unisenaipr.comercial.User.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByUsername(String username);
}
