package br.edu.ifbaiano.dao;


import br.edu.ifbaiano.ads.util.FabricaConexao1;
import br.edu.ifbaiano.entidade.Carro;
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
public class CarroDAO{

    public void salvar(Carro carro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao1.getConexao();
            PreparedStatement ps;
            if(carro.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO `carro` (`modelo`,`fabricante`,`cor`,`ano`) VALUES (?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update carro set modelo=?, fabricante=?, cor=?, ano=? where id=?");
                ps.setInt(5, carro.getId());
            }
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.setDate(4, new Date(carro.getAno().getTime()));
            ps.execute();
            FabricaConexao1.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Integer idCarro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao1.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from carro where id = ?");
            ps.setInt(1, idCarro);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        }
    }

    public List<Carro> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao1.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from carro");
            ResultSet resultSet = ps.executeQuery();
            List<Carro> carros = new ArrayList<>();
            while(resultSet.next()){
                Carro carro = new Carro();
                carro.setId(resultSet.getInt("id"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setFabricante(resultSet.getString("fabricante"));
                carro.setCor(resultSet.getString("cor"));
                carro.setAno(resultSet.getDate("ano"));
                carros.add(carro);
            }
            FabricaConexao1.fecharConexao();
            return carros;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os carros!",ex);
        }
    }
}
