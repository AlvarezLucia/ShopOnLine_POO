import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el teléfono del cliente: ");
        int telefono = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nombre, direccion, telefono);
        
        System.out.print("Ingrese la cantidad de Productos: ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine();

        Venta venta = new Venta(cliente, LocalDate.now());

        for (int i = 1; i <= cantidadProductos; i++) {
            System.out.print("Ingrese la descripción del producto " + i + ": ");
            String desc = scanner.nextLine();

            System.out.print("Ingrese el código del producto " + i + ": ");
            int codigo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese el precio del producto " + i + ": ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.println("Elija el tipo de producto (REMERA, PANTALON, ACCESORIO): ");
            String TipoProductoStr = scanner.nextLine();
            TipoProducto tipoProducto = TipoProducto.valueOf(TipoProductoStr);

            Producto producto;
            
            switch (tipoProducto) {
                case REMERA:
                    System.out.print("Ingrese el talle de la remera: ");
                    char talle = scanner.nextLine().charAt(0);
                    producto = new Remera(desc, codigo, precio, tipoProducto, talle);
                    break;
                case PANTALON:
                    System.out.print("Ingrese el modelo del pantalón: ");
                    String modeloPantalon = scanner.nextLine();
                    System.out.print("Ingrese el talle del pantalón: ");
                    int tallePantalon = scanner.nextInt();
                    scanner.nextLine();
                    producto = new Pantalon(desc, codigo, precio, tipoProducto, modeloPantalon, tallePantalon);
                    break;
                case ACCESORIO:
                    System.out.print("Ingrese el peso del accesorio en gramos: ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese el tipo de metal (ORO, PLATA, ACERO): ");
                    String metal = scanner.nextLine();
                    producto = new Accesorio(desc, codigo, precio, tipoProducto, peso, metal);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    continue;
            }
            venta.agregarProducto(producto);
        }
        venta.imprimirFactura();
    }
}