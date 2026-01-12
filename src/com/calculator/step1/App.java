package com.calculator.step1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true){

            int num1 = 0;
            int num2 = 0;

            while(true){
                try {
                    // Scanner를 사용하여 양의 정수를 입력받는다
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();

                    // 양의 정수가 입력이 안 되었을 경우
                    if (num1 < 0) {
                        System.out.println("0 이상의 정수를 입력하세요.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    // 숫자가 입력되지 않아 프로그램이 오류나는 것을 예외 처리
                    System.out.println("숫자를 입력해 주세요. ㅜㅜ");
                    // 잘못 입력된 것을 버린다
                    sc.next();
                }
            }

            while(true){
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();

                    if (num2 < 0) {
                        System.out.println("0 이상의 정수를 입력하세요.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력해 주세요. ㅜㅜ");
                    sc.next();
                }
            }


            // 사칙연산 기호를 입력받는다
            System.out.print("사칙연산 기호를 입력하세요: ");
            char oper = sc.next().charAt(0);

            int result = 0;

            switch (oper){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if(num2 == 0){
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("올바른 연산 기호를 입력하세요 (+, -, *, /)");
                    continue;
            }
            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? exit 입력 시 종료");
            String exit = sc.next();
            if (exit.equals("exit")){
                System.out.println("계산기를 종료합니다");
                break;
            }
        }

        sc.close();

    }
}
