package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ContactDTO;

public interface ContactService extends AbstractService<ContactDTO> {
List<ContactDTO> findAllByUserId(Long userId);
}
