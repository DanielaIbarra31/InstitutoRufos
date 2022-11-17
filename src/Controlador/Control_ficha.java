
package Controlador;

import Modelo.ficha_individual;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Control_ficha {
    
    private final String tabla = "ficha_individual";

    public void guardar(Connection conexion, ficha_individual fi) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idFicha_individual, Fecha) VALUES(?, ?)");
            consulta.setInt(1, fi.getIdFicha_individual());
            consulta.setDate(2, (Date) fi.getFecha());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

   

    public void eliminar(Connection conexion, ficha_individual fi) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idFicha_individual = ?");
            consulta.setInt(1, fi.getIdFicha_individual());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public List<ficha_individual> recuperarTodas(Connection conexion) throws SQLException {
        List<ficha_individual> fi = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idFicha_individual, Fecha FROM " + this.tabla + " ORDER BY idFicha_individual");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                fi.add(new ficha_individual(resultado.getInt("idFicha_individual"), resultado.getDate("Fecha")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return fi;
    }
}