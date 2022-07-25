package kr.co.ejsoft.erp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping(value = "/")
  List<User> findAll() {
    return userRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  User findOne(@PathVariable int id) {
    return userRepository.findById(id).orElse(null);
  }

  @PostMapping(value = "/")
  User create(@RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping(value = "/{id}")
  User update(@PathVariable int id, @RequestBody User user) {
    User oldUser = userRepository.findById(id).orElse(null);
    oldUser.setName(user.getName());
    oldUser.setEmail(user.getEmail());
    oldUser.setPassword(user.getPassword());
    return userRepository.save(oldUser);
  }

  @DeleteMapping(value = "/{id}")
  Integer destory(@PathVariable int id) {
    userRepository.deleteById(id);
    return id;
  }

}
