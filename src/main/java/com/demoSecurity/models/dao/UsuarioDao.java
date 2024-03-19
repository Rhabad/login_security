package com.demoSecurity.models.dao;

import com.demoSecurity.models.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long> {

    @Query(value = "select * from usuario where username = :username", nativeQuery = true)
    Optional<Usuario> findByUsername(String username);
}
