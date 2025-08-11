package lotto;

public class Validator {

    public int validateLottoNumber(int number) {
        if (number < 1 || number > 45) {

            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45여야 합니다.");
        }
        return number;
    }

}
