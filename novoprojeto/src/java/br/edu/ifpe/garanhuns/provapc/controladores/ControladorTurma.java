/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Turma;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioTurma;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@SessionScoped
public class ControladorTurma {
    private Turma alterando = null;
    private Turma selected = null;
    private final RepositorioTurma repositorio = FabricaRepositorio.getFabrica().getRepositorioTurma();
    
    public ControladorTurma() {
    }
    
    public void remover() {
        remover(selected);
    }
    
    public String adicionar(Turma t) {
        if(repositorio.existe(t.getId())) {
            repositorio.alterar(t);
        } else {
            repositorio.adicionar(t);
        }
        return "ApresentarTurma.xhtml";
    }
    
    public void remover(Turma t) {
        repositorio.remover(t);
    }
    
    public void alterar(Turma t) {
        repositorio.alterar(t);
    }
    
    public String alterar() {
        this.alterando = selected;
        return "CadastrarTurma.xhtml";
    }
    public Turma recuperar(long id) {
        return repositorio.recuperar(id);
    }

    public List<Turma> recuperarTodos() {
        return repositorio.recuperar();
    }
    
    public Turma getSelected() {
        return selected;
    }
    
    public void setSelected(Turma selected) {
        this.selected = selected;
    }

    public Turma getAlterando() {
        return alterando;
    }

    public void setAlterando(Turma alterando) {
        this.alterando = alterando;
    }
}
