package frb.edu.br.igor.dominio.contratos;

import frb.edu.br.igor.dominio.entidades.Pais;

import java.util.List;

public interface IPais {

    boolean inserir(Pais pais);

    boolean alterar(Pais pais);

    boolean excluir(Long id);

    Pais getRegistroPorId(Long id);

    List<Pais> getListaDeTodosRegistros();
}
