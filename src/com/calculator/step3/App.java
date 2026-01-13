package com.calculator.step3;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // 계산기 인스턴스 생성
        ArithmeticalCalculator<Number> calculator = new ArithmeticalCalculator<>();

        Scanner sc = new Scanner(System.in);


        while(true){

            Number num1;
            Number num2;

            // 첫 번째 숫자를 제대로 입력 받을 때까지 반복문 돌림
            while(true){
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String input = sc.next();

                try {
                    // Scanner를 사용하여 양의 정수를 입력받는다
                    num1 = parseNumber(input);
                    break;
                } catch (Exception e) {
                    // 숫자가 입력되지 않아 프로그램이 오류나는 것을 예외 처리
                    System.out.println("숫자를 입력해 주세요. ㅜㅜ");
                }
            }

            // 두 번째 숫자 입력
            while(true){
                System.out.print("두 번째 숫자를 입력하세요: ");
                String input = sc.next();

                try {
                    num2 = parseNumber(input);
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력해 주세요. ㅜㅜ");
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
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + forResult(result));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            
            
            // 명령 처리
            System.out.println(
                    "더 계산하시겠습니까? exit 입력 시 종료 / remove 입력 시 첫 결과 삭제 " +
                            "/ reset 전체 결과 삭제 / results 저장된 결과 조회 " +
                            "/ 아무거나 누르면 계속됩니다 / bigger 입력값보다 큰 결과 조회");
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
            } else if (cmd.equals("bigger")){
                // 입력값보다 큰 결과 조회
                System.out.println("기준값을 입력하세요: ");
                String input = sc.next();
                try {
                    double baseValue = parseNumber(input).doubleValue();
                    List<Double> biggerResults = calculator.getResultsBiggerThan(baseValue);
                    System.out.println("입력값(" + baseValue + ")보다 큰 결과들: " + biggerResults);
                } catch (IllegalArgumentException e) {
                    System.out.println("기준값은 숫자로 입력해 주세요 ㅜㅜ");
                }
            }
        }

        sc.close();
    }

    // 출력을 int로 하기
    private static String forResult(double result) {
        if (result == (int) result) {
            return String.valueOf((int) result);
        }
        return String.valueOf(result);
    }

    // 문자열을 숫자로 바꿈
    private static Number parseNumber(String input) {
        if (input.contains(".")) {
            return Double.parseDouble(input);
        }
        return Integer.parseInt(input);
    }
}
