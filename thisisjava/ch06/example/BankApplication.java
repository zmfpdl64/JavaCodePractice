package thisisjava.ch06.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
    private final List<Account> 계좌관리 = new ArrayList<>();
    private boolean 계속 = true;
    private BankUi 출력 = new BankUi();

    private Scanner sc = new Scanner(System.in);

    public BankApplication() {
    }

    public 선택 메뉴선택() {
        메뉴출력();
        출력.printMessage(출력.CHOICE);
        return 선택.getChoice(sc.nextInt());

    }

    public void 메뉴출력() {
        출력.printMessage(출력.line);
        출력.printMessage(출력.menu);
        출력.printMessage(출력.line);
    }

    public void 계좌생성() {
        출력.printMessage(출력.semi_line);
        출력.printMessage(출력.newAccount);
        출력.printMessage(출력.semi_line);

        출력.printMessage(출력.id);
        String 계좌번호 = sc.next();
        출력.printMessage(출력.username);
        String 사용자이름 = sc.next();
        출력.printMessage(출력.money);
        long 예금할돈 = (long) sc.nextInt();
        계좌관리.add(Account.of(계좌번호, 사용자이름, 예금할돈));
    }

    public void 계좌목록() {
        출력.printMessage(출력.semi_line);
        출력.printMessage(출력.accountList);
        출력.printMessage(출력.semi_line);
        for (Account 계좌 : this.계좌관리) {
            출력.printMessage(계좌);
        }
    }

    public void 예금() {
        출력.printMessage(출력.semi_line);
        출력.printMessage(출력.add);
        출력.printMessage(출력.semi_line);
        String 계좌번호 = sc.next();
        long 예금할돈 = (long) sc.nextInt();
        계좌조회(계좌번호).addMoney(예금할돈);
    }

    public void 출금() {
        출력.printMessage(출력.semi_line);
        출력.printMessage(출력.sub);
        출력.printMessage(출력.semi_line);
        String 계좌번호 = sc.next();
        long 출금할돈 = (long) sc.nextInt();
        계좌조회(계좌번호).subMoney(출금할돈);
    }

    public void 종료() {
        출력.printMessage(출력.END_PROGRAM);
        this.계속 = false;
    }


    public Account 계좌조회(String id) {
        return 계좌관리.stream()
                .filter(i -> i.getId().equals(id))
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }

    public static void main(String[] args) {
        BankApplication 뱅크앱 = new BankApplication();

        while (뱅크앱.계속) {
            try {
                선택 c = 뱅크앱.메뉴선택();
                if (선택.계좌생성.equals(c)) {
                    뱅크앱.계좌생성();
                } else if (선택.계좌목록.equals(c)) {
                    뱅크앱.계좌목록();
                } else if (선택.예금.equals(c)) {
                    뱅크앱.예금();
                } else if (선택.출금.equals(c)) {
                    뱅크앱.출금();
                } else if (선택.종료.equals(c)) {
                    뱅크앱.종료();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    enum 선택 {
        계좌생성(1),
        계좌목록(2),
        예금(3),
        출금(4),
        종료(5);

        private int num;

        선택(int num) {
            this.num = num;
        }

        private static 선택 getChoice(int num) {

            return Arrays.stream(values())
                    .filter(i -> i.num == num)
                    .findFirst()
                    .orElseThrow( () -> new IllegalStateException("1에서 5까지 선택지를 골라주세요"));
        }
    }
}


class BankUi {
    public final String line = "--------------------------------------------------%n";
    public final String menu = "1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료%n";
    public final String newAccount = "계좌생성%n";
    public final String accountList = "계좌목록%n";
    public final String add = "예금%n";
    public final String sub = "예금%n";
    public final String end = "프로그램 종료%n";

    public final String semi_line = "------------%n";
    public final String id = "계좌번호: ";
    public final String username = "계좌주: ";
    public final String money = "초기입금액: ";
    public final String result = "결과: ";
    public final String CHOICE = "선택> ";
    public final String MAKE_ACCOUNT_SUCCESS = "계좌가 생성되었습니다.%n";
    public final String SUB_MOENY_SUCCESS = "출금이 성공되었습니다.%n";
    public final String END_PROGRAM = "프로그램 종료%n";
    public final String INDENT = "    ";

    public void printMessage(String message) {
        System.out.printf(message);
    }

    public void printMessage(Account account) {
        System.out.println(account.getId() + INDENT + account.getName() + INDENT + account.getMoney());
    }
}

class Account {
    private String id;
    private String name;
    private long money;

    private Account(String id, String name, long money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public static Account of(String id, String name, long money) {
        return new Account(id, name, money);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getMoney() {
        return this.money;
    }

    public void addMoney(long money) {
        if (money < 0) {
            throw new IllegalStateException("0원 미만인데...");
        }
        this.money += money;
    }

    public void subMoney(long money) {
        try {
            if (money > this.money) {
                throw new IllegalStateException("돈 출금 못해요...");
            }
            this.money -= money;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
