package br.com.bgt.firstsystem.repository;

import br.com.bgt.firstsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
