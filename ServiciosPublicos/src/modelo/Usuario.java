package modelo;

public class Usuario {
    // Declarar Constantes
    public static final int GAS_NATURAL = 5234;
    public static final int AGUA = 9256;
    public static final int ENERGIA = 6200;
    
    // Declarar Atributos
    private int estrato;
    private int consumo;
    private int servicio;

    // Constructor 
    public Usuario(int estrato, int consumo, int servicio) {
        this.estrato = estrato;
        this.consumo = consumo;
        this.servicio = servicio;
    }
    
    
    // Metodos Set y Get para cada uno
    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }
 
    //Metodos propios
    //Calculos para el valor a pagar por los servicios.
    public double calcularCosto(){
        double costo = 0;
        switch(this.servicio){
            case 3:
                costo = this.consumo * Usuario.GAS_NATURAL;
                break;
            case 2:
                costo = this.consumo * Usuario.AGUA;
                break;
            case 1:
                costo = this.consumo * Usuario.ENERGIA;
                break;   
        }
        return costo;
    }
    
    //Calcular Descuento o sobrecosto. 
    public double descuentoSobrecosto(){
        double costo;
        double descuento_sobrecosto = 0;        
        costo = calcularCosto();
        if(this.estrato <= 2){
            descuento_sobrecosto = costo * 0.50;
        }else if(this.estrato <= 4){
            descuento_sobrecosto = costo * 0.10;
        }else if(this.estrato <= 6){
            descuento_sobrecosto = -(costo * 0.25);
        }
        return descuento_sobrecosto;
    }
      
    //Calcular el impuesto por daños.
    public double calcularImpuesto(){
        double costo;
        double impuesto = 0;
        costo = calcularCosto();
        impuesto = costo * 0.01;
        return impuesto;
    }
    
    //Calcular el total a pagar en la factura teniendo en cuenta es descuento o sobrecosto y el impuesto.
    public double valorTotal(){
        double costo, descuento_sobrecosto, impuesto;
        double totalPagar = 0;
        costo = calcularCosto();
        descuento_sobrecosto = descuentoSobrecosto();
        impuesto = calcularImpuesto();
        totalPagar = costo - descuento_sobrecosto + impuesto;
        return totalPagar;
    }
}
