package frb.edu.br.igor.infra.repositorios;

import frb.edu.br.igor.dominio.contratos.ICidade;
import frb.edu.br.igor.dominio.contratos.IPais;
import frb.edu.br.igor.dominio.entidades.Cidade;
import frb.edu.br.igor.dominio.entidades.Pais;
import frb.edu.br.igor.infra.data.BancoDeDadosUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CidadeRepositorio extends BancoDeDadosUtil implements ICidade {

    private PaisRepositorio paisRepositorio = new PaisRepositorio();

    @Override
    public boolean inserir(Cidade cidade) {

        String sql = "INSERT INTO cidade (cidade, pais_id, ultima_atualizacao)" +  " VALUES (?, ?, ?)";

        PreparedStatement statement;

        int retorno = -1;

        try {

            statement = getPreparedStatement(sql);

            statement.setString(1, cidade.getCidade());
            statement.setLong(2, cidade.getPais().getPais_id());
            statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            retorno = statement.executeUpdate();
            statement.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    @Override
    public boolean alterar(Cidade cidade) {

        String sql = "UPDATE cidade SET cidade = ?, pais_id = ?, ultima_atualizacao = ?" + " WHERE cidade_id = ?";

        PreparedStatement statement;

        int retorno = -1;

        try {

            statement = getPreparedStatement(sql);

            statement.setString(1, cidade.getCidade());
            statement.setLong(2, cidade.getPais().getPais_id());
            statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            statement.setLong(4, cidade.getCidade_id());

            retorno = statement.executeUpdate();
            statement.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    @Override
    public boolean excluir(Long id) {

        String sql = "DELETE FROM cidade WHERE cidade_id = ?";

        PreparedStatement statement;

        int retorno = -1;

        try {
            statement = getPreparedStatement(sql);
            statement.setLong(1, id);
            retorno = statement.executeUpdate();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    @Override
    public Cidade getRegistroPorId(Long id) {

        Cidade cidade = new Cidade();

        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao FROM cidade WHERE cidade_id = ?";

        try {

            PreparedStatement statement = super.getPreparedStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                cidade = new Cidade(resultSet.getLong("pais_id"),
                                    resultSet.getString("cidade"),
                                    new Pais(resultSet.getLong("pais_id")),
                                    resultSet.getTimestamp("ultima_atualizacao"));
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidade;
    }

    @Override
    public List<Cidade> getListaDeTodosRegistros() {

        List<Cidade> cidades = new LinkedList<Cidade>();
        Pais pais = null;
        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao FROM cidade ";

        try {
            PreparedStatement statement = super.getPreparedStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                pais = paisRepositorio.getRegistroPorId(resultSet.getLong("pais_id"));

                cidades.add(new Cidade(resultSet.getLong("pais_id"),
                                       resultSet.getString("cidade"),
                                       pais,
                                       resultSet.getTimestamp("ultima_atualizacao")));
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidades;
    }
}
