/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.ProfessorDAO;
import br.edu.ifbaiano.entidade.Professor;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Vinicius
 */
public class ProfessorBean implements Serializable{
    private Professor professor = new Professor();
    private List<Professor> professores = new ArrayList<>();
    private final ProfessorDAO professorDAO = new ProfessorDAO();

    /**
     *
     * @throws ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            professorDAO.salvar(professor);
            professor = new Professor();
            adicionarMensagem("Salvo!", "Professor salvo com sucesso!",FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @throws ErroSistema
     */
    public void listar() throws ErroSistema{
        try {
            professores = professorDAO.buscar();
            if(professores == null || professores.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum professor!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param prof
     */
    public void deletar(Professor prof){
        try {
            professorDAO.deletar(prof.getCd_docente());
            adicionarMensagem("Deletado!", "Professor deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param prof
     */
    public void editar(Professor prof){
        professor = prof;
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
    public Professor getProfessor() {
        return professor;
    }

    /**
     *
     * @param professor
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     *
     * @return
     */
    public List<Professor> getProfessores() {
        return professores;
    }

    /**
     *
     * @param professores
     */
    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }


}
