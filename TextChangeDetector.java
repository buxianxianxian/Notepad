public class TextChangeDetector {
    public String oldText;

    public TextChangeDetector(String initialText) {
        this.oldText = initialText;
    }

    public boolean hasTextChanged(String newText) {
        return !newText.equals(oldText);
    }

    public void updateText(String newText) {
        this.oldText = newText;
    }
}
