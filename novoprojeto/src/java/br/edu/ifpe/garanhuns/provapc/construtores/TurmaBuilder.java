/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;

import br.edu.ifpe.garanhuns.provapc.controladores.ControladorTurma;
import br.edu.ifpe.garanhuns.provapc.negocio.Turma;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@RequestScoped
public class TurmaBuilder {
    private long id;
    private String nome;
    FacesContext faces = FacesContext.getCurrentInstance();
    private ControladorTurma controlador = (ControladorTurma) faces.getApplication().evaluateExpressionGet(faces, "#{controladorTurma}", ControladorTurma.class);
    private boolean alterando = false;
    
    public TurmaBuilder() {
        Turma t = controlador.getAlterando();
        if(t!=null) {
            this.id = t.getId();
            this.nome = t.getNome();
            this.alterando = true;
        }
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Turma construir() {
        return new Turma(id,nome);
    }
}
