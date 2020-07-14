/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.entidade;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;


/**
 *
 * @author Vinicius
 */
public class Noticia {
    private Integer cd_noticia_evento;
    private String evento;
    private String descricao;
    private Date data_inicio;
    private Date data_fim;
    private Time hora_inicio;
    private Time hora_fim;

    public Integer getCd_noticia_evento() {
        return cd_noticia_evento;
    }

    public void setCd_noticia_evento(Integer cd_noticia_evento) {
        this.cd_noticia_evento = cd_noticia_evento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(Time hora_fim) {
        this.hora_fim = hora_fim;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cd_noticia_evento);
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
        final Noticia other = (Noticia) obj;
        return Objects.equals(this.cd_noticia_evento, other.cd_noticia_evento);
    }


}
