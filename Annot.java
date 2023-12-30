import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Annot {
    @SuppressWarnings("unchecked")
    static List list = new ArrayList();
    public static void main(String[] args) {
        Class<?> test = Test.class;
        for(Method field : test.getDeclaredMethods()){
            for(Annotation ano : field.getDeclaredAnnotations()){
                System.out.println(ano.annotationType());
            }
        }

//        Test test = new Test();
//        test.test();
//        list.add(new Object());
    }

    public static void test(){

    }

}

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface AnnotTest{

}



@AnnotTest
class Test{
    @AnnotTest
    public void test(){
        System.out.println("test");
    }
}



@FunctionalInterface
interface Test1{

    public void test();
}