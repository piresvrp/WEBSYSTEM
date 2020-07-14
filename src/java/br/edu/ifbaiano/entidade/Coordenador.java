/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.entidade;

import java.sql.Date;
import java.util.Objects;


/**
 *
 * @author Vinicius
 */
public class Coordenador {
    private Integer cd_coordenador;
    private Integer cd_curso;
    private Integer cd_docente;
    private Date ano_ingresso;

    public Integer getCd_coordenador() {
        return cd_coordenador;
    }

    public void setCd_coordenador(Integer cd_coordenador) {
        this.cd_coordenador = cd_coordenador;
    }

    public Integer getCd_curso() {
        return cd_curso;
    }

    public void setCd_curso(Integer cd_curso) {
        this.cd_curso = cd_curso;
    }

    public Integer getCd_docente() {
        return cd_docente;
    }

    public void setCd_docente(Integer cd_docente) {
        this.cd_docente = cd_docente;
    }

    public Date getAno_ingresso() {
        return ano_ingresso;
    }

    public void setAno_ingresso(Date ano_ingresso) {
        this.ano_ingresso = ano_ingresso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cd_coordenador);
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
        final Coordenador other = (Coordenador) obj;
        if (!Objects.equals(this.cd_coordenador, other.cd_coordenador)) {
            return false;
        }
        return true;
    }


}
