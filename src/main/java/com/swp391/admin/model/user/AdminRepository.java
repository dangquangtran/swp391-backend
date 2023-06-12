package com.swp391.admin.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {
    void deleteByLastname(String lastname);

    User findById(int id);

    List<User> findAllByEmail(String email);

    List<User> findByLastnameContaining(String lastname);

    List<User> findByRole(String role);


}
