package com.text.doc.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.text.doc.model.Docs;
import com.text.doc.repositories.DocsRepository;



@Service
public class DocsStorage{

  @Autowired
  private DocsRepository docsrepository;

  public Docs store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Docs FileDB = new Docs(fileName, file.getContentType(), file.getBytes());

    return docsrepository.save(FileDB);
  }

  public Docs getFile(String id) {
    return docsrepository.findById(id).get();
  }
  
  public Stream<Docs> getAllFiles() {
    return docsrepository.findAll().stream();
  }
}