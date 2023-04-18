package com.scoder.library.service.impl;


import com.scoder.library.dto.AdminDTO;
import com.scoder.library.model.Admin;
import com.scoder.library.repository.AdminRepository;
import com.scoder.library.repository.RoleRepository;
import com.scoder.library.service.AdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AdminServiceImpl implements AdminService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;

    @Override
    public Admin findByUserName(String username) {
        return adminRepository.findByUsername(username);
    }




}
