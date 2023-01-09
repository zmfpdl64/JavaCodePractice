## String -> 숫자형(int, double, float, long, short)

```java

String sNum = "1234";
Integer.parseInt(sNum);
Integer.valueOf(sNum);

Double.parseDouble(sNum);
Double.valueOf(sNum);

Float.parseFloat(sNum);
Float.valueOf(sNum);

Long.parseLong(sNum);
Long.valueOf(sNum);

Short.parseLong(sNum);
Short.valueOf(sNum);


```

## 숫자형 -> String

```java
Integer.ToString();
String.valueOf();
```

## Int -> Double
```java
int a = 10;
Double d = (double) a;
double d = (double) a;

```

## Double -> Int
```java

Double d = 10.5;
int a = (int) d;
int a = Math.floor(d); // 내림
int a = Math.round(d); // 반올림
int a = Math.ceil(d); // 올림

```

## Math
```java

int a = -10;
Math.abs(a); //절대값
Math.pow(2, 10) // 2^10제곱
Math.sqrt(25) // 25의 1/2제곱

```