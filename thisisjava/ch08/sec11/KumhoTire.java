package thisisjava.ch08.sec11;

public class KumhoTire implements Tire{
    public String name = "금호 타이어";
    public int tirePrice = 4500;
    @Override
    public void brand() {
        System.out.println(name);
    }

    @Override
    public boolean comparePrice(int tirePrice) {
        return getPrice() >= tirePrice;
    }

    public int getPrice(){
        return this.tirePrice;
    }
}
