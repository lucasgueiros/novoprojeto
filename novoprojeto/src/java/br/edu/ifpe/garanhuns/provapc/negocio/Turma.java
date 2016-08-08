/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@Entity
@Table
public class Turma implements Persistivel<Turma> {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    
    public Turma(long id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public Turma(String nome) {
        this.nome = nome;
    }
    
    public Turma() {
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void alterar(Turma t) {
        this.setNome(t.getNome());
    }

    @Override
    public Turma copiar() {
        return new Turma (nome);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
