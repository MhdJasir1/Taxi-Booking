package com.taita.webapp.taxibooking.repository;

import com.taita.webapp.taxibooking.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {

    AdminUser findByUsername(String username);

    AdminUser findOneByUsernameAndPassword(String username, String password);
}
