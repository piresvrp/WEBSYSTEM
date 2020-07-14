/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifbaiano.dao;

import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Professor;
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
public class ProfessorDAO {
    public void salvar(Professor professor) throws ErroSistema{
        try{
           Connection conexao = (Connection) FabricaConexao.getConexao();
           PreparedStatement ps;
           if(professor.getCd_docente() == null){
               ps = (PreparedStatement) conexao.prepareStatement("INSERT INTO `docente`(`cd_docente`, `nome_docente`, `especializacao`, `lattes`, `siap`, `email`, `foto`) VALUES (?,?,?,?,?,?,'null')");
           }else{
               ps = (PreparedStatement) conexao.prepareStatement("UPDATE `docente` SET `nome_docente` = ?,`especializacao` = ?,`lattes` = ?,`siap` = ?,`email` = ?");
               ps.setInt(5, professor.getCd_docente());
           }
               ps.setString(1, professor.getNome_docente());
               ps.setString(2, professor.getEspecializacao());
               ps.setString(3, professor.getLattes());
               ps.setInt(4, professor.getSiape());
               ps.setString(5, professor.getEmail());
               ps.execute();
               FabricaConexao.fecharConexao();
        }catch (SQLException ex){
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer cd_docente) throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps  = (PreparedStatement) conexao.prepareStatement("DELETE FROM docente WHERE cd_docente = ?");
            ps.setInt(1, cd_docente);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o professor!", ex);
        }
    }

     public List<Professor> buscar() throws ErroSistema{
        try {
            Connection conexao = (Connection) FabricaConexao.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement("SELECT * FROM docente");
            ResultSet resultSet = ps.executeQuery();
            List<Professor> professores = new ArrayList<>();
            while(resultSet.next()){
                Professor professor = new Professor();
                professor.setCd_docente(resultSet.getInt("cd_docente"));
                professor.setNome_docente(resultSet.getString("nome_docente"));
                professor.setEspecializacao(resultSet.getString("especializacao"));
                professor.setLattes(resultSet.getString("lattes"));
                professor.setSiape(resultSet.getInt("siape"));
                professores.add(professor);

            }
            FabricaConexao.fecharConexao();
            return professores;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os professores!",ex);
        }
    }
}
