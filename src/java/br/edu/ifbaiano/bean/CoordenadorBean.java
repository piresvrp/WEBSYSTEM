/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.CoordenadorDAO;
import br.edu.ifbaiano.entidade.Coordenador;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.jms.Session;
import javax.management.Query;


/**
 *
 * @author Vinicius
 */
public class CoordenadorBean implements Serializable{
    private Coordenador coordenador = new Coordenador();
    private List<Coordenador> coordenadores = new ArrayList<>();
    private final CoordenadorDAO coordenadorDAO = new CoordenadorDAO();

    /**
     *
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            coordenadorDAO.salvar(coordenador);
            coordenador = new Coordenador();
            adicionarMensagem("Salvo!", "Coordenador salvo com sucesso!", FacesMessage.SEVERITY_INFO);
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
            coordenadores = coordenadorDAO.buscar();
            if(coordenadores == null || coordenadores.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum coordenador!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param c
     */
    public void deletar(Coordenador c){
        try {
            coordenadorDAO.deletar(c.getCd_coordenador());
            adicionarMensagem("Deletado!", "Coordenador deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param c
     */
    public void editar(Coordenador c){
        coordenador = c;
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
    public Coordenador getCoordenador() {
        return coordenador;
    }

    /**
     *
     * @param coordenador
     */
    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    /**
     *
     * @return
     */
    public List<Coordenador> getCoordenadores() {
        return coordenadores;
    }

    /**
     *
     * @param coordenadores
     */
    public void setCoordenadores(List<Coordenador> coordenadores) {
        this.coordenadores = coordenadores;
    }


}
