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
    private List<Pais> paises = null;
    private IPais paisRepositorio = new PaisRepositorio();

    public PaisController() {

    }

    public List<Pais> getPaises() {

        if(paises == null){
            paises = paisRepositorio.getListaDeTodosRegistros();
        }
        return paises;
    }

    public String prepararInclusao(){

        pais = new Pais();

        return "vaiParaIncluir";
    }

    public String finalizaInclusao(){

        paisRepositorio.inserir(pais);
        pais = null;
        paises = null;

        return "listagem-pais";
    }

    public String finalizaEdicao(){

        paisRepositorio.alterar(pais);
        pais = null;

        return "listagem-pais";
    }

    public String finalizaDelecao(){

        paisRepositorio.excluir(pais.getPais_id());
        pais = null;
        return "listagem-pais";
    }
}
