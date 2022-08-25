package ca.uwo.cs9864.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.uwo.cs9864.entity.UserCredential;

// Our ID would be a user name
@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredential, String>{

}
