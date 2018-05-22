package com.br.onblox.entity;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Id
	@Column(name="nome")
	private String nome;


	@Id
	@Column(name="tipo")
	private String tipo;

	@Id
	@Column(name="status")
	private int status;



	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcontato")
	private Contato contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
