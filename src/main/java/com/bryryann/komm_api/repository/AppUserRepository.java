package com.bryryann.komm_api.repository;

import com.bryryann.komm_api.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    UserDetails findByUsername(String username);
}
