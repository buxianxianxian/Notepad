import java.awt.event.*;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HelpMenuListener implements ActionListener {
    Window view;
    public void setView(Window view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem)e.getSource();
        String itemName = menuItem.getText();
        if (itemName.equals("说明书")) {
            view.getTextArea().requestFocus();  
            JOptionPane.showMessageDialog(view, "路漫漫其修远兮，吾将上下而求索。", "帮助主题", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
