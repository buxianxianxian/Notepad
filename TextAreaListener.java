import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.event.*;

public class TextAreaListener implements DocumentListener {
    Window view;
    public void setView(Window view) {
        this.view = view;
    }
    
    public void insertUpdate(DocumentEvent e) {
        updateStatus();
    }

    public void removeUpdate(DocumentEvent e) {
        updateStatus();
    }

    public void changedUpdate(DocumentEvent e) {
        updateStatus();
    }

    private void updateStatus() {
/*         int caretPosition = view.getTextArea().getCaretPosition();    //返回文本组件的文本插入符的位置
        int line = view.getTextArea().getLineOfOffset(caretPosition) + 1;
        int column = caretPosition - view.getTextArea().getLineStartOffset(line - 1) + 1;
 */        view.getStatusLabel().setText("Line: " + "line" + ", Column: " + "column");
    }
}