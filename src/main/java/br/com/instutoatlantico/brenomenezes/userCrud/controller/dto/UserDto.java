package br.com.instutoatlantico.brenomenezes.userCrud.controller.dto;

import br.com.instutoatlantico.brenomenezes.userCrud.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String github;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.github = user.getGithub();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGithub() {
        return github;
    }

    public static List<UserDto> convert(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }
}
