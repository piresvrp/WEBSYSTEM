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
public class Curso {
    private Integer cd_curso;
    private String nome_curso;
    private String descricao;

    public Integer getCd_curso() {
        return cd_curso;
    }

    public void setCd_curso(Integer cd_curso) {
        this.cd_curso = cd_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.cd_curso);
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
        final Curso other = (Curso) obj;
        return Objects.equals(this.cd_curso, other.cd_curso);
    }
}
