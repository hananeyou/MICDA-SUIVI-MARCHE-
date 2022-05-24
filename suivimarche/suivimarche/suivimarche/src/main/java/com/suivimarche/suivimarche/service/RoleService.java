package com.suivimarche.suivimarche.service;

import com.suivimarche.suivimarche.Repo.RoleDao;
import com.suivimarche.suivimarche.models.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}