package com.bm.j23.auth.model.persistence.repositories;

import com.bm.j23.auth.model.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	long countByUsername(String username);
}
