package com.example.exercicio_games_web.Service;

import com.example.exercicio_games_web.Model.UsuarioGamer;
import com.example.exercicio_games_web.Repository.UsuarioGamerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UsuarioGamerService {

    private final UsuarioGamerRepository repository;

    // read
    public List<UsuarioGamer> listar() {
        return repository.findAll();
    }

    // read buscar por id
    public UsuarioGamer buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // create
    public UsuarioGamer salvar(UsuarioGamer usuario) {
        return repository.save(usuario);
    }

    // update
    public UsuarioGamer atualizar(Long id, UsuarioGamer dados) {

        UsuarioGamer usuario = buscarPorId(id);

        usuario.setNickname(dados.getNickname());
        usuario.setEmail(dados.getEmail());
        usuario.setJogoFavorito(dados.getJogoFavorito());
        usuario.setNivel(dados.getNivel());

        return repository.save(usuario);
    }

    // delete
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}