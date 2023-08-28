public abstract class Producto {
    protected String desc;
    protected int codigo;
    protected double precio;
    protected TipoProducto tipo;

    public Producto(String desc, int codigo, double precio, TipoProducto tipo) {
        this.desc = desc;
        this.codigo = codigo;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public abstract double getPrecio();

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "#" + this.codigo + " - " + this.desc + "........$ " + this.precio + " Tipo: " + tipo;
    }
}