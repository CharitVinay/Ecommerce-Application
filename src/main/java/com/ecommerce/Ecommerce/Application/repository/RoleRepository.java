package com.ecommerce.Ecommerce.Application.repository;

import com.ecommerce.Ecommerce.Application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
