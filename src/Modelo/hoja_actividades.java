
package Modelo;


public class hoja_actividades {
    
    private Integer idHoja_Actividades;
    private String Hora_Inicio;
    private String Hora_Final;
    private Integer idEmpresario;
    
    public hoja_actividades(Integer idHoja_Actividades, String Hora_Inicio, String Hora_Final, Integer idEmpresario){
        this.idHoja_Actividades = idHoja_Actividades;
        this.Hora_Inicio = Hora_Inicio;
        this.Hora_Final = Hora_Final;
        this.idEmpresario = idEmpresario;
    }
    
    public hoja_actividades(){
        this.idHoja_Actividades = null;
        this.Hora_Inicio = null;
        this.Hora_Final = null;
        this.idEmpresario =  null; 
    }

    public Integer getIdHoja_Actividades() {
        return idHoja_Actividades;
    }

    public void setIdHoja_Actividades(Integer idHoja_Actividades) {
        this.idHoja_Actividades = idHoja_Actividades;
    }

    public String getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(String Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public String getHora_Final() {
        return Hora_Final;
    }

    public void setHora_Final(String Hora_Final) {
        this.Hora_Final = Hora_Final;
    }

    public Integer getIdEmpresario() {
        return idEmpresario;
    }

    public void setIdEmpresario(Integer idEmpresario) {
        this.idEmpresario = idEmpresario;
    }
    
    
}
