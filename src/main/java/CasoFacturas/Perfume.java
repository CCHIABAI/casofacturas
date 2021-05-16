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
public class Perfume extends Articulo {


    public Perfume(String descripcion, Double precio)
    {
        super(descripcion, precio);
        this.clase = "Perfume";
    }

    @Override
    protected Double getImpuesto()
    {
        return super.getImpuesto() + 15; //To change body of generated methods, choose Tools | Templates.
    }
}
