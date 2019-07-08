package ns.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ns.Mapper;
import ns.controllers.viewmodel.UserViewModel;
import ns.db.UserRepository;
import ns.models.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

	private UserRepository userRepository;
	private Mapper mapper;

	public UserController(UserRepository userRepository, Mapper mapper) {
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		var userList = this.userRepository.findAll();
		return userList;
	}

	@PostMapping("/user/save")
	public User save(@RequestBody UserViewModel userViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		var userEntity = this.mapper.convertToUserEntity(userViewModel);
		this.userRepository.save(userEntity);
		return userEntity;
	}

	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable String id) {
		this.userRepository.deleteById(UUID.fromString(id));
	}

}
