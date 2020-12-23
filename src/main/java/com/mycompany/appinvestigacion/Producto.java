
package com.mycompany.appinvestigacion;

/**
 *
 * @author usuario
 */
public class Producto {
       private Integer Codigo;
       private String Descripcion;
       private Float Cantidad;
       private String Iva;
       private Float Precio;
       private Integer marca;

    public Producto(Integer Codigo, String Descripcion, Float Cantidad, String Iva, Float Precio, Integer marca) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Iva = Iva;
        this.Precio = Precio;
        this.marca = marca;
    }
       
       

    public Integer getCodigo() {
        return Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public Float getCantidad() {
        return Cantidad;
    }

    public String getIva() {
        return Iva;
    }

    public Float getPrecio() {
        return Precio;
    }

    public Integer getMarca() {
        return marca;
    }
    

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setCantidad(Float Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setIva(String Iva) {
        this.Iva = Iva;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }


      
       
}





