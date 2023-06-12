package com.swp391.admin.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<User> getListUser() {
        return adminRepository.findAll();
    }

    public void createUser(User user) {
        adminRepository.save(user);
    }

    @Transactional
    public void deleteUser(String lastname) {
        adminRepository.deleteByLastname(lastname);
    }

    @Transactional
    public void updateUser(int id, String firstname, String lastname) {
        User user = adminRepository.findById(id);
        if (user != null) {
            user.setFirstname(firstname);
            user.setLastname(lastname);
        }
    }

    public List<User> searchUserByEmail(String email) {
        return adminRepository.findAllByEmail(email);
    }

    public List<User> searchUserByLastName(String lastname) {
        return adminRepository.findByLastnameContaining(lastname);
    }

    public List<User> searchUserByRole(String role) {
        return adminRepository.findByRole(role);
    }


}
