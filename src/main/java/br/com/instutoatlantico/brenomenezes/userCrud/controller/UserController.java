package br.com.instutoatlantico.brenomenezes.userCrud.controller;

import br.com.instutoatlantico.brenomenezes.userCrud.controller.dto.UserDto;
import br.com.instutoatlantico.brenomenezes.userCrud.controller.form.UserForm;
import br.com.instutoatlantico.brenomenezes.userCrud.model.User;
import br.com.instutoatlantico.brenomenezes.userCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @ResponseBody
    public List<UserDto> list(Long id) {
        List<User> users = userRepository.findAll();
        return UserDto.convert(users);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        User user = userRepository.getOne(id);
        return new UserDto(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody UserForm form, UriComponentsBuilder uriBuilder) {
//        System.out.println(form.getEmail());
        User user = form.convert(userRepository);
        userRepository.save(user);

        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
    }
}
