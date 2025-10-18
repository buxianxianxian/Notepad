import java.awt.event.*;

import javax.swing.JCheckBoxMenuItem;

public class ViewMenuListener implements ActionListener {
    Window view;
    public void setView(Window view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        JCheckBoxMenuItem checkBoxMenuItem = (JCheckBoxMenuItem)e.getSource();
        boolean isOpenStatusLabel = checkBoxMenuItem.isSelected();
        String itemName = checkBoxMenuItem.getText();
        if (itemName.equals("状态栏")) {
            if (isOpenStatusLabel) {
                view.getStatusLabel().setVisible(true);
            } 
            else {
                view.getStatusLabel().setVisible(false);
            }
        }
    }
}
