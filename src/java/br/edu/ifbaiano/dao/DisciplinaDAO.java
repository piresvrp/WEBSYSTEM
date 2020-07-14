/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Disciplina;
import br.edu.ifbaiano.entidade.Trabalho;
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
public class DisciplinaDAO {

    public void salvar(Disciplina disciplina) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(disciplina.getCd_disciplina() == null){
                ps = conexao.prepareStatement("INSERT INTO `disciplina` (`nome_disciplina`,`cd_semestre`) VALUES (?,?)");
            } else {
                ps = conexao.prepareStatement("update disciplina set nome_disciplina=?, cd_semestre=? where cd_disciplina=?");
                ps.setInt(5, disciplina.getCd_disciplina());
            }
            ps.setString(1, disciplina.getNome_disciplina());
            ps.setInt(2, disciplina.getCd_semestre());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer cd_disciplina) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from disciplina where cd_disciplina = ?");
            ps.setInt(1, cd_disciplina);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar a disciplina!", ex);
        }
    }

    /**
     *
     * @param cds
     * @return
     * @throws ErroSistema
     */
    public List<Disciplina> buscar(int cds) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM disciplina = ?");
            ps.setInt(1, cds);
            ResultSet resultSet = ps.executeQuery();
            List<Disciplina> disciplinas = new ArrayList<>();
            while(resultSet.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setCd_disciplina(resultSet.getInt("cd_disciplina"));
                disciplina.setNome_disciplina(resultSet.getString("nome_disciplina"));
                disciplina.setCd_semestre(resultSet.getInt("cd_semestre"));
                disciplinas.add(disciplina);
            }
            FabricaConexao.fecharConexao();
            return disciplinas;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar as disciplinas!",ex);
        }
    }

    public List<Disciplina> buscar2(int cds) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM disciplina where cd_semestre= ?");
            ps.setInt(1, cds);
            ResultSet resultSet = ps.executeQuery();
            List<Disciplina> disciplinas = new ArrayList<>();
            while(resultSet.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setCd_disciplina(resultSet.getInt("cd_disciplina"));
                disciplina.setNome_disciplina(resultSet.getString("nome_disciplina"));
                disciplinas.add(disciplina);




            }
            FabricaConexao.fecharConexao();
            return disciplinas;


        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar as disciplinas!",ex);
        }
    }

}
