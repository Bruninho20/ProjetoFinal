package com.example.BruFyzer.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	//@Query(value = "select * from usuario where email=:?1 and senha=:?2", nativeQuery = true)
	//public Usuario Login(String email, String senha);
	
	//@Query("select u from Usuario where u.email = ?1")
	//public Usuario Login(String email);
	
	@Query("select u from Usuario u where u.email = ?1")
	public Usuario Login(String email);
}
