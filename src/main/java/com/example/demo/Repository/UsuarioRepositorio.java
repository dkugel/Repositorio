package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

}
