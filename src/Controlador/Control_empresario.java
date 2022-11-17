
package Controlador;

import Modelo.empresario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Control_empresario {
    private final String tabla = "empresario";

    public void guardar(Connection conexion, empresario emp) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(("INSERT INTO " + this.tabla + "(idEmpresario,Nombre,Apellido,Cedula,Direccion,Nivel_Estudio,Titulo ) VALUES(?, ?, ?, ?, ?, ?, ? )"));
            consulta.setInt(1, emp.getIdEmpresario());
            consulta.setString(2, emp.getNombre());
            consulta.setString(3, emp.getApellido());
            consulta.setInt(4, emp.getCedula());
            consulta.setString(5, emp.getDireccion());
            consulta.setString(6, emp.getNivel_Estudio());
            consulta.setString(7, emp.getTitulo());

            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public void actualizarEmp(Connection conexion, empresario emp, int id_empresario) throws SQLException {
        
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET idEmpresario = ?, Nombre = ?, Apellido = ?,Cedula = ?, Direccion = ?, Nivel_estudio = ?, Titulo = ? WHERE idEmpresario = ?");
            consulta.setInt(1, emp.getIdEmpresario());
            consulta.setString(2, emp.getNombre());
            consulta.setString(3, emp.getApellido());
            consulta.setInt(4, emp.getCedula());
            consulta.setString(5, emp.getDireccion());
            consulta.setString(6, emp.getNivel_Estudio());
            consulta.setString(7, emp.getTitulo());
            consulta.setInt(8, id_empresario);

            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void eliminar(Connection conexion, empresario emp) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idEmpresario = ?");
            consulta.setInt(1, emp.getIdEmpresario());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public java.util.List<empresario> recuperarTodas(Connection conexion) throws SQLException {
        java.util.List<empresario> emp = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT  idEmpresario, Nombre, Apellido, Cedula, Direccion, Nivel_Estudio, Titulo FROM " + this.tabla + " ORDER BY idEmpresario");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                emp.add(new empresario(resultado.getInt("idEmpresario"), resultado.getString("Nombre"), resultado.getString("Apellido"), resultado.getInt("Cedula"), resultado.getString("Direccion"), resultado.getString("Nivel_Estudio"), resultado.getString("Titulo")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return emp;
    }
    
}
