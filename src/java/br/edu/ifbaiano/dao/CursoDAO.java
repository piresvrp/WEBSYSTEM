/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Curso;
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
public class CursoDAO {

    /**
     *
     * @param curso
     * @throws ErroSistema
     */
    public void salvar(Curso curso) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(curso.getCd_curso()!= null){
                ps = conexao.prepareStatement("UPDATE curso set nome_curso=?, descricao=?");
                ps.setInt(3, curso.getCd_curso());
            } else {
                ps = conexao.prepareStatement("INSERT INTO `curso` (`nome_curso`,`descricao`) VALUES (?,?)");
            }
            ps.setString(1, curso.getNome_curso());
            ps.setString(2, curso.getDescricao());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    /**
     *
     * @param cd_curso
     * @throws ErroSistema
     */
    public void deletar(Integer cd_curso) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("DELETE FROM curso WHERE cd_curso = ?");
            ps.setInt(1, cd_curso);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o Curso!", ex);
        }
    }

    /**
     *
     * @return
     * @throws ErroSistema
     */
    public List<Curso> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM curso");
            ResultSet resultSet = ps.executeQuery();
            List<Curso> cursos = new ArrayList<>();
            while(resultSet.next()){
                Curso curso = new Curso();
                curso.setCd_curso(resultSet.getInt("cd_curso"));
                curso.setNome_curso(resultSet.getString("nome_curso"));
                curso.setDescricao(resultSet.getString("descricao"));
                cursos.add(curso);
            }
            FabricaConexao.fecharConexao();
            return cursos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar cursos!",ex);
        }
    }


}
