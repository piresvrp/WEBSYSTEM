/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Projeto;
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
public class ProjetoDAO {

   public void salvar(Projeto projeto) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(projeto.getCd_projeto() == null){
                ps = conexao.prepareStatement("INSERT INTO `projeto`( `nome_projeto`, `descricao`, `cd_docente`, `cd_tipo_projeto`, `cd_usuario`) VALUES (?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("UPDATE `projeto` SET ,`nome_projeto`= ?,`descricao` = ?,`cd_docente` = ?,`cd_tipo_projeto` = ?,`cd_usuario`= ? Where cd_projeto = ?");
                ps.setInt(5,projeto.getCd_projeto());
            }
            ps.setString(1, projeto.getNome_projeto());
            ps.setString(2, projeto.getDescricao());
            ps.setInt(3, projeto.getCd_docente());
            ps.setInt(4 , projeto.getCd_tipo_projeto());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer cd_projeto) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("DELETE FROM projeto WHERE cd_projeto = ?");
            ps.setInt(1, cd_projeto);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o projeto!", ex);
        }
    }

    public List<Projeto> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM projeto");
            ResultSet resultSet = ps.executeQuery();
            List<Projeto> projetos = new ArrayList<>();
            while(resultSet.next()){
                Projeto projeto = new Projeto();
                projeto.setCd_projeto(resultSet.getInt("cd_projeto"));
                projeto.setNome_projeto(resultSet.getString("nome_projeto"));
                projeto.setDescricao(resultSet.getString("descricao"));
                projeto.setCd_docente(resultSet.getInt("cd_docente"));
                projeto.setCd_tipo_projeto(resultSet.getInt("cd_tipo_projeto"));
                projetos.add(projeto);
            }
            FabricaConexao.fecharConexao();
            return projetos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os alunos!",ex);
        }
    }

    public List<Projeto> buscarPesquisa() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM projeto where cd_tipo_projeto = 2");
            ResultSet resultSet = ps.executeQuery();
            List<Projeto> projetos = new ArrayList<>();
            while(resultSet.next()){
                Projeto projeto = new Projeto();
                projeto.setCd_projeto(resultSet.getInt("cd_projeto"));
                projeto.setNome_projeto(resultSet.getString("nome_projeto"));
                projeto.setDescricao(resultSet.getString("descricao"));
                projeto.setCd_docente(resultSet.getInt("cd_docente"));
                projeto.setCd_tipo_projeto(resultSet.getInt("cd_tipo_projeto"));
                projetos.add(projeto);
            }
            FabricaConexao.fecharConexao();
            return projetos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar projetos!",ex);
        }
    }


    public List<Projeto> buscarExtensao() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM projeto where cd_tipo_projeto = 1");
            ResultSet resultSet = ps.executeQuery();
            List<Projeto> projetos = new ArrayList<>();
            while(resultSet.next()){
                Projeto projeto = new Projeto();
                projeto.setCd_projeto(resultSet.getInt("cd_projeto"));
                projeto.setNome_projeto(resultSet.getString("nome_projeto"));
                projeto.setDescricao(resultSet.getString("descricao"));
                projeto.setCd_docente(resultSet.getInt("cd_docente"));
                projeto.setCd_tipo_projeto(resultSet.getInt("cd_tipo_projeto"));
                projetos.add(projeto);
            }
            FabricaConexao.fecharConexao();
            return projetos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar projetos!",ex);
        }
    }

}
