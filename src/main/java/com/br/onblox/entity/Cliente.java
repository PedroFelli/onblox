package com.br.onblox.entity;

import javax.persistence.*;



@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{


	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	
	@Column(name="cpf")
    private String cpf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
