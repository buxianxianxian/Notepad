import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FileMenuListener implements ActionListener {
    Window view;
    public void setView(Window view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem)e.getSource();
        String itemName = menuItem.getText();
        //当前文件名
        File currentFile;
        //是否未保存过的文件
        boolean isNewFile = true;
        //判断文本是否变化
        String currentText = view.getCurrentText();
        boolean isTextChange = (currentText.equals(""))?false:true;
        //新建
        if (itemName.equals("新建")) {
            if (isTextChange) {
                //另存窗口
                int saveChoose = JOptionPane.showConfirmDialog(view, "您的文件尚未保存，是否保存？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);  
                if(saveChoose == JOptionPane.YES_OPTION) {  //选择'是'
                    JFileChooser fileChooser = new JFileChooser();  
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                    fileChooser.setDialogTitle("另存为");  
                    int result = fileChooser.showSaveDialog(view);  
                    if(result == JFileChooser.CANCEL_OPTION) {   
                        return;  
                    }  
                    File saveFileName = fileChooser.getSelectedFile();  
                    if(saveFileName == null || saveFileName.getName().equals("")) {   
                        JOptionPane.showMessageDialog(view, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);  
                    }  
                    else {   
                        try {   
                            FileWriter fw = new FileWriter(saveFileName);  
                            BufferedWriter bfw = new BufferedWriter(fw);  
                            bfw.write(currentText, 0, currentText.length());  
                            bfw.flush();//刷新该流的缓冲  
                            bfw.close();  
                            isNewFile = false;
                            currentFile = saveFileName;
                            view.setTitle(saveFileName.getName() + " - 记事本");  
                        }  
                        catch (IOException ioException) {  
                        }  
                    }  
                }  
                else if(saveChoose == JOptionPane.NO_OPTION) {   //选择'否'
                    view.getTextArea().replaceRange("", 0, currentText.length());  
                    view.setTitle("无标题 - 记事本");  
                    isNewFile = true;
                }  
                else if(saveChoose == JOptionPane.CANCEL_OPTION) {  //选择'取消'
                    return;  
                }
            }
        }//新建结束
        //打开
        else if (itemName.equals("打开")) {
            if (isTextChange) {
                //另存窗口
                int saveChoose = JOptionPane.showConfirmDialog(view, "您的文件尚未保存，是否保存？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);  
                if(saveChoose == JOptionPane.YES_OPTION) {  //选择'是'
                    JFileChooser fileChooser = new JFileChooser();  
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                    fileChooser.setDialogTitle("另存为");  
                    int result = fileChooser.showSaveDialog(view);  
                    if(result == JFileChooser.CANCEL_OPTION) {   
                        return;  
                    }  
                    File saveFileName = fileChooser.getSelectedFile();  
                    if(saveFileName == null || saveFileName.getName().equals("")) {   
                        JOptionPane.showMessageDialog(view, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);  
                    }  
                    else {   
                        try {   
                            FileWriter fw = new FileWriter(saveFileName);  
                            BufferedWriter bfw = new BufferedWriter(fw);  
                            bfw.write(currentText, 0, currentText.length());  
                            bfw.flush();//刷新该流的缓冲  
                            bfw.close();  
                            isNewFile = false;
                            currentFile = saveFileName;
                            view.setTitle(saveFileName.getName() + " - 记事本");  
                        }  
                        catch (IOException ioException) {  
                        }  
                    }  
                }  
                else if(saveChoose == JOptionPane.NO_OPTION) {   //选择'否'
                    String str = null;
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setDialogTitle("打开文件");
                    int result = fileChooser.showOpenDialog(view);
                    if (result == JFileChooser.CANCEL_OPTION) {
                        return;
                    }
                    File fileName = fileChooser.getSelectedFile();
                    if (fileName == null || fileName.getName().equals("")) {
                        JOptionPane.showMessageDialog(view, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        try {
                            FileReader fr = new FileReader(fileName);
                            BufferedReader bfr = new BufferedReader(fr);
                            view.getTextArea().setText("");
                            while ((str = bfr.readLine()) != null) {
                                view.getTextArea().append(str);
                            }
                            view.setTitle(fileName.getName() + " - 记事本");
                            fr.close();
                            isNewFile = false;
                            currentFile = fileName;
                        }
                        catch(IOException ioException) {
                        }
                    }
                }  
                else {
                    return;  
                }
            }
            else {
                String str = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setDialogTitle("打开文件");
                int result = fileChooser.showOpenDialog(view);
                if (result == JFileChooser.CANCEL_OPTION) {
                    return;
                }
                File fileName = fileChooser.getSelectedFile();
                if (fileName == null || fileName.getName().equals("")) {
                    JOptionPane.showMessageDialog(view, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        FileReader fr = new FileReader(fileName);
                        BufferedReader bfr = new BufferedReader(fr);
                        view.getTextArea().setText("");
                        while ((str = bfr.readLine()) != null) {
                            view.getTextArea().append(str);
                        }
                        view.setTitle(fileName.getName() + " - 记事本");
                        fr.close();
                        isNewFile = false;
                        currentFile = fileName;
                    }
                    catch(IOException ioException) {
                    }
                }
            }
        }//打开结束
        //保存
        else if (itemName.equals("保存")) {
            view.getTextArea().requestFocus();  
            if(isNewFile) {
                String str=null;  
                JFileChooser fileChooser = new JFileChooser();  
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                fileChooser.setDialogTitle("保存");  
                int result = fileChooser.showSaveDialog(view);  
                if(result == JFileChooser.CANCEL_OPTION) {
                    return;  
                }  
                File saveFileName = fileChooser.getSelectedFile();  
                if(saveFileName == null || saveFileName.getName().equals("")) {   
                    JOptionPane.showMessageDialog(view, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);  
                }  
                else {
                    try {
                        FileWriter fw = new FileWriter(saveFileName);  
                        BufferedWriter bfw = new BufferedWriter(fw);  
                        bfw.write(view.getTextArea().getText(), 0, view.getTextArea().getText().length());  
                        bfw.flush();//刷新该流的缓冲  
                        bfw.close();  
                        isNewFile = false;  
                        currentFile = saveFileName;
                        view.setTitle(saveFileName.getName()+" - 记事本");  
                    }  
                    catch (IOException ioException) {  
                    }  
                }  
            }  
            else {
                try {
                    currentFile = new File("");
                    FileWriter fw = new FileWriter(currentFile);  
                    BufferedWriter bfw = new BufferedWriter(fw);  
                    bfw.write(view.getTextArea().getText(), 0, view.getTextArea().getText().length());  
                    bfw.flush();  
                    fw.close();  
                }                             
                catch(IOException ioException) {                     
                }  
            }
        }//保存结束
        //另存为
        else if (itemName.equals("另存为")) {
            view.getTextArea().requestFocus();  
            String str=null;  
            JFileChooser fileChooser = new JFileChooser();  
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
            fileChooser.setDialogTitle("另存为");  
            int result = fileChooser.showSaveDialog(view);  
            if(result == JFileChooser.CANCEL_OPTION) {
                return;  
            }                 
            File saveFileName = fileChooser.getSelectedFile();  
            if(saveFileName == null||saveFileName.getName().equals("")) {
                JOptionPane.showMessageDialog(view, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);  
            }     
            else {
                try {
                    FileWriter fw = new FileWriter(saveFileName);  
                    BufferedWriter bfw = new BufferedWriter(fw);  
                    bfw.write(view.getTextArea().getText(), 0, view.getTextArea().getText().length());  
                    bfw.flush();  
                    fw.close();  
                    view.setTitle(saveFileName.getName()+"  - 记事本");  
                }                         
                catch(IOException ioException) {                     
                }                 
            }
        }//另存为结束
        //退出
        else if (itemName.equals("退出")) {
            int exitChoose = JOptionPane.showConfirmDialog(view, "确定要退出吗?", "退出提示", JOptionPane.OK_CANCEL_OPTION);  
            if(exitChoose==JOptionPane.OK_OPTION) {
                System.exit(0);  
            }  
            else {
                return;  
            }
        }//退出结束
    }
}
