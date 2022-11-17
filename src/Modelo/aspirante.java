
package Modelo;


public class aspirante {
    
    private Integer idAspirante;
    private String Nombre;
    private Integer idAsignatura;    
    
    public aspirante(int idAspirante, String Nombre, Integer idAsignatura){
        this.idAspirante = idAspirante;
        this.Nombre = Nombre;
        this.idAsignatura = idAsignatura;
    }
    
    public aspirante(){
        this.idAspirante = null;
        this.Nombre =  null;
        this.idAsignatura = null;
    }

    public Integer getIdAspirante() {
        return idAspirante;
    }

    public void setIdAspirante(Integer idAspirante) {
        this.idAspirante = idAspirante;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    
    
}
