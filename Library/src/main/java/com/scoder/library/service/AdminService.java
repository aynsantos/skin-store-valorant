package com.scoder.library.service;


import com.scoder.library.dto.AdminDTO;
import com.scoder.library.model.Admin;

public interface AdminService {

    Admin findByUsername (String username);

    Admin save(AdminDTO adminDto);


}
