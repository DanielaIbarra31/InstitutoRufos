
package Controlador;

import Modelo.alumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Control_alumnos {
   
    private final String tabla = "alumnos";

    public void guardar(Connection conexion, alumnos a) throws SQLException {
        try {
            PreparedStatement consulta;
            if (a.getIdAlumno() == null) {
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + " (Nombre, Apellido, Direccion, Nivel_Estudio, Titulo, idGrupo, idFicha_Individual) VALUES (?, ?, ?, ?, ?, ?, ?)");
                consulta.setString(1, a.getNombre());
                consulta.setString(2, a.getApellido());
                consulta.setString(3, a.getDireccion());
                consulta.setString(4, a.getNivel_Estudio());
                consulta.setString(5, a.getTitulo());
                consulta.setInt(6, a.getIdGrupo());
                consulta.setInt(7, a.getIdFicha_Individual());
            } else {
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET Nombre= ?, Apellido = ?, Direccion = ?, Nivel_Estudio = ?, Titulo = ?, idGrupo = ?, idFicha_Individual = ? WHERE idAlumno = ?");
                consulta.setString(1, a.getNombre());
                consulta.setString(2, a.getApellido());
                consulta.setString(3, a.getDireccion());
                consulta.setString(4, a.getNivel_Estudio());
                consulta.setString(5, a.getTitulo());
                consulta.setInt(6, a.getIdGrupo());
                consulta.setInt(7, a.getIdFicha_Individual());
                consulta.setInt(8, a.getIdAlumno());
            }
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    
    public void actualizar(Connection conexion, alumnos a, int id_alumno) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET Nombre= ?, Apellido = ?, Direccion = ?, Nivel_Estudio = ?, Titulo = ?, idGrupo = ?, idFicha_Individual = ? WHERE idAlumno = ?");
            consulta.setString(1, a.getNombre());
            consulta.setString(2, a.getApellido());
            consulta.setString(3, a.getDireccion());
            consulta.setString(4, a.getNivel_Estudio());
            consulta.setString(5, a.getTitulo());
            consulta.setInt(6, a.getIdGrupo());
            consulta.setInt(7, a.getIdFicha_Individual());
            consulta.setInt(8, id_alumno);

            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public alumnos recuperarPorId(Connection conexion, int id) throws SQLException {
        alumnos a = null;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT Nombre, Apellido, Direccion, Nivel_Estudio, Titulo, idGrupo, idFicha_Individual FROM " + this.tabla + "WHERE id = ?");
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                a = new alumnos(id, resultado.getString("Nombre"), resultado.getString("Apellido"), resultado.getString("Direccion"), resultado.getString("Nivel_Estudio"), resultado.getString("Titulo"), resultado.getInt("idGrupo"), resultado.getInt("idFicha_Individual"));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return a;
    }

    public void eliminar(Connection conexion, alumnos a) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idAlumno = ?");
            consulta.setInt(1, a.getIdAlumno());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public java.util.List<alumnos> recuperarTodas(Connection conexion) throws SQLException {
        java.util.List<alumnos> a = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT  idAlumno, Nombre, Apellido, Direccion, Nivel_Estudio, Titulo, idGrupo, idFicha_Individual FROM " + this.tabla + " ORDER BY idAlumno");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                a.add(new alumnos(resultado.getInt("idAlumno"), resultado.getString("Nombre"), resultado.getString("Apellido"), resultado.getString("Direccion"), resultado.getString("Nivel_Estudio"), resultado.getString("Titulo"), resultado.getInt("idGrupo"), resultado.getInt("idFicha_Individual")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return a;
    }

   

}
