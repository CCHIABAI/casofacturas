/**
 *
 * Programación Basica 2 - Comision 2900
 *
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 *
 */
package CasoFacturas;

/**
 *
 */
public class FacturaDetalle
{

    private Articulo articulo;
    private Integer cantidad;

    public FacturaDetalle(Articulo articulo)
    {
        this.articulo = articulo;
        this.cantidad = 1;
    }

    // Metodos ==================================
    public Articulo getArticulo()
    {
        return articulo;
    }

    public Integer getCantidad()
    {
        return cantidad;
    }

    public void incCantidad()
    {
        this.cantidad += 1;
    }

    public Double getTotal()
    {
        return articulo.getPrecio() * cantidad;
    }

    public Double getMontoImpuesto()
    {
        return articulo.getMontoImpuesto() * cantidad;
    }

    public Double getTotalImpuesto()
    {
        return articulo.getPrecioImpuesto() * cantidad;
    }

}
