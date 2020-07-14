/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Noticia;
import br.edu.ifbaiano.util.exception.ErroSistema;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Vinicius
 */
public class NoticiaDAO {
    public void salvar(Noticia noticia) throws ErroSistema, SQLException{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps;
            if(noticia == null){
                ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO `noticia_evento`(`evento`, `descricao`, `data_inicio`, `data_fim`, `hora_inicio`, `hora_fim`) VALUES (?,?,?,?,?,?)");
            } else {
                ps = (PreparedStatement) conexao.prepareStatement("UPDATE `noticia_evento` SET `evento` = ?,`descricao` = ?,`data_inicio` = ? ,`data_fim` = ?,`hora_inicio` = ?,`hora_fim` = ?");
                ps.setInt(7,noticia.getCd_noticia_evento());
            }
            ps.setString(1, noticia.getEvento());
            ps.setString(2, noticia.getDescricao());
            ps.setDate(3, new Date(noticia.getData_inicio().getTime()));
            ps.setDate(4, new Date(noticia.getData_fim().getTime()));
            ps.setTime(5, new Time(noticia.getHora_inicio().getTime()));
            ps.setTime(6, new Time(noticia.getHora_fim().getTime()));
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer cd_noticia_evento) throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps  = (PreparedStatement) conexao.prepareStatement("DELETE FROM noticia_evento WHERE cd_noticia_evento = ?");
            ps.setInt(1, cd_noticia_evento);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o aluno!", ex);
        }
    }

    public List<Noticia> buscar() throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM noticia_evento");
            ResultSet resultSet = ps.executeQuery();
            List<Noticia> noticias = new ArrayList<>();
            while(resultSet.next()){
                Noticia noticia = new Noticia();
                noticia.setCd_noticia_evento(resultSet.getInt("cd_noticia_evento"));
                noticia.setEvento(resultSet.getString("evento"));
                noticia.setData_inicio(resultSet.getDate("data_inicio"));
                noticia.setData_inicio(resultSet.getDate("data_fim"));
                noticia.setData_inicio(resultSet.getTime("hora_inicio"));
                noticia.setData_inicio(resultSet.getTime("hora_fim"));
                noticias.add(noticia);
            }
            FabricaConexao.fecharConexao();
            return noticias;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar noticias!",ex);
        }
    }
}
