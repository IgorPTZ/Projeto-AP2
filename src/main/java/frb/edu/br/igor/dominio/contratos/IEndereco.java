package frb.edu.br.igor.dominio.contratos;

import frb.edu.br.igor.dominio.entidades.Cidade;
import frb.edu.br.igor.dominio.entidades.Endereco;

import java.util.List;

public interface IEndereco {

    boolean inserir(Endereco endereco);

    boolean alterar(Endereco endereco);

    boolean excluir(Long id);

    Endereco getRegistroPorId(Long id);

    List<Endereco> getListaDeTodosRegistros();
}
