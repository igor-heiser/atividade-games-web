package com.example.exercicio_games_web.Repository;

import com.example.exercicio_games_web.Model.UsuarioGamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioGamerRepository extends JpaRepository<UsuarioGamer, Long> {
}