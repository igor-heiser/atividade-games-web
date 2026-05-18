package com.example.exercicio_games_web.Controller;

import com.example.exercicio_games_web.Model.UsuarioGamer;
import com.example.exercicio_games_web.Service.UsuarioGamerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UsuarioGamerController {

    private final UsuarioGamerService service;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listar()); // ← era "pessoas"
        return "lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new UsuarioGamer()); // ← era "pessoa"
        return "form";
    }

    @PostMapping("/salvar")
    public String salvar(UsuarioGamer pessoa) {
        service.salvar(pessoa);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        UsuarioGamer pessoa = service.buscarPorId(id);
        model.addAttribute("usuario", pessoa); // ← era "pessoa"
        return "form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/";
    }
}