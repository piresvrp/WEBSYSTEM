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
public class Disciplina {
    private Integer cd_disciplina;
    private String nome_disciplina;
    private Integer cd_semestre;

    public Integer getCd_disciplina() {
        return cd_disciplina;
    }

    public void setCd_disciplina(Integer cd_disciplina) {
        this.cd_disciplina = cd_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public Integer getCd_semestre() {
        return cd_semestre;
    }

    public void setCd_semestre(Integer cd_semestre) {
        this.cd_semestre = cd_semestre;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cd_disciplina);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.cd_disciplina, other.cd_disciplina)) {
            return false;
        }
        return true;
    }

    public void getSemestre(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}
