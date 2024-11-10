package com.cursojava.curso.dao;

import com.cursojava.curso.Models.Usuario;


import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List getUsuarios() {
        String query = "from Usuario";
         return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario optenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "from Usuario where  correo = :correo ";
        List<Usuario> lista =  entityManager.createQuery(query)
                .setParameter("correo", usuario.getCorreo())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String passwordhash = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordhash,usuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }
}
