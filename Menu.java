import java.awt.*;
import javax.swing.*;

public class Menu {
    //初始化窗口
    public static JMenuBar init() {
        //菜单条
        JMenuBar menuBar;
        //菜单
        JMenu fileMenu, editMenu, formatMenu, viewMenu, helpMenu;
        //文件菜单项   
        JMenuItem file_NewItem, file_OpenItem, file_SaveItem, file_SaveAsItem, file_ExitItem;   
        //编辑菜单项
        JMenuItem edit_CutItem, edit_CopyItem, edit_PasteItem, edit_DeleteItem, edit_FindItem;  
        //格式菜单项
        JCheckBoxMenuItem format_WordWrapItem;
        //查看菜单项
        JCheckBoxMenuItem view_StatusBarItem;
        //帮助菜单项
        JMenuItem help_ManualItem;

        //创建菜单条
        menuBar =  new JMenuBar();

        //创建各菜单
        fileMenu = new JMenu("文件");
        editMenu = new JMenu("编辑");
        formatMenu = new JMenu("格式");
        viewMenu = new JMenu("查看");
        helpMenu = new JMenu("帮助");

        //创建文件菜单中的各文件菜单项
        file_NewItem = new JMenuItem("新建");
        file_OpenItem = new JMenuItem("打开");
        file_SaveItem = new JMenuItem("保存");
        file_SaveAsItem = new JMenuItem("另存为");
        file_ExitItem = new JMenuItem("退出");

        //创建编辑菜单中的各文件菜单项
        edit_CutItem = new JMenuItem("剪切");
        edit_CopyItem = new JMenuItem("复制");
        edit_PasteItem = new JMenuItem("粘贴");
        edit_DeleteItem = new JMenuItem("删除");
        edit_FindItem = new JMenuItem("查找");

        //创建格式菜单中的各文件菜单项
        format_WordWrapItem = new JCheckBoxMenuItem("自动换行");
        format_WordWrapItem.setState(true); //默认开启

        //创建查看菜单中的各文件菜单项
        view_StatusBarItem = new JCheckBoxMenuItem("状态栏");
        view_StatusBarItem.setState(true);//默认开启

        //创建帮助菜单中的各文件菜单项
        help_ManualItem = new JMenuItem("说明书");
        
        //菜单条中添加各菜单
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        //向文件菜单中添加各文件菜单项
        fileMenu.add(file_NewItem);
        fileMenu.add(file_OpenItem);
        fileMenu.add(file_SaveItem);
        fileMenu.add(file_SaveAsItem);
        fileMenu.addSeparator();    //添加分割线
        fileMenu.add(file_ExitItem);

        //向编辑菜单中添加各编辑菜单项
        editMenu.add(edit_CutItem);
        editMenu.add(edit_CopyItem);
        editMenu.add(edit_PasteItem);
        editMenu.add(edit_DeleteItem);
        editMenu.addSeparator();    //添加分割线
        editMenu.add(edit_FindItem);

        //向格式菜单中添加格式菜单项
        formatMenu.add(format_WordWrapItem);

        //向查看菜单中添加查看菜单项
        viewMenu.add(view_StatusBarItem);

        //向帮助菜单中添加帮助菜单项
        helpMenu.add(help_ManualItem);

        return menuBar;
    }
}
