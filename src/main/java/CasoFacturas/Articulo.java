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
public class Articulo
{
    protected String clase = "Articulo";
    private   String descripcion;
    private   Double precio;
    private   Double impuesto = 21.0; // 21 %

    // CONSTRUCTOR ==========================
    public Articulo(String descripcion, Double precio)
    {
        this.descripcion = descripcion;
        setPrecio(precio);
    }
    
    // PROPIEDADES ==========================
    public String getClase()
    {
        return clase;
    }

    public void setClase(String clase)
    {
        this.clase = clase;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Double getPrecio()
    {
        return precio;
    }

    public void setPrecio(Double precio)
    {
        this.precio = Math.abs(precio); // No precio negativo
    }

    protected Double getImpuesto()
    {
        return impuesto;
    }
    
    public Double getMontoImpuesto()
    {
        return  getPrecio() * getImpuesto() / 100;
    }
    
    public Double getPrecioImpuesto()
    {
        return getPrecio() + getMontoImpuesto();
    }

}
