/** 
 *
 * Programación Basica 2 - Comision 2900
 * @author Claudio J. CHIABAI <cchiabai@alumno.unlam.edu.ar>
 *
 **/


package CasoFacturas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */
public class Factura {

    private ArrayList<FacturaDetalle> detalle;
    private ArrayList<FacturaImpuestos> impuestos;
    
    // CONSTRUCTOR ===============================
    public Factura()
    {
        this.detalle   = new ArrayList<FacturaDetalle>();
        this.impuestos = new ArrayList<FacturaImpuestos>();
    }

    // METODOS ===================================
    public void add(Articulo articulo)
    {
        Boolean found = false;

        // Articulos -----------------------------
        // Buscar si esta ingresado 
        for (Iterator<FacturaDetalle> iterator = detalle.iterator(); iterator.hasNext();)
          {
            FacturaDetalle next = iterator.next();
            
            if ((next.getArticulo().getDescripcion().equals(articulo.getDescripcion())) && !found)
              {
                next.incCantidad();
                found = true;
              }
          }
        
        // Si no esta ingresado, agregar
        if (!found) detalle.add(new FacturaDetalle(articulo));
    }

    
    
    // SALIDA =================================================================
    public String toString()
    {
        impuestos.clear();
        // Cabecera --------------------------------------------
        String result = "Descripcion                   Cant. X     Precio =        SubTotal\n";
        Double subTotal = 0.0;

        for (Iterator<FacturaDetalle> iterator = detalle.iterator(); iterator.hasNext();)
          {
            FacturaDetalle next = iterator.next();

            // Armar linea detalle -------------------------
            result += String.format("%-27s", next.getArticulo().getDescripcion());
            result += "   ";
            result += String.format("%5d", next.getCantidad());
            result += " x ";
            result += String.format("%10.2f", next.getArticulo().getPrecio());
            result += " = ";
            result += String.format("%15.2f", next.getArticulo().getPrecio() * next.getCantidad());
            result += String.format(" --> %-8s", next.getArticulo().getClase());
            result += "\n";
            // ---------------------------------------------
            subTotal += next.getTotal();

            // Cargar impuesto para la clkase de articulo ........
            addImpuesto(next);
          }
        
        result += String.format("%66.2f SubTotal", subTotal);

        // Mostrar lineas impuestos -----------------------------------------
        if (impuestos.size() > 0)
          {
            result += "\n -= Impuestos =-------------------------\n";
            result += "        Producto  Impuesto     Total con impuesto\n";
            Double subTotalImpuesto = 0.0;

            for (Iterator<FacturaImpuestos> iterator = impuestos.iterator(); iterator.hasNext();)
              {
                FacturaImpuestos next = iterator.next();
                result += String.format("(%5d) ", next.getCantidad());
                result += String.format("%-12s", next.getClase());
                result += String.format("%3.2f", next.getImpuesto()) + "% ";
                result += String.format("%20.2f", next.getTotal()) + "\n";
                
                subTotalImpuesto += next.getTotal();
              }
            
            result += "\nTOTAL ----> " + String.format("%20.2f", subTotalImpuesto);
          }

        if (detalle.size() == 0)
            return "=== Factura vacia ===";
        else
            return result;
    }

    // Agregar impuesto sbre la clase de producto ==========================
    private void addImpuesto(FacturaDetalle detalle)
    {
        Boolean found = false;
        
        for (Iterator<FacturaImpuestos> iterator = impuestos.iterator(); iterator.hasNext();)
          {
            FacturaImpuestos next = iterator.next();
            
            if (next.getClase().equals(detalle.getArticulo().getClase()))
              {
                next.incTotal(detalle.getTotalImpuesto(), detalle.getCantidad() );
                found = true;
              }
          }

        if (!found)
          {
             impuestos.add( new FacturaImpuestos(detalle.getArticulo().getClase(), 
                                                 detalle.getArticulo().getImpuesto(), 
                                                 detalle.getArticulo().getPrecioImpuesto()));
          }   
             
    }
 
}
