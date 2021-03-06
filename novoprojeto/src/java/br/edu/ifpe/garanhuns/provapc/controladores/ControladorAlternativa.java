/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Alternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author João Witor
 */
@ManagedBean (eager =true)
@SessionScoped
public class ControladorAlternativa {
    private Alternativa alterando = null;
    private Alternativa selected = null;
    private final RepositorioAlternativa repositorio = FabricaRepositorio.getFabrica().getRepositorioAlternativa();
    
    public ControladorAlternativa() {
    }
    
    public void remover() {
        remover(selected);
    }
    
     public String adicionar(Alternativa a) {
        if(repositorio.existe(a.getId())) {
            repositorio.alterar(a);
        } else {
            repositorio.adicionar(a);
        }
        return "ApresentarAlternativa.xhtml";
    }
     
     public String alterar() {
        this.alterando = selected;
        return "CadastrarAlternativa.xhtml";
    }
    
    
    public void remover(Alternativa a) {
        repositorio.remover(a);
    }

    public void alterar(Alternativa a) {
        repositorio.alterar(a);
    }

    public Alternativa recuperar(long id) {
        return repositorio.recuperar(id);
    }

    public List<Alternativa> recuperarTodos() {
        return repositorio.recuperar();
    }

    public Alternativa getSelected() {
        return selected;
    }

    public void setSelected(Alternativa selected) {
        this.selected = selected;
    }

    public Alternativa getAlterando() {
        return alterando;
    }

    public void setAlterando(Alternativa alterando) {
        this.alterando = alterando;
    }
}
