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
public class Bebida extends Articulo {

    public Bebida(String descripcion, Double precio)
    {
        super(descripcion, precio);
        this.clase = "Bebida";
    }

    @Override
    protected Double getImpuesto()
    {
        return super.getImpuesto() + 15;
    }
     
    
}
