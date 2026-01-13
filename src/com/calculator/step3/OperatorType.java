package com.calculator.step3;

// 사칙연산을 enum으로 고정해서 관리
public enum OperatorType {
    // enum 값(상수) 정의
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    // 각 enum이 들고 있는 문자 저장
    private final char operator;

    // enum 생성자 적은 값이 여기로 들어옴
    OperatorType(char operator) {
        this.operator = operator;
    }
    
    // enum이 들고 있는 operator 문자 반환
    public char getOperator() {
        return operator;
    }

    // 입력받은 문자를 enum으로 바꿔 줌
    public static OperatorType from(char operator) {
        for (OperatorType type : OperatorType.values()) {
            // enum이 가진 문자와 입력이 같으면 enum 반환
            if (type.getOperator() == operator) {
                return type;
            }
        }
        
        // 일치하는 연산자 없을 때
        throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
    }
}
