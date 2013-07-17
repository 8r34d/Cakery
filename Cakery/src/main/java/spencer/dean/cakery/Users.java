package spencer.dean.cakery;

public enum Users {

    GOOD("8r34d@breadbox.com", "bread"),
    BAD("h4ck@hackbox.com", "hack"),
    EMPTY("", "");

    private String email;
    private String password;
    
    Users (String userEmail, String userPassword) {
        email = userEmail;
        password = userPassword;
    }

    public String email() { return email; }

    public String password() { return password; }
}
