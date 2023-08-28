import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del cliente:"));

        Cliente cliente = new Cliente(nombre, direccion, telefono);

        int cantidadProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Productos:"));

        Venta venta = new Venta(cliente, LocalDate.now());

        for (int i = 1; i <= cantidadProductos; i++) {
            String desc = JOptionPane.showInputDialog("Ingrese la descripción del producto " + i + ":");
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto " + i + ":"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto " + i + ":"));

            String tipoProducto = JOptionPane.showInputDialog("Elija el tipo de producto:\n1. Remera\n2. Pantalón\n3. Accesorio");
            Producto producto;

            switch (tipoProducto) {
                case "1":
                    char talle = JOptionPane.showInputDialog("Ingrese el talle de la remera:").charAt(0);
                    producto = new Remera(desc, codigo, precio, talle);
                    break;
                case "2":
                    String modeloPantalon = JOptionPane.showInputDialog("Ingrese el modelo del pantalón:");
                    int tallePantalon = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el talle del pantalón:"));
                    producto = new Pantalon(desc, codigo, precio, modeloPantalon, tallePantalon);
                    break;
                case "3":
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del accesorio en gramos:"));
                    String metal = JOptionPane.showInputDialog("Ingrese el tipo de metal (ORO, PLATA, ACERO):");
                    producto = new Accesorio(desc, codigo, precio, peso, metal);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    i--;
                    continue;
            }
            venta.agregarProducto(producto);
        }
        venta.imprimirFactura();
    }
}
