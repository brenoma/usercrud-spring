package br.com.instutoatlantico.brenomenezes.userCrud.controller;

import br.com.instutoatlantico.brenomenezes.userCrud.controller.dto.UserDto;
import br.com.instutoatlantico.brenomenezes.userCrud.model.User;
import br.com.instutoatlantico.brenomenezes.userCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @ResponseBody
    public List<UserDto> list(Long id) {
        if (id == null) {
            List<User> users = userRepository.findAll();
            return UserDto.convert(users);
        } else {
            List<User> users = userRepository.findUserById(id);
            return UserDto.convert(users);
        }
    }
}
