/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.NoticiaDAO;
import br.edu.ifbaiano.entidade.Noticia;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Vinicius
 */
@ManagedBean
@RequestScoped
public class NoticiaBean {

   private Noticia noticia = new Noticia();
    private List<Noticia> noticias = new ArrayList<>();
    private final NoticiaDAO noticiaDAO = new NoticiaDAO();

    /**
     *
     * @throws SQLException
     */
    public void adicionar() throws SQLException{
        try {
            noticiaDAO.salvar(noticia);
            noticia = new Noticia();
            adicionarMensagem("Salvo!", "Noticia salva com sucesso!", FacesMessage.SEVERITY_INFO);
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
            noticias = noticiaDAO.buscar();
            if(noticias == null || noticias.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhuma noticia!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param n
     */
    public void deletar(Noticia n){
        try {
            noticiaDAO.deletar(n.getCd_noticia_evento());
            adicionarMensagem("Deletado!", "Aluno deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param n
     */
    public void editar(Noticia n){
        noticia = n;
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
    public Noticia getNoticia() {
        return noticia;
    }

    /**
     *
     * @param noticia
     */
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    /**
     *
     * @return
     */
    public List<Noticia> getNoticias() {
        return noticias;
    }

    /**
     *
     * @param noticias
     */
    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

}
