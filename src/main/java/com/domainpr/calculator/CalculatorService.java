package com.domainpr.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculatorRepository calculatorRepository;

    public List<Integer> getStringArray(String stringArray) throws Exception {

        // service layer에 모든 조건, 예외처리, 유효성 검증을 몰아 넣음 - 도메인 필요없군
        String distinguisher = "[,:]";
        String numbers = stringArray;

        if (stringArray.startsWith("//")){
            int distinguisherIndex = stringArray.indexOf("\n");
            distinguisher = stringArray.substring(2, distinguisherIndex);
            numbers = stringArray.substring(distinguisherIndex+1);
        }

        String[] numberTokens = numbers.split(distinguisher);
        List<Integer> result = new ArrayList<>();

        for(String numberToken : numberTokens) {
            try {
                int number = Integer.parseInt(numberToken);
                if (number < 0) { // 음수인지 확인
                    throw new RuntimeException("숫자가 아닌 값이나 음수를 입력할 수 없습니다."); // 음수일 경우 예외 발생
                }
                result.add(number);
            } catch (RuntimeException e) {
                throw new RuntimeException("숫자가 아닌 혹은 음수를 입력할 수 없습니다.");
            }
        }

        return result;
    }

}
