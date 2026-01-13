package com.calculator.step3;

import java.util.ArrayList;
import java.util.List;

public class ArithemeticalCalculator {

    // 결과를 저장하는 리스트
    private final List<Integer> results = new ArrayList<>();

    // enum에서 연산자를 받는다
    public int calculate(int num1, int num2, OperatorType operator) {
        int result = 0;

        switch (operator) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                // 나눗셈에서 분모가 0이면 예외처리
                if (num2 == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
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
    public List<Integer> getResults() {
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
        int removed = results.remove(0);
        System.out.println("가장 먼저 저장된 결과(" + removed + ")를 삭제했습니다.");

    }

}
