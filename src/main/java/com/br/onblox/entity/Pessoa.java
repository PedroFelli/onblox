package com.br.onblox.entity;


import javax.persistence.*;


@MappedSuperclass
public abstract class Pessoa {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Column(name="nome")
	private String nome;

	@Column(name="tipo")
	private String tipo;

	
	@Column(name="status")
	private int status;



	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcontato")
	private Contato contato;


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
