package ca.uwo.cs9864.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.uwo.cs9864.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
}
