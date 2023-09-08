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
        
        double importeArancelAduanero = 0;
        double importeArancelTransporte = 0;

        for (Producto p : listaProd) {
            System.out.println("- " + p.getDesc() + ", Precio: $" + p.getPrecio());

            if (p instanceof Importable) {
                Importable importable = (Importable) p;
                importeArancelAduanero += importable.calcularArancelAduanero(p.getPrecio());
                importeArancelTransporte += importable.calcularArancelTransporte(p.getPrecio());
            }
        }

        double importeTotal = calcularImporteTotal() + importeArancelAduanero + importeArancelTransporte;

        System.out.println("Arancel Aduanero: $" + importeArancelAduanero);
        System.out.println("Arancel de Transporte: $" + importeArancelTransporte);
        System.out.println("Importe total a pagar: $" + importeTotal);
    }
}