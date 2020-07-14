/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.entidade;


/**
 *
 * @author Vinicius
 */
public class MembrosTrabalho {
    private int cd_membros_trabalhos;
    private int cd_trabalho;
    private int cd_discente;

    public MembrosTrabalho(int cd_membros_trabalhos, int cd_trabalho, int cd_discente) {
        this.cd_membros_trabalhos = cd_membros_trabalhos;
        this.cd_trabalho = cd_trabalho;
        this.cd_discente = cd_discente;
    }

    public MembrosTrabalho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCd_membros_trabalhos() {
        return cd_membros_trabalhos;
    }

    public void setCd_membros_trabalhos(int cd_membros_trabalhos) {
        this.cd_membros_trabalhos = cd_membros_trabalhos;
    }

    public int getCd_trabalho() {
        return cd_trabalho;
    }

    public void setCd_trabalho(int cd_trabalho) {
        this.cd_trabalho = cd_trabalho;
    }

    public int getCd_discente() {
        return cd_discente;
    }

    public void setCd_discente(int cd_discente) {
        this.cd_discente = cd_discente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.cd_membros_trabalhos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MembrosTrabalho other = (MembrosTrabalho) obj;
        return this.cd_membros_trabalhos == other.cd_membros_trabalhos;
    }


}
