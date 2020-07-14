/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.ProjetoDAO;
import br.edu.ifbaiano.entidade.Projeto;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.io.Serializable;
import java.sql.SQLException;
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



public class ProjetoBean implements Serializable{
    private Projeto projeto = new Projeto();
    private List<Projeto> projetos = new ArrayList();
    private List<Projeto> projetosPesquisa = new ArrayList();
    private List<Projeto> projetosExtensao = new ArrayList();
    private final ProjetoDAO projetoDAO = new ProjetoDAO();

    /**
     *
     * @throws SQLException
     * @throws ErroSistema
     */
    public void adicionar() throws SQLException, ErroSistema{
         projetoDAO.salvar(projeto);
         projeto = new Projeto();
         adicionarMensagem("Salvo!", "Projeto salvo com sucesso!", FacesMessage.SEVERITY_INFO);
    }

    /**
     *
     * @throws ErroSistema
     */
    public void listar() throws ErroSistema{
        projetos = projetoDAO.buscar();
        if(projetos == null || projetos.isEmpty()){
            adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum projeto!", FacesMessage.SEVERITY_WARN);
        }
    }

    public void listarPesquisa() throws ErroSistema{
        projetosPesquisa = projetoDAO.buscarPesquisa();
        if(projetosPesquisa == null || projetosPesquisa.isEmpty()){
            adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum projeto!", FacesMessage.SEVERITY_WARN);
        }
    }

    public void listarExtensao() throws ErroSistema{
        projetosExtensao = projetoDAO.buscarExtensao();
        if(projetosExtensao == null || projetosExtensao.isEmpty()){
            adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum projeto!", FacesMessage.SEVERITY_WARN);
        }
    }

    /**
     *
     * @param p
     * @throws ErroSistema
     */
    public void deletar(Projeto p) throws ErroSistema{
        projetoDAO.deletar(p.getCd_projeto());
        adicionarMensagem("Deletado!", "Projeto deletado com sucesso!", FacesMessage.SEVERITY_INFO);
    }

    /**
     *
     * @param p
     */
    public void editar(Projeto p){
        projeto = p;
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
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     *
     * @param projeto
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     *
     * @return
     */
    public List<Projeto> getProjetos() {
        return projetos;
    }

    /**
     *
     * @param projetos
     */
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }


}
