package com.cursojava.curso.dao;

import com.cursojava.curso.Models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();


    void eliminar(long id);

    void registrar(Usuario usuario);

    Usuario optenerUsuarioPorCredenciales(Usuario usuario);
}
