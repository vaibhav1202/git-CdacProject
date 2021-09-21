package com.text.doc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.text.doc.model.SuperAdmin;


@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {}

