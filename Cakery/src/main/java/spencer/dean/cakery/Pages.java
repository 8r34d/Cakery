package spencer.dean.cakery;

public enum Pages {

    FOUR04("zzz"),
    HOME("home"),
    ABOUT("about"),
    LOGIN("admin/login"),
    LOGOUT("admin/logout"),
    DASHBOARD("admin/dashboard"),
    MOTD("admin/dashboard/motd");

    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String url() { return url; }
}