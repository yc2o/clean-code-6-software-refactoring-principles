import java.util.regex.Pattern;

public class User {
    private String email;
    private String facebookAccountURL;

    public void addEmail(String email) {
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Email tidak valid");
        }
        this.email = email;
    }

    public void addFacebookAccountURL(String facebookAccountURL) {
        if (facebookAccountURL == null || !isValidFacebookURL(facebookAccountURL)) {
            throw new IllegalArgumentException("URL Facebook tidak valid");
        }
        this.facebookAccountURL = facebookAccountURL;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, email);
    }

    private boolean isValidFacebookURL(String url) {
        return url.startsWith("https://facebook.com/") || url.startsWith("https://www.facebook.com/");
    }
}