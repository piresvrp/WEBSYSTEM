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
public class Trabalho {
    private Integer cd_trabalho;
    private String nome_trabalho;
    private String descricao;
    private Integer cd_docente;
    private Integer cd_disciplina;
    private String link;

    public Integer getCd_trabalho() {
        return cd_trabalho;
    }

    public void setCd_trabalho(Integer cd_trabalho) {
        this.cd_trabalho = cd_trabalho;
    }

    public String getNome_trabalho() {
        return nome_trabalho;
    }

    public void setNome_trabalho(String nome_trabalho) {
        this.nome_trabalho = nome_trabalho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCd_docente() {
        return cd_docente;
    }

    public void setCd_docente(Integer cd_docente) {
        this.cd_docente = cd_docente;
    }

    public Integer getCd_disciplina() {
        return cd_disciplina;
    }

    public void setCd_disciplina(Integer cd_disciplina) {
        this.cd_disciplina = cd_disciplina;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.cd_trabalho);
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
        final Trabalho other = (Trabalho) obj;
        if (!Objects.equals(this.cd_trabalho, other.cd_trabalho)) {
            return false;
        }
        return true;
    }


}
