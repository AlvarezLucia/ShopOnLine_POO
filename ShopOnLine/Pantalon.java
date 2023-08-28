public class Pantalon extends Producto{
    private int talle;
    private String modelo;
    
    public Pantalon(String desc, int codigo, double precio, String modelo, int talle) {
        super(desc, codigo, precio);
        this.modelo = modelo;
        this.talle = talle;
    }
    
    @Override
    public double getPrecio(){
        double precioPorModelo = precio;
        switch(modelo){
            case "Oxford":
                precioPorModelo = precioPorModelo + (precioPorModelo*0.15);
                break;
            case "Skinny":
                precioPorModelo = precioPorModelo + (precioPorModelo*0.25);
                break;
            case "Recto":
                precioPorModelo = precioPorModelo - (precioPorModelo*0.15);
                break;
            default:
                System.out.println("Modelo incorrecto");
                break;
        }
        return precioPorModelo;
    }
    
    @Override
    public String toString(){
        return super.toString() + "(Talle: " + this.talle + " - Modelo: " + modelo + ")";
    }
}
