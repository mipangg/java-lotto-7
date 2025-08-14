package lotto;

public enum ErrorCode {
    OUT_OF_BOUNDS("[ERROR] 로또 번호는 1~45사이여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    WRONG_NUMBER_FORMAT("[ERROR] 입력된 값이 숫자가 아닙니다."),
    WRONG_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
