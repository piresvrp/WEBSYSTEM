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
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Vinicius
 */
public class TrabalhoDAO {

    public void salvar(Trabalho trabalho) throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps;
            if(trabalho.getCd_trabalho() == null){
                ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO `aluno` (`nome_aluno`,`ano_ingresso`,`email`, `matricula`) VALUES (?,?,?,?)");
            } else {
                ps = (PreparedStatement) conexao.prepareStatement("UPDATE aluno set nome_aluno = ?, ano_ingresso = ?, email = ?, matricula = ?");
                ps.setInt(6,trabalho.getCd_trabalho());
            }
            ps.setString(1, trabalho.getNome_trabalho());
            ps.setString(2, trabalho.getDescricao());
            ps.setInt(3, trabalho.getCd_docente());
            ps.setInt(4, trabalho.getCd_disciplina());
            ps.setString(5, trabalho.getLink());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer cd_trabalho) throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps  = (PreparedStatement) conexao.prepareStatement("DELETE FROM trabalho WHERE cd_trabalho = ?");
            ps.setInt(1, cd_trabalho);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o aluno!", ex);
        }
    }

    public List<Trabalho> buscar() throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM trabalho");
            ResultSet resultSet = ps.executeQuery();
            List<Trabalho> trabalhos = new ArrayList<>();
            while(resultSet.next()){
                Trabalho trabalho = new Trabalho();
                trabalho.setCd_trabalho(resultSet.getInt("cd_trabalho"));
                trabalho.setNome_trabalho(resultSet.getString("nome_trabalho"));
                trabalho.setDescricao(resultSet.getString("descricao"));
                trabalho.setCd_disciplina(resultSet.getInt("cd_disciplina"));
                trabalho.setLink(resultSet.getString("link"));

                buscart(trabalho.getCd_disciplina());

                trabalhos.add(trabalho);
            }
            FabricaConexao.fecharConexao();
            return trabalhos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar trabalhos!",ex);
        }
    }

   public List<Trabalho> buscart(int cd) throws ErroSistema{
        try {
            com.mysql.jdbc.Connection conexao = (com.mysql.jdbc.Connection) FabricaConexao.getConexao();
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) conexao.prepareStatement("SELECT * FROM trabalho where cd_disciplina = ?");
            ps.setInt(1, cd);

            ResultSet resultSet = ps.executeQuery();
            List<Trabalho> trabalhos = new ArrayList<>();
            while(resultSet.next()){
                Trabalho trabalho = new Trabalho();
                trabalho.setCd_trabalho(resultSet.getInt("cd_trabalho"));
                trabalho.setNome_trabalho(resultSet.getString("nome_trabalho"));
                trabalho.setDescricao(resultSet.getString("descricao"));
                trabalho.setCd_disciplina(resultSet.getInt("cd_disciplina"));
                trabalho.setLink(resultSet.getString("link"));
                trabalhos.add(trabalho);
            }
            FabricaConexao.fecharConexao();
            return trabalhos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar trabalhos!",ex);
        }
    }
}
