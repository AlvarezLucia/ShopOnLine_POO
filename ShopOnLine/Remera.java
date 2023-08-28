public class Remera extends Producto {
    private char talle;
    
    public Remera(String desc, int codigo, double precio, char talle) {
        super(desc, codigo, precio);
        this.talle = talle;
    }
    
    @Override
    public double getPrecio() {
        double precioPorTalle = precio;
        switch (talle) {
            case 'S':
                break;
            case 'M':
                precioPorTalle = precioPorTalle + (precioPorTalle*0.05);
                break;
            case 'L':
                precioPorTalle = precioPorTalle + (precioPorTalle*0.1);
                break;
            case 'X':
                precioPorTalle = precioPorTalle + (precioPorTalle*0.15);
                break;
            default:
                System.out.println("Talle incorrecto.");
                break;
        }
        return precioPorTalle;
    }
    
    @Override
    public String toString() {
        return super.toString() + "(Talle: " + this.talle + ")";
    }
}