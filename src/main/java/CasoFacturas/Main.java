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
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
           Factura factura = new Factura();
        factura.add(new Bebida("Vino1", 200.0));
        factura.add(new Bebida("Vino2", 200.0));
        factura.add(new Bebida("Vino2", 200.0));
        factura.add(new Bebida("Vino3", 200.0));
        factura.add(new Bebida("Vino3", 200.0));
        factura.add(new Bebida("Vino3", 200.0));
        factura.add(new Bebida("Vino4", 200.0));
        factura.add(new Bebida("Vino4", 200.0));
        factura.add(new Bebida("Vino4", 200.0));
        factura.add(new Bebida("Vino4", 200.0));

        factura.add(new Bebida("Vino", 200.0));
        factura.add(new Bebida("Vino", 200.0));
        factura.add(new Bebida("Vino", 200.0));
        factura.add(new Bebida("Vino", 200.0));
        factura.add(new Bebida("Vino", 200.0));
        factura.add(new Bebida("Vino", 200.0));
        
        factura.add(new Bebida("Vino blanco", 210.0));
        factura.add(new Perfume("Perfume Chanel", 500.0));
        factura.add(new Perfume("Perfume Calvin Klein", 350.0));
        factura.add(new Bebida("Gaseosa", 100.0));
        factura.add(new Articulo("Torta", 450.0)); 
        
        System.out.print(factura.toString());
    }
    
}
