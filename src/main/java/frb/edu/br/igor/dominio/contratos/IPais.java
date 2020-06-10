package frb.edu.br.igor.dominio.contratos;

import frb.edu.br.igor.dominio.entidades.Pais;

import java.util.List;

public interface IPais {

    boolean inserir(Pais pais);

    boolean alterar(Pais pais);

    boolean excluir(int id);

    Pais getRegistroPorId(int id);

    List<Pais> getListaDeTodosRegistros();
}
