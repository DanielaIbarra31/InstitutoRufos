
package Controlador;


import Modelo.aspirante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class Control_aspirante {
   private final String tabla = "aspirante";
   
    public void guardarAsp(Connection conexion, aspirante ap) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idAspirante, Nombre, idAsignatura) VALUES(?, ?, ?)");
            consulta.setInt(1, ap.getIdAspirante());
            consulta.setString(2, ap.getNombre());
            consulta.setInt(3, ap.getIdAsignatura());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
   
    public void eliminarAsp(Connection conexion, aspirante ap) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idAspirante =?");
            consulta.setInt(1, ap.getIdAspirante());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public java.util.List<aspirante> recuperarTodas(Connection conexion) throws SQLException {
        java.util.List<aspirante> ap = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT  idAspirante, Nombre, idAsignatura FROM " + this.tabla + " ORDER BY idAspirante");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ap.add(new aspirante(resultado.getInt("idAspirante"), resultado.getString("Nombre"), resultado.getInt("idAsignatura")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return ap;
    }
    
    
}
