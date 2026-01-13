package com.calculator.step3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // 계산기 인스턴스 생성
        ArithemeticalCalculator calculator = new ArithemeticalCalculator();

        Scanner sc = new Scanner(System.in);


        while(true){

            int num1 = 0;
            int num2 = 0;

            // 첫 번째 숫자 입력
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

            // 두 번째 숫자 입력
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
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char oper = sc.next().charAt(0);

            OperatorType operator;
            // switch문을 호출로 Calculator 호출로 바꿈
            try {
                // 문자 입력 enum
                operator = OperatorType.from(oper);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 계산 calculator
            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            
            
            // 명령 처리
            System.out.println(
                    "더 계산하시겠습니까? exit 입력 시 종료 / remove 입력 시 첫 결과 삭제 " +
                            "/ reset 전체 결과 삭제 / results 저장된 결과 조회 " +
                            "/ 아무거나 누르면 계속됩니다");
            String cmd = sc.next();

            if (cmd.equals("exit")){
                System.out.println("계산기를 종료합니다");
                break;
            } else if (cmd.equals("remove")){
                // 첫 결과 삭제
                calculator.removeResult();
            } else if (cmd.equals("reset")){
                // 결과 초기화
                calculator.setResults();
                System.out.println("전체 결과 삭제");
            } else if (cmd.equals("results")){
                // 전체 결과 조회
                System.out.println("조회: " + calculator.getResults());
            }
        }

        sc.close();

    }
}
