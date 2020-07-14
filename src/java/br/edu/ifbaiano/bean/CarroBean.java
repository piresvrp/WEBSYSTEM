package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.CarroDAO;
import br.edu.ifbaiano.entidade.Carro;
import br.edu.ifbaiano.util.exception.ErroSistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Vinicius
 */
@ManagedBean
@SessionScoped

public class CarroBean  implements Serializable {

    private Carro carro = new Carro();
    private List<Carro> carros = new ArrayList<>();
    private final CarroDAO carroDAO = new CarroDAO();

    /**
     *
     * @throws ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            carroDAO.salvar(carro);
            carro = new Carro();
            adicionarMensagem("Salvo!", "Carro salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @throws ErroSistema
     */
    public void listar() throws ErroSistema{
        try {
            carros = carroDAO.buscar();
            if(carros == null || carros.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum carro!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param c
     */
    public void deletar(Carro c){
        try {
            carroDAO.deletar(c.getId());
            adicionarMensagem("Deletado!", "Carro deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param c
     */
    public void editar(Carro c){
        carro = c;
    }

    /**
     *
     * @param sumario
     * @param detalhe
     * @param tipoErro
     */
    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    /**
     *
     * @return
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     *
     * @param carro
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    /**
     *
     * @return
     */
    public List<Carro> getCarros() {
        return carros;
    }

    /**
     *
     * @param carros
     */
    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

}
