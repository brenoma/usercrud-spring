package br.com.instutoatlantico.brenomenezes.userCrud.controller.form;

import br.com.instutoatlantico.brenomenezes.userCrud.model.User;
import br.com.instutoatlantico.brenomenezes.userCrud.repository.UserRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserForm {

    @NotNull @NotEmpty @Size(min = 5, max = 30)
    private String name;

    @NotNull @NotEmpty @Size(min = 4, max = 15)
    private String login;

    @NotNull @NotEmpty @Size(min = 5, max = 30)
    private String password;

    @NotNull @NotEmpty @Size(min = 15, max = 255)
    private String github;

    @NotNull @NotEmpty @Size(min = 7, max = 50)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User convert(UserRepository userRepository) {
        return new User(name, login, password, github, email);
    }
}
