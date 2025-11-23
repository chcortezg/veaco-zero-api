package com.veacozero.api.controller;

import com.veacozero.api.model.Usuario;
import com.veacozero.api.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.listarTodos();
    }

    @PostMapping
    public String criar(@RequestBody Usuario usuario) {
        repository.salvar(usuario);
        return "Usuário " + usuario.getNome() + " salvo na memória!";
    }
}