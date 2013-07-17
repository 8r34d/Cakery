package spencer.dean.cakery;

public enum Errors {

    LOGIN_EMAIL_REQUIRED("The email field is required."),
    LOGIN_PASSWORD_REQUIRED("The password field is required."),
    LOGIN_CREDENTIALS_INVALID("Invalid email & password combination.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String message() { return message; }
}