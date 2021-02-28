package tasks.bring_it_on.dataEntity;

public class Paste {
    private final String code;
    private final String syntaxHighlightingValue;
    private final String pasteExpirationValue;
    private final String title;

    public Paste(String code, String syntaxHighlightingValue, String pasteExpirationValue, String title) {
        this.code = code;
        this.syntaxHighlightingValue = syntaxHighlightingValue;
        this.pasteExpirationValue = pasteExpirationValue;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getSyntaxHighlightingValue() {
        return syntaxHighlightingValue;
    }

    public String getPasteExpirationValue() {
        return pasteExpirationValue;
    }

    public String getTitle() {
        return title;
    }
}
