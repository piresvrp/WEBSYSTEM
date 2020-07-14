package br.edu.ifbaiano.entidade;

import java.util.Date;
import java.util.Objects;

public class Aluno {
    
    private Integer cd_aluno;
    private String nome_aluno;
    private Date ano_ingresso;
    private String email;
    private String matricula;

    public Integer getCd_aluno() {
        return cd_aluno;
    }

    public void setCd_aluno(Integer cd_aluno) {
        this.cd_aluno = cd_aluno;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public Date getAno_ingresso() {
        return ano_ingresso;
    }

    public void setAno_ingresso(Date ano_ingresso) {
        this.ano_ingresso = ano_ingresso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cd_aluno);
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
        final Aluno other = (Aluno) obj;
        return Objects.equals(this.cd_aluno, other.cd_aluno);
    }


}
