package com.cursojava.curso.Controllers;

import com.cursojava.curso.Models.Usuario;
import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String registrarUsuario(@RequestBody Usuario usuario){

        Usuario usuariologeado = usuarioDao.optenerUsuarioPorCredenciales(usuario);
        if(usuariologeado != null){

            String tokenjwt =  jwtUtil.create(String.valueOf(usuariologeado.getId()), usuariologeado.getCorreo());

            return tokenjwt;
        }
        return "error";
    }

}
