package frb.edu.br.igor.infra.repositorios;

import frb.edu.br.igor.dominio.contratos.IPais;
import frb.edu.br.igor.dominio.entidades.Pais;
import frb.edu.br.igor.infra.data.BancoDeDadosUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaisRepositorio extends BancoDeDadosUtil implements IPais{

    @Override
    public boolean inserir(Pais pais) {

        String sql = "INSERT INTO produto (pais, ultima_atualizacao)" +  " VALUES (?, ?)";

        PreparedStatement statement;

        int retorno = -1;

        try {

            statement = getPreparedStatement(sql);

            statement.setString(1, pais.getPais());
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

            retorno = statement.executeUpdate();
            statement.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    @Override
    public boolean alterar(Pais pais) {

        String sql = "UPDATE pais SET pais = ?, ultima_atualizacao = ? WHERE pais_id = ?";

        PreparedStatement statement;

        int retorno = -1;

        try {

            statement = getPreparedStatement(sql);

            statement.setString(1, pais.getPais());
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            statement.setLong(3, pais.getPais_id());

            retorno = statement.executeUpdate();
            statement.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    @Override
    public boolean excluir(Long id) {

        String sql = "DELETE FROM pais WHERE pais_id = ?";

        PreparedStatement statement;

        int retorno = -1;

        try {
            statement = getPreparedStatement(sql);
            statement.setLong(1, id);
            retorno = statement.executeUpdate();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    @Override
    public Pais getRegistroPorId(Long id) {

        Pais pais = new Pais();

        String sql = "SELECT pais_id, pais, ultima_atualizacao FROM pais WHERE pais_id = ?";

        try {

            PreparedStatement statement = super.getPreparedStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                pais = new Pais(resultSet.getLong("pais_id"),
                                resultSet.getString("pais"),
                                resultSet.getTimestamp("ultima_atualizacao"));
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pais;
    }

    @Override
    public List<Pais> getListaDeTodosRegistros() {

        List<Pais> paises = new LinkedList<Pais>();
        String sql = "SELECT pais_id, pais, ultima_atualizacao FROM pais ";

        try {
            PreparedStatement statement = super.getPreparedStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                paises.add( new Pais(resultSet.getLong("pais_id"),
                                    resultSet.getString("pais"),
                                    resultSet.getTimestamp("ultima_atualizacao")));
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paises;
    }
}
