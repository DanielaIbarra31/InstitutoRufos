
package Modelo;


public class empresario {
    
    private Integer idEmpresario;
    private String Nombre;
    private String Apellido;
    private Integer Cedula;
    private String Direccion;
    private String Nivel_Estudio;
    private String Titulo;
    
    public empresario(Integer idEmpresario, String Nombre, String Apellido, Integer Cedula, String Direccion, String Nivel_Estudio, String Titulo){
        this.idEmpresario = idEmpresario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Direccion = Direccion;
        this.Nivel_Estudio = Nivel_Estudio;
        this.Titulo = Titulo;
    }
    
    public empresario(){
        this.idEmpresario = null;
        this.Nombre = null;
        this.Apellido = null;
        this.Cedula = null;
        this.Direccion = null;
        this.Nivel_Estudio = null;
        this.Titulo = null;
    }

    public Integer getIdEmpresario() {
        return idEmpresario;
    }

    public void setIdEmpresario(Integer idEmpresario) {
        this.idEmpresario = idEmpresario;
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

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer Cedula) {
        this.Cedula = Cedula;
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
    
    
    
}
