
package Controlador;


import Modelo.asignatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Control_asignatura {
  
    private final String tabla = "asignatura";

    public void guardarAsig(Connection conexion, asignatura ag) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + " (Nombre, idAsignatura) VALUES (?, ?)");
            consulta.setString(1, ag.getNombre());
            consulta.setInt(2, ag.getIdAsignatura());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void actualizarAsi(Connection conexion, asignatura ag, int id_asignatura) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET idAsignatura = ?, Nombre = ? WHERE idAsignatura=?");
            consulta.setInt(1, ag.getIdAsignatura());
            consulta.setString(2, ag.getNombre());
            consulta.setInt(3, id_asignatura);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }

    public void eliminarAsig(Connection conexion, asignatura ag) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idAsignatura = ?");
            consulta.setInt(1, ag.getIdAsignatura());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
   
    
    public java.util.List<asignatura> recuperarTodas(Connection conexion) throws SQLException {
        java.util.List<asignatura> ag = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT  idAsignatura, Nombre FROM " + this.tabla + " ORDER BY idAsignatura");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ag.add(new asignatura(resultado.getInt("idAsignatura"), resultado.getString("Nombre")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return ag;   
    }

    

}
