/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Coordenador;
import br.edu.ifbaiano.util.exception.ErroSistema;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.jms.Session;


/**
 *
 * @author Vinicius
 */
public class CoordenadorDAO {

     public void salvar(Coordenador coordenador) throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps;
            if(coordenador.getCd_coordenador() == null){
                ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO `coordenador`(`cd_curso`, `cd_docente`, `ano_ingresso`) VALUES ('1','1',?)");
            } else {
                ps = (PreparedStatement) conexao.prepareStatement("UPDATE SET cd_curso = ?, cd_docente = ?, ano_ingresso = ? where cd_coordenador = ?");
                ps.setInt(4, coordenador.getCd_coordenador());
            }
            ps.setInt(1, coordenador.getCd_curso());
            ps.setInt(2, coordenador.getCd_docente());
            ps.setDate(3, new Date(coordenador.getAno_ingresso().getTime()));
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

      public void deletar(Integer cd_coordenador) throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps  = (PreparedStatement) conexao.prepareStatement("DELETE FROM coordenador where cd_coordenador = ?");
            ps.setInt(1, cd_coordenador);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o coordenador!", ex);
        }
    }


       public List<Coordenador> buscar() throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM coordenador");
            ResultSet resultSet = ps.executeQuery();
            List<Coordenador> coordenadores;
            coordenadores = new ArrayList<>();
            while(resultSet.next()){
                Coordenador coordenador = new Coordenador();
                coordenador.setCd_coordenador(resultSet.getInt("cd_coordenador"));
                coordenador.setCd_curso(resultSet.getInt("cd_curso"));
                coordenador.setCd_docente(resultSet.getInt("cd_docente"));
                coordenador.setAno_ingresso(resultSet.getDate("ano_ingresso"));
                coordenadores.add(coordenador);
            }
            FabricaConexao.fecharConexao();
            return coordenadores;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os coordenadores!",ex);
        }
    }

}
