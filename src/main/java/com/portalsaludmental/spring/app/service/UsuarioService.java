package com.portalsaludmental.spring.app.service;

import com.portalsaludmental.spring.app.factory.UsuarioFactory;
import com.portalsaludmental.spring.app.model.Usuario;
import com.portalsaludmental.spring.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrar(Usuario usuario) {
        Usuario nuevoUsuario = UsuarioFactory.crearUsuario(
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getPassword(),
                usuario.getRol()
        );

        return usuarioRepository.save(nuevoUsuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}