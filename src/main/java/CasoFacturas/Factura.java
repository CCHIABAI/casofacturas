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

    private ArrayList<FacturaDetalle> detalle; // Listado de articulos y sus cantidades por linea
    private ArrayList<FacturaImpuestos> impuestos; // Impuestos agregados por clase de producto.
    
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

        // Buscar si esta ingresado 
        for (Iterator<FacturaDetalle> iterator = detalle.iterator(); iterator.hasNext();)
          {
            FacturaDetalle next = iterator.next();
            
            if ((next.getArticulo().getDescripcion().equals(articulo.getDescripcion())) && !found)
              {
                next.incCantidad(); // Incrementar en uno la cantidad de la linea.
                found = true;
              }
          }
        
        // Si no esta ingresado, agregar la linea de detalle correspondiente
        if (!found) detalle.add(new FacturaDetalle(articulo));
    }
    
    // SALIDA =================================================================
    public String toString()
    {
        impuestos.clear(); // Limpiar las lineas de impuestos
        // Cabecera --------------------------------------------
        String result = "Descripcion                   Cant. X     Precio =        SubTotal\n";
        Double subTotal = 0.0;

        // Recorrer el listado de detalle de articulos ------------------------
        for (Iterator<FacturaDetalle> iterator = detalle.iterator(); iterator.hasNext();)
          {
            FacturaDetalle next = iterator.next();
            subTotal += next.getTotal();

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

            addImpuesto(next); // Cargar impuesto para la clase de articulo 
          }
        
        result += String.format("%66.2f SubTotal", subTotal);

        // Mostrar lineas impuestos ++++++++++++++++++++++++++++++++++++
        if (impuestos.size() > 0)
          {
            // Cabecera ------------
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

            // SubTotal --------------------------------------  
            result += "\nTOTAL ----> " + String.format("%20.2f", subTotalImpuesto);
          }

        // Devolver la salida -----------------------------
        if (detalle.size() == 0)
            return "=== Factura vacia ===";
        else
            return result;
    }

    // Agregar impuesto sbre la clase de producto ==========================
    private void addImpuesto(FacturaDetalle detalle)
    {
        Boolean found = false;
        
        // Recorrer los impuestos recogidos del listado ---------------------
        for (Iterator<FacturaImpuestos> iterator = impuestos.iterator(); iterator.hasNext();)
          {
            FacturaImpuestos next = iterator.next();
            
            if (next.getClase().equals(detalle.getArticulo().getClase()))
              {
                // Incrementar los valores en el impuesto encontrado.
                next.incTotal(detalle.getTotalImpuesto(), detalle.getCantidad() );
                found = true;
              }
          }

        // Agregar nuevos impuesto detectado ---------------------
        if (!found)
          {
             impuestos.add( new FacturaImpuestos(detalle.getArticulo().getClase(), 
                                                 detalle.getArticulo().getImpuesto(), 
                                                 detalle.getArticulo().getPrecioImpuesto()));
          }   
             
    }
 
}
