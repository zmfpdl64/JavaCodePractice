package javastudy;

public class 캡슐화 {
    public static void main(String[] args) {
        객체 사람 = new 객체("name", 25);
        이름변경(사람);
        System.out.println(사람.getName());
    }
    public static void 이름변경(객체 사람) {
        사람.setName("newName");
        사람 = new 객체("newName2", 20);
    }
}

class 객체 {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    Integer age;

    public 객체(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}