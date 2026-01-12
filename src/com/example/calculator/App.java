package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true){
            // Scanner를 사용하여 양의 정수를 입력받는다
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 사칙연산 기호를 입력받는다
            System.out.print("사칙연산 기호를 입력하세요: ");
            char oper = sc.next().charAt(0);

            switch (oper){
                case '+':
                    System.out.println("결과: " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("결과: " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("결과: " + (num1 * num2));
                    break;
                case '/':
                    if(num2 == 0){
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        System.out.println("결과: " + (num1 / num2));
                    }
                    break;
                default:
                    System.out.println("올바른 연산 기호를 입력하세요 (+, -, *, /)");
            }

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
