package com.example.demo.service;

import com.example.demo.dto.UserDTO;

public interface UserService extends AbstractService<UserDTO> {
Long validateAccount(Long id);
long invalidateAccount(Long id);
}
