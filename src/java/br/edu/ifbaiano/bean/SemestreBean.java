/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.SemestreDAO;
import br.edu.ifbaiano.entidade.Semestre;
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
public class SemestreBean implements Serializable{
  private Semestre semestre = new Semestre();
    private List<Semestre> semestres = new ArrayList<>();
    private final SemestreDAO semestreDAO = new SemestreDAO();

    /**
     *
     * @throws ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            semestreDAO.salvar(semestre);
            semestre = new Semestre();
            adicionarMensagem("Salvo!", "Semestre salvo com sucesso!", FacesMessage.SEVERITY_INFO);
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
            semestres = semestreDAO.buscar();
            if(semestres == null || semestres.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum semestre!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param s
     */
    public void deletar(Semestre s){
        try {
            semestreDAO.deletar(s.getCd_curso());
            adicionarMensagem("Deletado!", "Semestre deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param s
     */
    public void editar(Semestre s){
        semestre = s;
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
    public Semestre getSemestre() {
        return semestre;
    }

    /**
     *
     * @param semestre
     */
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    /**
     *
     * @return
     */
    public List<Semestre> getSemestres() {
        return semestres;
    }

    /**
     *
     * @param semestres
     */
    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

}
