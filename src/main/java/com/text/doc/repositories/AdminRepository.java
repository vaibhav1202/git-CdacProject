package com.text.doc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.text.doc.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {}
