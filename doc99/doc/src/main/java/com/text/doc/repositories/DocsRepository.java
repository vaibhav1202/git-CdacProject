package com.text.doc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.text.doc.model.Docs;


@Repository
public interface DocsRepository extends JpaRepository<Docs, String> {	}
	

	

