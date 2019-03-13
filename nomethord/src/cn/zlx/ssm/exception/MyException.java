package cn.zlx.ssm.exception;

/**
 * @author zlx
 */
public class MyException extends Exception {
    public String message;

    public MyException(String message) {
        super(message);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
