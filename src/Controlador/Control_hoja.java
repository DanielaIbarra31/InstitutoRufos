
package Controlador;

import Modelo.hoja_actividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Control_hoja {
    
    private final String tabla = "hoja_actividades";
   
    public void guardarHoja(Connection conexion, hoja_actividades ho) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + " (idHoja_Actividades, Hora_Inicio, Hora_Final, idEmpresario) VALUES (?, ?, ?, ?)");
            consulta.setInt(1, ho.getIdHoja_Actividades());
            consulta.setString(2, ho.getHora_Inicio());
            consulta.setString(3, ho.getHora_Final());
            consulta.setInt(4, ho.getIdEmpresario());
            
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public void eliminarAsp(Connection conexion, hoja_actividades ho) throws SQLException {
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idHoja_Actividades =?");
            consulta.setInt(1, ho.getIdHoja_Actividades());
            consulta.executeUpdate();
        }catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public List<hoja_actividades> recuperarTodas(Connection conexion) throws SQLException {
        List<hoja_actividades> ho = new ArrayList<>();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT  idHoja_Actividades, Hora_Inicio, Hora_Final, idEmpresario FROM " + this.tabla + " ORDER BY idHoja_Actividades");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()){
                ho.add(new hoja_actividades(resultado.getInt("idHoja_Actividades"), resultado.getString("Hora_Inicio"), resultado.getString("Hora_Final"), resultado.getInt("idEmpresario")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return ho;
    }
    
}
