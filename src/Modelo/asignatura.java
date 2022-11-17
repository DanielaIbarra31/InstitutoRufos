
package Modelo;


public class asignatura {
    
    
    private Integer idAsignatura;
    private String Nombre;
   
    
    public asignatura(Integer idAsignatura, String Nombre){
        this.idAsignatura = idAsignatura;
        this.Nombre = Nombre;
    }
    
    public asignatura(){
        this.idAsignatura = null;
        this.Nombre = null;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }
    

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
}
