/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Semestre;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Vinicius
 */
public class SemestreDAO {
    public void salvar(Semestre semestre) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(semestre.getCd_semestre() == null){
                ps = conexao.prepareStatement("INSERT INTO `semestre` (`nome_semestre`,`cd_curso`) VALUES (?,?)");
            } else {
                ps = conexao.prepareStatement("UPDATE semestre set nome_semestre = ?, cd_curso = ?");
                ps.setInt(5,semestre.getCd_semestre());
            }
            ps.setString(1, semestre.getNome_semestre());
            ps.setInt(2, semestre.getCd_curso());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer cd_aluno) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("DELETE FROM semestre WHERE cd_semestre = ?");
            ps.setInt(1, cd_aluno);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o semestre!", ex);
        }
    }

    public List<Semestre> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM semestre");
            ResultSet resultSet = ps.executeQuery();
            List<Semestre> semestres = new ArrayList<>();
            while(resultSet.next()){
                Semestre semestre = new Semestre();
                semestre.setCd_semestre(resultSet.getInt("cd_semestre"));
                semestre.setNome_semestre(resultSet.getString("nome_semestre"));
                semestre.setCd_curso(resultSet.getInt("cd_curso"));

                semestres.add(semestre);
            }
            FabricaConexao.fecharConexao();
            return semestres;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os semestres!",ex);
        }
    }
}
