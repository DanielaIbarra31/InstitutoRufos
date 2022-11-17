
package Modelo;

public class alumnos {
    
    public Integer getIdAlumno() {
        return idAlumno;
    }
    private final Integer idAlumno;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Nivel_Estudio;
    private String Titulo;
    private Integer idGrupo;
    private Integer idFicha_Individual;
    
    public alumnos(Integer idAlumno, String Nombre, String Apellido, String Direccion, String Nivel_Esudio, String Titulo, Integer idGrupo, Integer idFicha_Individual){
        this.idAlumno = idAlumno;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Nivel_Estudio = Nivel_Esudio;
        this.Titulo = Titulo;
        this.idGrupo = idGrupo;
        this.idFicha_Individual = idFicha_Individual;
    }
    
    public alumnos(){
        this.idAlumno = null;
        this.Nombre = null;
        this.Apellido = null;
        this.Direccion= null;
        this.Nivel_Estudio = null;
        this.Titulo = null;
        this.idGrupo = null;
        this.idFicha_Individual = null;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNivel_Estudio() {
        return Nivel_Estudio;
    }

    public void setNivel_Estudio(String Nivel_Estudio) {
        this.Nivel_Estudio = Nivel_Estudio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdFicha_Individual() {
        return idFicha_Individual;
    }

    public void setIdFicha_Individual(Integer idFicha_Individual) {
        this.idFicha_Individual = idFicha_Individual;
    }

    
    
    
   
    
}
