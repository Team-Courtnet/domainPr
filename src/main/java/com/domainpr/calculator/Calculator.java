package com.domainpr.calculator;


import java.util.ArrayList;
import java.util.List;

public class Calculator {


    private final String stringArray;

    public Calculator (String stringArray) throws Exception{
        this.stringArray = stringArray;
    }

    public ArrayList<String> ifAnotherDistinguisher(String stringArray) throws Exception {

        String distinguisher = "[,:]";
        String numbers = stringArray;

        if (stringArray.startsWith("//")){
            int distinguisherIndex = stringArray.indexOf("\n");
            distinguisher = stringArray.substring(2, distinguisherIndex);
            numbers = stringArray.substring(distinguisherIndex+1);
        }

        ArrayList<String> tupleOfDistinguisherAndNumbers = new ArrayList<>();

        tupleOfDistinguisherAndNumbers.add(distinguisher);
        tupleOfDistinguisherAndNumbers.add(numbers);

    return tupleOfDistinguisherAndNumbers;
    }

    public List<Integer> ifNotNumberOrNegative(ArrayList<String> fixedDistinguisherAndNumbers) throws Exception {

        String[] numberTokens = fixedDistinguisherAndNumbers.get(1).split(fixedDistinguisherAndNumbers.getFirst());
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
