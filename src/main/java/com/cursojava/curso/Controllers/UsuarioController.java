package com.cursojava.curso.Controllers;

import com.cursojava.curso.Models.Usuario;
import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable int id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Artur");
        usuario.setApellido("Letona");
        usuario.setCorreo("soyArtur@gmail.com");
        usuario.setTelefono("997447546");
        usuario.setPassword("pidposaf");
        usuario.setEdad(23);

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)){return null;}

       return usuarioDao.getUsuarios();
    }

    public boolean validarToken(String token){
        String usuarioID = jwtUtil.getKey(token);
        return usuarioID != null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash =  argon2.hash(1,1024,1, usuario.getPassword());

        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "editar")
    public Usuario editarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Artur");
        usuario.setApellido("Letona");
        usuario.setCorreo("soyArtur@gmail.com");
        usuario.setTelefono("997447546");
        usuario.setPassword("pidposaf");
        usuario.setEdad(23);
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token,
                                @PathVariable long id){

        if(!validarToken(token)){return;}
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "buscar")
    public Usuario buscarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Artur");
        usuario.setApellido("Letona");
        usuario.setCorreo("soyArtur@gmail.com");
        usuario.setTelefono("997447546");
        usuario.setPassword("pidposaf");
        usuario.setEdad(23);
        return usuario;
    }


}
