package br.com.biblioteca.repositories;

import br.com.biblioteca.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
