package com.example.BruFyzer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String nome;	
	private String senha;	
	private int idade;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String email, String senha, String nome, int idade) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		String aux = "";
		aux += "Id: " + id + "\n";
		aux += "Email: " + email + "\n";
		aux += "Nome: " + nome + "\n";
		aux += "Senha: " + senha + "\n";
		aux += "Idade: " + idade + "\n";

		return aux;
	}

}
