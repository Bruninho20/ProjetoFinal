package com.example.BruFyzer.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.BruFyzer.models.Usuario;
import com.example.BruFyzer.models.UsuarioRepository;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/BruFyzer")
public class Controller {

	@Autowired
	private UsuarioRepository userRepository;

	
	@GetMapping(path = "/home")
	public String home(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "home";
	}

	// Create
	@GetMapping(path = "/cadastrar")
	public String cadastrarUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastrar";
	}

	@PostMapping(path = "/cadastrar")
	public String salvarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha,
			@RequestParam int idade, Model model) {
		// realiza o incapsulamento dos dasos
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setEmail(email);
		u.setIdade(idade);
		u.setSenha(senha);
		// salvar o novo Usuario no banco
		userRepository.save(u);
		return "login";
	}
	
	
	
	@GetMapping(path = "/login")
	public String login(Model model) {
		model.addAttribute("user", new Usuario());
		return "login";
	}
	
	@GetMapping(path = "/player")
	public String player() {
		return "player";
	}
	
	@GetMapping(path = "/player2")
	public String player2() {
		return "player2";
	}
	
	@GetMapping(path = "/player3")
	public String player3() {
		return "player3";
	}
	
	@GetMapping(path = "/player4")
	public String player4() {
		return "player4";
	}
		

	@PostMapping(path = "/login")
	public String logar(@ModelAttribute Usuario user, Model model) {
		System.out.println(user.getEmail());
		System.out.println(user.getSenha());
		Usuario us = userRepository.Login(user.getEmail().toString());

		if (us.getEmail().equals(user.getEmail()) && us.getSenha().equals(user.getSenha())) {
			System.out.println(us.getEmail());
			System.out.println(us.getSenha());
			return "player";
		} else {
			return "erro";
		}
	}
}
