package thisisjava.ch08.sec11;

public class HankookTire implements Tire{
    public String name = "한국 타이어";
    public int tirePrice = 5000;

    @Override
    public void brand() {
        System.out.println(name);
    }

    @Override
    public boolean comparePrice(int tirePrice) {
        return this.tirePrice >= tirePrice;
    }
    public int getPrice() {
        return this.tirePrice;
    }
}
