package thisisjava.ch08.sec11;

public class Car {

    Tire tire1 = new HankookTire();
    Tire tire2 = new KumhoTire();

    public void compareTire() {
        if(tire1.comparePrice(tire2.getPrice())){
            tire1.brand();
            return;
        }
        tire2.brand();
    }

}
