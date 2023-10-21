package javastudy;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DynamicEnumExample {
    public static void main(String[] args) {
        // 크롤링한 카테고리 문자열 배열
        String[] categoryStrings = {"Category1", "Category2", "Category3"};

        // Enum 클래스 이름
        String enumClassName = "CategoryEnum1";

        // Enum 클래스 생성
//        createEnum(enumClassName, categoryStrings);

        // 생성한 Enum 클래스 사용 예제
        CategoryEnum category1 = CategoryEnum.Category1;
        CategoryEnum category2 = CategoryEnum.Category2;
        CategoryEnum category3 = CategoryEnum.Category3;

        System.out.println(category1);
        System.out.println(category2);
        System.out.println(category3);
    }

    public static void createEnum(String enumClassName, String[] enumValues) {
        // Enum 클래스 템플릿 코드 생성
        String builder = """
                package javastudy;
                public enum %s {
                    %s,
                    %s,
                    %s;
                }
                """.formatted(enumClassName, enumValues[0],enumValues[1], enumValues[2] );
//        StringBuilder enumCode = new StringBuilder();
//        enumCode.append("public enum ").append(enumClassName).append(" {\n");


        // Enum 값들 추가
//        for (String value : enumValues) {
//            enumCode.append("\t").append(value).append(",\n");
//        }

        // Enum 클래스 마무리
//        enumCode.append("}");

        // 동적으로 생성한 Enum 클래스를 Java 파일로 출력
        try {
            PrintWriter writer = new PrintWriter("javastudy/" + enumClassName + ".java");
            writer.println(builder);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // 동적으로 생성한 Enum 클래스를 컴파일하고 로딩
//        try {
//            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
//
//            // 컴파일할 소스 코드
//            StringSourceCode sourceCode = new StringSourceCode(enumClassName, enumCode.toString());
//
//            // 컴파일할 소스 파일 객체
//            Iterable<? extends JavaFileObject> compilationUnits = Collections.singletonList(sourceCode);
//
//            // 클래스 파일의 출력 디렉토리
//            File outputDir = new File("out/production/코드테스트/javastudy");
//            if (!outputDir.exists()) {
//                outputDir.mkdirs();
//            }
//
//            // 컴파일 옵션
//            List<String> compileOptions = Arrays.asList("-d", outputDir.getAbsolutePath());
//
//            // 컴파일 태스크 생성
//            JavaCompiler.CompilationTask task = compiler.getTask(null, null, diagnostics, compileOptions, null, compilationUnits);
//
//            // 컴파일 수행
//            boolean success = task.call();
//
//            // 컴파일 결과 확인
////            if (success) {
////                // 컴파일 성공 시, 클래스 로더를 통해 동적으로 생성한 Enum 클래스 로딩
////                ClassLoader classLoader = DynamicEnumExample.class.getClassLoader();
////                Class<?> enumClass = classLoader.loadClass(enumClassName);
////
////                // 생성한 Enum 클래스 사용 예제
////                System.out.println("Dynamic Enum Class: " + enumClass.getName());
////                System.out.println("Enum Values: " + Arrays.toString(enumClass.getEnumConstants()));
////            } else {
////                // 컴파일 실패 시, 오류 메시지 출력
////                for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
////                    System.err.println(diagnostic.getMessage(null));
////                }
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    // StringSourceCode 클래스는 JavaFileObject 인터페이스를 구현한 사용자 정의 클래스입니다.
    // 컴파일할 소스 코드를 메모리에 있는 문자열로 제공하기 위해 사용됩니다.
    private static class StringSourceCode extends SimpleJavaFileObject {
        private final String code;

        public StringSourceCode(String className, String code) {
            super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }
}
