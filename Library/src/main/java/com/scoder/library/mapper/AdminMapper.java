package com.scoder.library.mapper;

import com.scoder.library.dto.AdminDTO;
import com.scoder.library.model.Admin;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AdminMapper {

    private ModelMapper modelMapper;

    public AdminDTO toAdminDTO(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }



}
