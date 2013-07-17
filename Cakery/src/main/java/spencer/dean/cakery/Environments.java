package spencer.dean.cakery;

public enum Environments {

    DEVELOPMENT("http://development/"),
    TESTING("http://testing/"),
    PRODUCTION("http://www.example.com/");

    private final String url;

    Environments(String url) {
        this.url = url;
    }

    public String url() { return url; }
}