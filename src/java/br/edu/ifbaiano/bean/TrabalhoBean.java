/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.TrabalhoDAO;
import br.edu.ifbaiano.entidade.Disciplina;
import br.edu.ifbaiano.entidade.Trabalho;
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
public class TrabalhoBean implements Serializable{
    private Trabalho trabalho = new Trabalho();
    private List<Trabalho> trabalhos = new ArrayList<>();
    private final TrabalhoDAO trabalhoDAO = new TrabalhoDAO();
    private List<Disciplina> disciplinas = new ArrayList<>();

    /**
     *
     * @throws ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            trabalhoDAO.salvar(trabalho);
            trabalho = new Trabalho();
            adicionarMensagem("Salvo!", "Trabalho salvo com sucesso!", FacesMessage.SEVERITY_INFO);
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
            trabalhos = trabalhoDAO.buscar();
            if(trabalhos == null || trabalhos.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum Trabalho!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

        public void listart(int cd) throws ErroSistema{
        try {
            trabalhos = trabalhoDAO.buscart(cd);
            /*if(trabalhos == null || trabalhos.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum Trabalho!", FacesMessage.SEVERITY_WARN);
            }*/
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param t
     */
    public void deletar(Trabalho t){
        try {
            trabalhoDAO.deletar(t.getCd_trabalho());
            adicionarMensagem("Deletado!", "Aluno deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param t
     */
    public void editar(Trabalho t){
        trabalho = t;
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
    public Trabalho getTrabalho() {
        return trabalho;
    }

    /**
     *
     * @param trabalho
     */
    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    /**
     *
     * @return
     */
    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    /**
     *
     * @param trabalhos
     */
    public void setTrabalhos(List<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }


}
