package com.mycompany.appinvestigacion;

/**
 *
 * @author usuario
 */
public class Marca {

    private String descripcion;
    private Integer codigo;

    public Marca(Integer codigo, String descripcion) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
       

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
