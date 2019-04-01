package bean;

public class MyMessage {
    private  String message;

    public MyMessage(String message) {

        this.message = message;
    }

    public MyMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
