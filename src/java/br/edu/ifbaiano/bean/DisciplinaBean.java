package br.edu.ifbaiano.bean;

import br.edu.ifbaiano.dao.DisciplinaDAO;
import br.edu.ifbaiano.entidade.Disciplina;
import br.edu.ifbaiano.entidade.Trabalho;
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

public class DisciplinaBean  implements Serializable {

    private Disciplina disciplina = new Disciplina();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private final DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private List<Trabalho> trabalhos;

    /**
     *
     * @throws ErroSistema
     */
    public void adicionar() throws ErroSistema{
        try {
            disciplinaDAO.salvar(disciplina);
            disciplina = new Disciplina();
            adicionarMensagem("Salvo!", "Disciplina salva com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param cds
     * @throws ErroSistema
     */
    public void listar(int cds) throws ErroSistema{
        try {
            disciplinas = disciplinaDAO.buscar(cds);
            if(disciplinas == null || disciplinas.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum disciplina!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param cds
     * @throws ErroSistema
     */
    public void listar2(int cds) throws ErroSistema{
        try {
            disciplinas = disciplinaDAO.buscar2(cds);
            if(disciplinas == null || disciplinas.isEmpty()){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum disciplina!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }




    /**
     *
     * @param d
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void deletar(Disciplina d) throws ErroSistema{
        try {
            disciplinaDAO.deletar(d.getCd_disciplina());
            adicionarMensagem("Deletado!", "Disciplina deletada com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     *
     * @param d
     * @throws br.edu.ifbaiano.util.exception.ErroSistema
     */
    public void editar(Disciplina d) throws ErroSistema{
        disciplina = d;
    }

    /**
     *
     * @param sumario
     * @param detalhe
     * @param tipoErro
     * @throws ErroSistema
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
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     *
     * @param disciplina
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     *
     * @return
     */
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     *
     * @param disciplinas
     */
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
