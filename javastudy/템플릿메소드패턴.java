package javastudy;

public class 템플릿메소드패턴 {

    abstract class Template{
        private String name;
        private String age;

         public final void introduce() {
            myAge();
            myName();
         }
         abstract public void myName();
         abstract public void myAge();
    }
    class TemplateImpl extends Template{

        @Override
        public void myName() {
            System.out.println("이우진 입니다.");
        }

        @Override
        public void myAge() {
            System.out.println("25살 입니다.");
        }
    }
}
