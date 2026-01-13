package com.calculator.step3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticalCalculator<T extends Number> {

    // 결과를 저장하는 리스트
    private final List<Double> results = new ArrayList<>();

    // 제네릭 T(Number)의 값을 받아서 연산을 한다
    public double calculate(T num1, T num2, OperatorType operator) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();

        double result;

        switch (operator) {
            case ADD:
                result = a + b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                // 나눗셈에서 분모가 0이면 예외처리
                if (b == 0.0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("연산자가 잘못 입력되었습니다.");
        }
        // 계산 끝난 결과 저장
        results.add(result);

        // 결과를 호출한 곳에 돌려줌
        return result;
    }

    // 조회
    public List<Double> getResults() {
        return results;
    }

    // 초기화
    public void setResults() {
        results.clear();
    }

    // 가장 먼저 저장된 결과 삭제(0번 인덱스)
    public void removeResult() {
        if (results.isEmpty()) {
            System.out.println("삭제할 결과 없습니다.");
            return;
        }
        double removed = results.remove(0);
        System.out.println("가장 먼저 저장된 결과(" + removed + ")를 삭제했습니다.");

    }

    // results 리스트를 스트림으로 만듦
    public List<Double> getResultsBiggerThan(double baseValue) {
        return results.stream()
                .filter(r -> r > baseValue)
                .toList();
    }

}
