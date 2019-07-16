package com.checkpoint.wcs.wildcircus.repositories;

import com.checkpoint.wcs.wildcircus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmailAndPassword( String p_email, String p_password);
    public User findByUsername( String username);
}
