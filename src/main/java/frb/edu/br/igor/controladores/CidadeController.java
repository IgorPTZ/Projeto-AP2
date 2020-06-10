package frb.edu.br.igor.controladores;

import frb.edu.br.igor.dominio.contratos.ICidade;
import frb.edu.br.igor.dominio.entidades.Cidade;
import frb.edu.br.igor.infra.repositorios.CidadeRepositorio;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class CidadeController {

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

        if(cidades == null){
            cidades = cidadeRepositorio.getListaDeTodosRegistros();
        }
        return cidades;
    }

    public String prepararInclusao(){

        cidade = new Cidade ();

        return "vaiParaIncluir";
    }

    public String finalizaInclusao(){

        cidadeRepositorio.inserir(cidade);
        cidade = null;

        return "voltaParaListagem";
    }

    public String finalizaEdicao(){

        cidadeRepositorio.alterar(cidade);
        cidade = null;

        return "voltaParaListagem";
    }

    public String finalizaDelecao(){

        cidadeRepositorio.excluir(cidade.getCidade_id());
        cidade = null;
        return "refresh";
    }
}
