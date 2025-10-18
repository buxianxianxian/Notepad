import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;

import javax.swing.JMenuItem;

public class EditMenuListener implements ActionListener {
    Window view;
    public void setView(Window view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem)e.getSource();
        String itemName = menuItem.getText();
        Find find = new Find(view.getTextArea());
        if (itemName.equals("剪切")) {
            view.getTextArea().requestFocus();  
            String text = view.getTextArea().getSelectedText();  
            StringSelection selection = new StringSelection(text);  
            view.getClipboard().setContents(selection,null);  
            view.getTextArea().replaceRange("", view.getTextArea().getSelectionStart(), view.getTextArea().getSelectionEnd());
        }
        else if (itemName.equals("复制")) {
            view.getTextArea().requestFocus();  
            String text = view.getTextArea().getSelectedText();  
            StringSelection selection = new StringSelection(text);  
            view.getClipboard().setContents(selection,null);  
        }
        else if (itemName.equals("粘贴")) {
            view.getTextArea().requestFocus();
            Transferable transferable = view.getClipboard().getContents(view);
            if (transferable == null) {
                return;
            }
            String text = "";
            try {
                text = (String)transferable.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception a) {
            }
            view.getTextArea().replaceRange(text,view.getTextArea().getSelectionStart(),view.getTextArea().getSelectionEnd());
        }
        else if (itemName.equals("删除")) {
            view.getTextArea().requestFocus();  
            view.getTextArea().replaceRange("", view.getTextArea().getSelectionStart(), view.getTextArea().getSelectionEnd());
        }
        else if (itemName.equals("查找")) {
            find.findManner();  //调用Zhao的findManner的方法
        }
    }
}
