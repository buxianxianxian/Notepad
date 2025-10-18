import java.awt.event.*;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;

public class FormatMenuListener implements ActionListener {
    Window view;
    public void setView(Window view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        JCheckBoxMenuItem checkBoxMenuItem = (JCheckBoxMenuItem)e.getSource();
        boolean isWordWrapEnabled = checkBoxMenuItem.isSelected();
        String itemName = checkBoxMenuItem.getText();
        if (itemName.equals("自动换行")) {
            if (isWordWrapEnabled) {
                view.getTextArea().setLineWrap(true);
            }
            else {
                view.getTextArea().setLineWrap(false);
            }
        }
    }
}
