package frb.edu.br.igor.controladores;

import frb.edu.br.igor.dominio.contratos.ICidade;
import frb.edu.br.igor.dominio.entidades.Cidade;
import frb.edu.br.igor.infra.repositorios.CidadeRepositorio;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CidadeController implements Serializable {

    private Cidade cidade;
    private List<Cidade> cidades = null;
    private ICidade cidadeRepositorio = new CidadeRepositorio();

    public CidadeController() {

    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
            return cidades = cidadeRepositorio.getListaDeTodosRegistros();
    }

    public String prepararInclusao(){

        cidade = new Cidade ();

        return "adicao-cidade";
    }

    public String finalizarInclusao(){

        cidadeRepositorio.inserir(cidade);
        cidade = null;

        return "listagem-cidade";
    }

    public String finalizarEdicao(){

        cidadeRepositorio.alterar(cidade);
        cidade = null;

        return "listagem-cidade";
    }

    public String finalizarDelecao(){

        cidadeRepositorio.excluir(cidade.getCidade_id());
        cidade = null;

        return "listagem-cidade";
    }
}
