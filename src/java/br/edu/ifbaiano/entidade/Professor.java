/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.entidade;

import java.util.Objects;


/**
 *
 * @author Vinicius
 */
public class Professor {
    private Integer cd_docente;
    private String nome_docente;
    private String especializacao;
    private String lattes;
    private Integer siape;
    private String email;

    public Professor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getCd_docente() {
        return cd_docente;
    }

    public void setCd_docente(Integer cd_docente) {
        this.cd_docente = cd_docente;
    }

    public String getNome_docente() {
        return nome_docente;
    }

    public void setNome_docente(String nome_docente) {
        this.nome_docente = nome_docente;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public Integer getSiape() {
        return siape;
    }

    public void setSiape(Integer siape) {
        this.siape = siape;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cd_docente);
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
        final Professor other = (Professor) obj;
        return Objects.equals(this.cd_docente, other.cd_docente);
    }


}
