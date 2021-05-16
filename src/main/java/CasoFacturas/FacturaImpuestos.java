/** 
 *
 * Programación Basica 2 - Comision 2900
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 **/


package CasoFacturas;

/**
 * 
 */
public class FacturaImpuestos {
    
    private String clase;
    private Double impuesto;
    private Integer cantidadArticulos = 1;
    private Double total = 0.0;

    public FacturaImpuestos(String claseProducto, Double impuesto, Double montoInicial)
    {
        this.clase = claseProducto;
        this.impuesto = impuesto;
        this.total = montoInicial;
    }
    
    // PROPIEDADES =======================================

    public String getClase()
    {
        return clase;
    }

    public Double getImpuesto()
    {
        return impuesto;
    }

    public Double getTotal()
    {
        return total;
    }
    
    public Integer getCantidad()
    {
       return cantidadArticulos;
    }

    // Metodos =========================================
    public void incTotal(Double monto, Integer cantidad)
    {
        this.total += monto;
        this.cantidadArticulos += cantidad;
    }
      
    

}
