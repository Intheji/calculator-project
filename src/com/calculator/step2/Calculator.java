package com.calculator.step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char oper) {

        // 연산 결과를 담을 변수
        int result = 0;

        // 연산
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case  '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다");
                }
                result = num1 / num2;
                break;
            default:
                // 연산 기호
                throw  new IllegalArgumentException("올바른 연산 기호를 입력하세요 (+, -, *, /");
        }

        // 계산 결과 저장
        results.add(result);

        // 계산 결과 반환
        return result;
    }
    
    // results를 가져오는 통로
    public List<Integer> getResults() {
        return results;
    }
    
    // results를 수정할 수 있는 통로
    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public void removeResult() {
        results.remove(0);
    }
}
