package com.suivimarche.suivimarche.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suivimarche.suivimarche.models.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}