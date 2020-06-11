package frb.edu.br.igor.infra.data;

import java.sql.*;

public abstract class BancoDeDadosUtil {
    private Connection connection = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if(this.connection == null){
            String url = "jdbc:mysql://localhost:3306/igor_projeto_ap_dois?zeroDateTimeBehavior=convertToNull";
            String psw = "";
            String usr = "root";
            String drive = "com.mysql.jdbc.Driver";

            Class.forName(drive);
            connection = DriverManager.getConnection(url, usr, psw);
        }
        return connection;
    }
    public void closeConnection() throws SQLException{

        if(null != this.connection){

            this.connection.close();
            this.connection = null;
        }
    }

    public Statement getStatement() throws ClassNotFoundException, SQLException{
        return this.getConnection().createStatement();
    }

    public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        return this.getConnection().prepareStatement(sql);
    }

}