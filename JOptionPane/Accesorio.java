public class Accesorio extends Producto {
    private double peso;
    private String metal;

    public Accesorio(String desc, int codigo, double precio, double peso, String metal) {
        super(desc, codigo, precio);
        this.peso = peso;
        this.metal = metal;
    }

    @Override
    public double getPrecio() {
        double precioPorMetal = precio;
        double precioPorGramo = 1;
        switch(metal){
            case "ORO":
                precioPorMetal = 1500;
                break;
            case "PLATA":
                precioPorMetal = 500;
                break;
            case "ACERO": 
                precioPorMetal = 50;
                break;
            default:
                System.out.println("Metal incorrecto");
                break;
        }
        double ajuste = peso * precioPorGramo;
        precioPorMetal += ajuste;

        return precioPorMetal;
    }
    
    @Override
    public String toString(){
        return super.toString() + "(Peso: " + this.peso + " gramos - Metal: " + this.metal + ")";
    }
}