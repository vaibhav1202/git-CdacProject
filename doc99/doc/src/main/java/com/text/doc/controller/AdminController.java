
package com.text.doc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.text.doc.exceptions.ResourceNotFoundException;
import com.text.doc.model.Admin;
import com.text.doc.repositories.AdminRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

  @Autowired
  private AdminRepository adminRepository;


  @GetMapping("/admin")
  public List<Admin> getAllUsers() {
    return adminRepository.findAll();
  }

  @GetMapping("/admin/{id}")
  public ResponseEntity<Admin> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    Admin admin =
       adminRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(admin);
  }

  @PostMapping("/admin")
  public Admin createUser(@RequestBody Admin user) {
    return adminRepository.save(user);
  }

  @PutMapping("/admin/{id}")
  public ResponseEntity<Admin> updateUser(
      @PathVariable(value = "id") Long userId,	@RequestBody Admin userDetails)
      throws ResourceNotFoundException {

    Admin admin =
        adminRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    admin.setEmail(userDetails.getEmail());
    admin.setLastName(userDetails.getLastName());
    admin.setFirstName(userDetails.getFirstName());
    admin.setPass(userDetails.getPass());
   // user.setUpdatedAt(new Date());
    final Admin updatedUser = adminRepository.save(admin);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/admin/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    Admin admin =
        adminRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    adminRepository.delete(admin);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
