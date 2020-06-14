package frb.edu.br.igor.controladores;

import frb.edu.br.igor.dominio.contratos.ICidade;
import frb.edu.br.igor.dominio.contratos.IEndereco;
import frb.edu.br.igor.dominio.entidades.Cidade;
import frb.edu.br.igor.dominio.entidades.Endereco;
import frb.edu.br.igor.infra.repositorios.CidadeRepositorio;
import frb.edu.br.igor.infra.repositorios.EnderecoRepositorio;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EnderecoController implements Serializable {

    private Endereco endereco;
    private List<Endereco> enderecos;
    private IEndereco enderecoRepositorio = new EnderecoRepositorio();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos = enderecoRepositorio.getListaDeTodosRegistros();
    }

    public String prepararInclusao(){

        endereco = new Endereco();

        return "adicao-endereco";
    }

    public String finalizarInclusao(){

        enderecoRepositorio.inserir(endereco);
        endereco = null;

        return "listagem-endereco";
    }

    public String finalizarEdicao(){

        enderecoRepositorio.alterar(endereco);
        endereco = null;

        return "listagem-endereco";
    }

    public String finalizarDelecao(){

        enderecoRepositorio.excluir(endereco.getEndereco_id());
        endereco = null;

        return "listagem-endereco";
    }
}
