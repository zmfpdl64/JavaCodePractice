package equalshashcode;

import java.util.Objects;

public class EqualsHashCode {
    public static void main(String[] args) {
        EqualHashTest e1 = new EqualHashTest(10);
        EqualHashTest e2 = new EqualHashTest(10);
        System.out.println(e1.equals(e2));

    }
}
class EqualHashTest {
    int a;
    public EqualHashTest(int a) {
        this.a = a;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(Objects.isNull(obj)) return false;
        if(!(obj instanceof EqualHashTest)) return false;
        EqualHashTest typeCast = (EqualHashTest) obj;
        return typeCast.a == this.a;
    }
}


