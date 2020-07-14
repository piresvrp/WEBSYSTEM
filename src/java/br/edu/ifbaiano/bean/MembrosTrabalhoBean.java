/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.MembrosTrabalhoDAO;
import br.edu.ifbaiano.entidade.MembrosTrabalho;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Vinicius
 */
public class MembrosTrabalhoBean {
    private MembrosTrabalho mTrab = new MembrosTrabalho();
    private List<MembrosTrabalho> MembrosTrabalhos = new ArrayList<>();
    private final MembrosTrabalhoDAO MembrosTrabalhoDAO = new MembrosTrabalhoDAO();

    public void listar() throws ErroSistema{
        try {
            MembrosTrabalhos = MembrosTrabalhoDAO.buscar();
            if(MembrosTrabalhos == null || MembrosTrabalhos.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum aluno!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param sumario
     * @param detalhe
     * @param tipoErro
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) throws ErroSistema{
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    public MembrosTrabalho getmTrab() {
        return mTrab;
    }

    public void setmTrab(MembrosTrabalho mTrab) {
        this.mTrab = mTrab;
    }

    public List<MembrosTrabalho> getMembrosTrabalhos() {
        return MembrosTrabalhos;
    }

    public void setMembrosTrabalhos(List<MembrosTrabalho> MembrosTrabalhos) {
        this.MembrosTrabalhos = MembrosTrabalhos;
    }


}
