package thisisjava.ch12.sec04;

import java.util.Properties;

public class GetPropery {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String userNmae =  System.getProperty("user.name");
        Properties properties = System.getProperties();
        Properties p = System.getProperties();
        for(String name: p.stringPropertyNames())
        {
            System.out.println(name + ": "+System.getProperty(name));
        }

        System.out.println(osName);

    }
}
