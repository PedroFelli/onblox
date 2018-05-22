package com.br.onblox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{

    @Id
    @Column(name="cpf")
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
