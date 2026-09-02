package com.projectspotters.repository;

import com.projectspotters.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//<User tells Spring which database table this repository manages.
//Long> tells Spring the data type of the @Id field.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional handles the possibility of results missing without NullPointerException
    Optional<User> findByUsername(String username);

}
