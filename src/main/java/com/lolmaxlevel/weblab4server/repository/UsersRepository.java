package com.lolmaxlevel.weblab4server.repository;

import com.lolmaxlevel.weblab4server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    /**
     * Finds a user by its username
     *
     * @return the user with the given username, or null if there is no such user
     */
    User findByUsername(String username);
}
