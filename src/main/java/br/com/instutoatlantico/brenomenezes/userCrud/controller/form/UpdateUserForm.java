package br.com.instutoatlantico.brenomenezes.userCrud.controller.form;

import br.com.instutoatlantico.brenomenezes.userCrud.model.User;
import br.com.instutoatlantico.brenomenezes.userCrud.repository.UserRepository;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UpdateUserForm {

    @NotNull @NotEmpty @Size(min = 5, max = 30)
    private String name;

    @NotNull @NotEmpty @Size(min = 15, max = 255)
    private String github;

    @NotNull @NotEmpty @Size(min = 7, max = 50)
    private String email;

    @UpdateTimestamp
    private LocalDateTime updated_at = LocalDateTime.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public User update(Long id, UserRepository userRepository) {
        User user = userRepository.getOne(id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setGithub(this.github);
        user.setUpdatedAt(this.updated_at);

        return user;
    }
}
