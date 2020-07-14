package br.edu.ifbaiano.dao;


import br.edu.ifbaiano.ads.util.FabricaConexao;
import br.edu.ifbaiano.entidade.Aluno;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Vinicius
 */
public class AlunoDAO {

    /**
     *
     * @param aluno
     * @throws ErroSistema
     */
    public void salvar(Aluno aluno) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(aluno.getCd_aluno() == null){
                ps = conexao.prepareStatement("INSERT INTO `aluno` (`nome_aluno`,`ano_ingresso`,`email`, `matricula`) VALUES (?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("UPDATE aluno set nome_aluno=?, ano_ingresso=?, email=?, matricula=? WHERE cd_aluno = ?");
                ps.setInt(5, aluno.getCd_aluno());
            }
            ps.setString(1, aluno.getNome_aluno());
            ps.setDate(2, new Date(aluno.getAno_ingresso().getTime()));
            ps.setString(3, aluno.getEmail());
            ps.setString(4, aluno.getMatricula());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer cd_aluno) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("DELETE FROM aluno WHERE cd_aluno = ?");
            ps.setInt(1, cd_aluno);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o aluno!", ex);
        }
    }

    public List<Aluno> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM aluno");
            ResultSet resultSet = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while(resultSet.next()){
                Aluno aluno = new Aluno();
                aluno.setCd_aluno(resultSet.getInt("cd_aluno"));
                aluno.setNome_aluno(resultSet.getString("nome_aluno"));
                aluno.setAno_ingresso(resultSet.getDate("ano_ingresso"));
                aluno.setMatricula(resultSet.getString("matricula"));
                aluno.setEmail(resultSet.getString("email"));
                alunos.add(aluno);
            }
            FabricaConexao.fecharConexao();
            return alunos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os alunos!",ex);
        }
    }
}
