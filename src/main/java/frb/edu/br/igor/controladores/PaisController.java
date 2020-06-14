package frb.edu.br.igor.controladores;

import frb.edu.br.igor.dominio.contratos.ICidade;
import frb.edu.br.igor.dominio.contratos.IPais;
import frb.edu.br.igor.dominio.entidades.Cidade;
import frb.edu.br.igor.dominio.entidades.Pais;
import frb.edu.br.igor.infra.repositorios.CidadeRepositorio;
import frb.edu.br.igor.infra.repositorios.PaisRepositorio;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PaisController implements Serializable {

    private Pais pais;
    private List<Pais> paises;
    private IPais paisRepositorio = new PaisRepositorio();

    public PaisController() {
        paises = paisRepositorio.getListaDeTodosRegistros();
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getPaises() {
        return paises = paisRepositorio.getListaDeTodosRegistros();
    }

    public String prepararInclusao(){

        pais = new Pais();

        return "adicao-pais";
    }

    public String finalizarInclusao(){

        paisRepositorio.inserir(pais);
        pais = null;

        return "listagem-pais";
    }

    public String finalizarEdicao(){

        paisRepositorio.alterar(pais);
        pais = null;

        return "listagem-pais";
    }

    public String finalizarDelecao(){

        paisRepositorio.excluir(pais.getPais_id());
        pais = null;
        return "listagem-pais";
    }
}
