package com.portalsaludmental.spring.app.factory;

import com.portalsaludmental.spring.app.model.Usuario;

public class UsuarioFactory {

    public static Usuario crearUsuario(String nombre, String correo, String password, String rol) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setPassword(password);
        usuario.setRol(rol.toUpperCase());
        return usuario;
    }
}