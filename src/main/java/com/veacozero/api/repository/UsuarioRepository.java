package com.veacozero.api.repository;

import com.veacozero.api.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioRepository {
    // hashmap
    private Map<Long, Usuario> dadosEmMemoria = new HashMap<>();

    public void salvar(Usuario usuario) {
        dadosEmMemoria.put(usuario.getId(), usuario);
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(dadosEmMemoria.values());
    }
}