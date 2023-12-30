import java.util.Objects;

public class DataT {
    public static void main(String[] args) {
        Data1 data1 = new Data1(1);
        Data1 data2 = new Data1(1);

        System.out.println(data1.equals(data2));

    }
}

class Data1 {
    private Integer x;

    public Data1(Integer x) {
        this.x = x;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data1 data1 = (Data1) o;
        return Objects.equals(x, data1.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
