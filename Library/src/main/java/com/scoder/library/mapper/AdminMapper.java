package com.scoder.library.mapper;

import com.scoder.library.dto.AdminDTO;
import com.scoder.library.model.Admin;
import com.scoder.library.repository.AdminRepository;
import com.scoder.library.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Component
public class AdminMapper {

    private BCryptPasswordEncoder passwordEncoder;

    private ModelMapper modelMapper;

    private RoleRepository roleRepository;

    private AdminRepository adminRepository;

    public AdminDTO toAdminDTO(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }

    public Admin save(AdminDTO adminDTO) {
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }





}
