/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.CursoDAO;
import br.edu.ifbaiano.entidade.Curso;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vinicius
 */
@ManagedBean
@SessionScoped

public class CursoBean implements Serializable {

    private Curso curso;
    private List<Curso> cursos = new ArrayList<>();
    private final CursoDAO cursoDAO = new CursoDAO();

    public CursoBean() {
        this.curso = new Curso();
    }

    /**
     *
     * @throws ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            cursoDAO.salvar(curso);
            curso = new Curso();
            adicionarMensagem("Salvo!", "Curso salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void listar() throws ErroSistema{
        try {
            cursos = cursoDAO.buscar();
            if(cursos == null || cursos.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum curso!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param c
     */
    public void deletar(Curso c){
        try {
            cursoDAO.deletar(c.getCd_curso());
            adicionarMensagem("Deletado!", "Curso deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param c
     */
    public void editar(Curso c){
        curso = c;
    }

    /**
     *
     * @param sumario
     * @param detalhe
     * @param tipoErro
     */
    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    /**
     *
     * @return
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     *
     * @return
     */
    public List<Curso> getCursos() {
        return cursos;
    }

    /**
     *
     * @param cursos
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
