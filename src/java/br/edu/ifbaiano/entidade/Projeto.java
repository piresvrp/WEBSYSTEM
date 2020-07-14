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

  class Projeto {
    private Integer cd_projeto;
    private String nome_projeto;
    private Integer cd_usuario;
    private Integer cd_docente;
    private Integer cd_tipo_projeto;
    private String descricao;

    public Integer getCd_projeto() {
        return cd_projeto;
    }

    public void setCd_projeto(Integer cd_projeto) {
        this.cd_projeto = cd_projeto;
    }

    public String getNome_projeto() {
        return nome_projeto;
    }

    public void setNome_projeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
    }

    public Integer getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(Integer cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Integer getCd_docente() {
        return cd_docente;
    }

    public void setCd_docente(Integer cd_docente) {
        this.cd_docente = cd_docente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCd_tipo_projeto() {
        return cd_tipo_projeto;
    }

    public void setCd_tipo_projeto(Integer cd_tipo_projeto) {
        this.cd_tipo_projeto = cd_tipo_projeto;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cd_projeto);
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
        final Projeto other = (Projeto) obj;
        return Objects.equals(this.cd_projeto, other.cd_projeto);
    }




}
