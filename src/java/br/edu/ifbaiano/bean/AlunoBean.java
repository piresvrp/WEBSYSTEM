package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.AlunoDAO;
import br.edu.ifbaiano.entidade.Aluno;
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

public class AlunoBean implements Serializable{

    private Aluno aluno = new Aluno();
    private List<Aluno> alunos = new ArrayList<>();
    private final AlunoDAO alunoDAO = new AlunoDAO();

    /**
     *
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            alunoDAO.salvar(aluno);
            aluno = new Aluno();
            adicionarMensagem("Salvo!", "Aluno salvo com sucesso!", FacesMessage.SEVERITY_INFO);
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
            alunos = alunoDAO.buscar();
            if(alunos == null || alunos.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum aluno!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param a
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void deletar(Aluno a) throws ErroSistema{
        try {
            alunoDAO.deletar(a.getCd_aluno());
            adicionarMensagem("Deletado!", "Aluno deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param a
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void editar(Aluno a) throws ErroSistema{
        aluno = a;
    }

    /**
     *
     * @param sumario
     * @param detalhe
     * @param tipoErro
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) throws ErroSistema{
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    /**
     *
     * @return
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     *
     * @param aluno
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     *
     * @return
     */
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     *
     * @param alunos
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }







}
