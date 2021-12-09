package br.com.instutoatlantico.brenomenezes.userCrud.repository;

import br.com.instutoatlantico.brenomenezes.userCrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserById(Long id);
}
