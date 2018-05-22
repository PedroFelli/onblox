package com.br.onblox.entity;

import javax.persistence.*;

@Entity
@Table(name="contato")
public class Contato {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Id
	@Column(name="telefone")
	private int telefone;

	@Id
	@Column(name="endereco")
	private String endereco;

	@Id
	@Column(name="email")
	private String email;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
