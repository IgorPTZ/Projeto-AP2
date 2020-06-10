package frb.edu.br.igor.dominio.contratos;

import frb.edu.br.igor.dominio.entidades.Cidade;

import java.util.List;

public interface ICidade {

    boolean inserir(Cidade cidade);

    boolean alterar(Cidade cidade);

    boolean excluir(int id);

    Cidade getRegistroPorId(int id);

    List<Cidade> getListaDeTodosRegistros();
}
