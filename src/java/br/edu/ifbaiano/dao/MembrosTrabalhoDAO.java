/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.MembrosTrabalho;
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
public class MembrosTrabalhoDAO {
    public List<MembrosTrabalho> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM menbros_trabalho where cd_projeto = ?");
            ResultSet resultSet = ps.executeQuery();
            List<MembrosTrabalho> membrostrab = new ArrayList<>();
            while(resultSet.next()){
                MembrosTrabalho mTrab = new MembrosTrabalho();
                mTrab.setCd_membros_trabalhos(resultSet.getInt("cd_membros_trabalhos"));
                mTrab.setCd_trabalho(resultSet.getInt("cd_trabalho"));
                mTrab.setCd_discente(resultSet.getInt("cd_discente"));
                membrostrab.add(mTrab);
            }
            FabricaConexao.fecharConexao();
            return membrostrab;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar Membros do Trabalho!",ex);
        }
    }
}
