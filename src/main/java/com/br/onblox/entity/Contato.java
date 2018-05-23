package com.br.onblox.entity;

import javax.persistence.*;

@Entity
@Table(name="contato")
public class Contato {


	@Id
	@Column(name="id")
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="telefone")
	private int telefone;


	@Column(name="endereco")
	private String endereco;

	
	@Column(name="email")
	private String email;


	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
}
