package br.com.instutoatlantico.brenomenezes.userCrud.controller.dto;

import br.com.instutoatlantico.brenomenezes.userCrud.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateUserDto {

    private Long id;
    private String name;
    private String email;
    private String github;
    private LocalDateTime updated_at;

    public UpdateUserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.github = user.getGithub();
        this.updated_at = user.getUpdatedAt();
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

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }


    public static List<UpdateUserDto> convert(List<User> users) {
        return users.stream().map(UpdateUserDto::new).collect(Collectors.toList());
    }
}
