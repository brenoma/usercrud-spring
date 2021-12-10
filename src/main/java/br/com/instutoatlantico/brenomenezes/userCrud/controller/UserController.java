package br.com.instutoatlantico.brenomenezes.userCrud.controller;

import br.com.instutoatlantico.brenomenezes.userCrud.controller.dto.UpdateUserDto;
import br.com.instutoatlantico.brenomenezes.userCrud.controller.dto.UserDto;
import br.com.instutoatlantico.brenomenezes.userCrud.controller.form.UpdateUserForm;
import br.com.instutoatlantico.brenomenezes.userCrud.controller.form.UserForm;
import br.com.instutoatlantico.brenomenezes.userCrud.model.GithubUser;
import br.com.instutoatlantico.brenomenezes.userCrud.model.User;
import br.com.instutoatlantico.brenomenezes.userCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Value("${GITHUB_URL}")
    private String baseUrl;

//    CONTAINER ENVIRONMENT
//    URI baseUrl = URI.create(System.getenv("GITHUB_URL"));

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

        User user = form.convert(userRepository);
        userRepository.save(user);

        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UpdateUserDto> update(@PathVariable Long id, @RequestBody UpdateUserForm form) {

        User user = form.update(id, userRepository);

        return ResponseEntity.ok(new UpdateUserDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> remove(@PathVariable Long id) {

        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/github")
    public GithubUser getUserGithub(@PathVariable Long id) {

        User user = userRepository.getOne(id);

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        GithubUser githubUser = restTemplate.getForObject(baseUrl+user.getGithub(), GithubUser.class);

        return githubUser;
    }
}
