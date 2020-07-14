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
public class Semestre {
    private Integer cd_semestre;
    private String nome_semestre;
    private Integer cd_curso;

    public Integer getCd_semestre() {
        return cd_semestre;
    }

    public void setCd_semestre(Integer cd_semestre) {
        this.cd_semestre = cd_semestre;
    }

    public String getNome_semestre() {
        return nome_semestre;
    }

    public void setNome_semestre(String nome_semestre) {
        this.nome_semestre = nome_semestre;
    }

    public Integer getCd_curso() {
        return cd_curso;
    }

    public void setCd_curso(Integer cd_curso) {
        this.cd_curso = cd_curso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.cd_semestre);
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
        final Semestre other = (Semestre) obj;
        return Objects.equals(this.cd_semestre, other.cd_semestre);
    }


}
