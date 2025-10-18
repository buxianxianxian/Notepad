import java.awt.*;
import java.awt.datatransfer.Clipboard;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Window extends JFrame {
    //菜单条
    JMenuBar menuBar;
    //文本编辑区
    JTextArea textArea;
    //状态栏
    JPanel statusBar;
    JLabel statusLabel;
    //系统剪切板
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Clipboard clipboard = toolkit.getSystemClipboard();

    public Window() {
        //创建菜单条
        menuBar = Menu.init();
        setJMenuBar(menuBar);

        //创建文本域
        textArea = TextArea.createTextArea();
        add(textArea,BorderLayout.CENTER);
        add(new JScrollPane(textArea));
        //为文本域添加事件监听器
        TextAreaListener textAreaListener = new TextAreaListener();
        textArea.getDocument().addDocumentListener(textAreaListener);
        textAreaListener.setView(this);

        //创建菜单栏
        statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusLabel = new JLabel("Line: 0, Column: 0");
        statusBar.add(statusLabel);
        add(statusBar, BorderLayout.SOUTH);

        //各菜单菜单项监听器
        FileMenuListener fileMenuListener = new FileMenuListener();
        EditMenuListener editMenuListener = new EditMenuListener();
        FormatMenuListener formatMenuListener = new FormatMenuListener(); 
        ViewMenuListener viewMenuListener = new ViewMenuListener();
        HelpMenuListener helpMenuListener = new HelpMenuListener();
        //将当前窗口的引用传给监视器
        fileMenuListener.setView(this);
        editMenuListener.setView(this);
        formatMenuListener.setView(this);
        viewMenuListener.setView(this);
        helpMenuListener.setView(this);
        //获取各菜单
        JMenu fileMenu = menuBar.getMenu(0);
        JMenu editMenu = menuBar.getMenu(1);
        JMenu formatMenu = menuBar.getMenu(2);
        JMenu viewMenu = menuBar.getMenu(3);
        JMenu helpMenu = menuBar.getMenu(4);
        //获取'文件'中各菜单项
        JMenuItem file_NewItem = fileMenu.getItem(0);
        JMenuItem file_OpenItem = fileMenu.getItem(1);
        JMenuItem file_SaveItem = fileMenu.getItem(2);
        JMenuItem file_SaveAsItem = fileMenu.getItem(3);
        JMenuItem file_ExitItem = fileMenu.getItem(5);
        //为'文件'中各菜单项添加监听器
        file_NewItem.addActionListener(fileMenuListener);
        file_OpenItem.addActionListener(fileMenuListener);
        file_SaveItem.addActionListener(fileMenuListener);
        file_SaveAsItem.addActionListener(fileMenuListener);
        file_ExitItem.addActionListener(fileMenuListener);
        //获取'编辑'中各菜单项
        JMenuItem edit_CutItem = editMenu.getItem(0);
        JMenuItem edit_CopyItem = editMenu.getItem(1);
        JMenuItem edit_PasteItem = editMenu.getItem(2);
        JMenuItem edit_DeleteItem = editMenu.getItem(3);
        JMenuItem edit_FindItem = editMenu.getItem(5);
        //为'编辑'中各菜单项添加监听器
        edit_CutItem.addActionListener(editMenuListener);
        edit_CopyItem.addActionListener(editMenuListener);
        edit_PasteItem.addActionListener(editMenuListener);
        edit_DeleteItem.addActionListener(editMenuListener);
        edit_FindItem.addActionListener(editMenuListener);

        //获取'格式'中各菜单项
        JCheckBoxMenuItem format_WordWrapItem = (JCheckBoxMenuItem)formatMenu.getItem(0);
        //为'格式'中各菜单项添加监听器
        format_WordWrapItem.addActionListener(formatMenuListener);
        //获取'查看'中各菜单项
        JCheckBoxMenuItem view_StatusBarItem = (JCheckBoxMenuItem)viewMenu.getItem(0);
        //为'查看'中各菜单项添加监听器
        view_StatusBarItem.addActionListener(viewMenuListener);
        //获取'帮助'中各菜单项
        JMenuItem help_ManualItem = helpMenu.getItem(0);
        //为'帮助'中各菜单项添加监听器
        help_ManualItem.addActionListener(helpMenuListener);

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public String getCurrentText() {
        return textArea.getText();
    }
    public JTextArea getTextArea() {
        return textArea;
    }
    public JLabel getStatusLabel() {
        return statusLabel;
    }
    public Clipboard getClipboard() {
        return clipboard;
    }
}
