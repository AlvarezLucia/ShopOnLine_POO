import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private ArrayList<Producto> listaProd;
    private Cliente cliente;
    private static int cantVentas = 0;
    private int nroFact;
    private LocalDate fecha;
    
    public Venta(Cliente cliente, LocalDate fecha){
        this.cliente = cliente;
        this.fecha = fecha;
        cantVentas++;
        nroFact = 1090 + cantVentas;
        listaProd = new ArrayList<>();
    }
    
    public void agregarProducto(Producto p) {
        listaProd.add(p);
    }
    
    public double calcularImporteTotal() {
        double importeTotal = 0;
        for (Producto prod : listaProd) {
            importeTotal += prod.getPrecio();
        }
        return importeTotal;
    }
    
    public void imprimirFactura(){
        System.out.println("Factura Nº: " + nroFact + " - " + fecha);
        System.out.println("Información del Cliente: ");
        cliente.mostrarDatos();
        for (Producto prod : listaProd) {
            System.out.println( prod.toString());
        }
        System.out.println("Total a pagar: $" + calcularImporteTotal());
    }
}
