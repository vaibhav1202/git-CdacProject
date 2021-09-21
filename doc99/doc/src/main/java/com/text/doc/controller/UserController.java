
package com.text.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.text.doc.exceptions.ResourceNotFoundException;
import com.text.doc.model.User;
import com.text.doc.repositories.UserRepository;
import com.text.doc.services.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


//@Component
//@RequestMapping("/api")
@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
	private UserService userService;

  @RequestMapping("/") 
	  public String welcomePage()
	  {
		  return "welcome1";
	  } 
  
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }

 /* @RequestMapping(path={"/userss"} , method = RequestMethod.POST)
  public @ResponseBody String createUser( User user)
  {
	  userRepository.save(user);
	  return "out.html";
  } */

  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId, @RequestBody User userDetails)
      throws ResourceNotFoundException {

    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    user.setPassword(userDetails.getPassword());
   // user.setUpdatedAt(new Date());
    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
  
  @GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}

	
	@PostMapping("/loginuser")
	public String login(@ModelAttribute("user") User user) {
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		User oauthUser = userService.login(user.getEmail(), user.getPassword());
		System.out.println(oauthUser);
		
		if(Objects.nonNull(oauthUser)) {
			return "redirect:/index";
			}
		else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping("/index")
	public String logged()
	  {
		  return "index";
	  }

	
/*	@Autowired
    private org.springframework.core.env.Environment environment;
    @GetMapping("/checkProfile")
    public String[] checkProfile() {
        String[] activeProfiles = environment.getActiveProfiles();  
        for(String profile:activeProfiles) {
            System.out.print(profile);
        }
        return activeProfiles;
    }
	*/
    
  
}



