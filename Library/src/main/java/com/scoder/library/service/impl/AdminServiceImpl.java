package com.scoder.library.service.impl;


import com.scoder.library.model.Admin;
import com.scoder.library.repository.AdminRepository;
import com.scoder.library.repository.RoleRepository;
import com.scoder.library.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;

    @Override
    public Admin findByUserName(String username) {
        return adminRepository.findByUsername(username);
    }



}
