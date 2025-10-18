import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Find {
    public JTextArea textArea;  //定义一个文本域

    public Find(JTextArea textArea)  //构造函数，实例化，接收一个文本域形式的参数
    {
        this.textArea = textArea;  //将传入的参数textArea  赋值给  当前对象的实例的this.textArea变量
    }

    public void findManner()  //定义一个叫findManner的方法
    {
        JPanel panel = new JPanel(new GridLayout(2,1));  //创建一个是GridLayout布局的面板JPane1，布局是2行1列
        JLabel label = new JLabel("请输入要查找的内容：");  //创建一个标签label
        JTextField textField = new JTextField();  //创建一个文本框textField

        panel.add(label);  //将标签label添加到面板panel中
        panel.add(textField);  //将文本框textField添加到面板pane1中

        int X = JOptionPane.showConfirmDialog(null, panel, "查找", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);  //显示一个确认对话框，showConfirmDialog方法在java包的JOptionPane中
        if (X == JOptionPane.OK_OPTION)  //如果点击了确定按钮
        {
                   //注意区分 文本框 和 查找框
            String text = textField.getText();  //获取文本框中的内容

            if (!text.isEmpty())  //如果搜索内容不为空
            {
                String content = textArea.getText();  //获取查找框中的内容
                int chuCun = content.indexOf(text);  //搜索查找框中的内容在文本框中的位置。 就是文本框中有查找框相同的内容，就放到chuCun中

                if (chuCun >= 0)  //如果查找到了有匹配内容
                {
                                
                    textArea.setCaretPosition(chuCun);  //在文本框中 光标位置被定位到 找到内容的地方。例如在文本组件的JTextArea中有setCarePosition方法，用于设置光标的位置

                    textArea.setSelectionStart(chuCun);  //在文本框中 设置被光标选中的 起始位置，这部分文本会被高亮显示。这个方法可以在文本组件例如textArea中    从chuCun开始被标记

                    textArea.setSelectionEnd(chuCun + text.length());  //在文本框中 设置被光标选中的 结束位置，这部分文本会被高亮显示。                       到chuCun+ huoqu的长度 标记结束
                    
                    textArea.requestFocusInWindow();  //requestFocusInWindow这个方法用于 不需要用鼠标点击文本框就可以在该文本框中输入数值。

                }

                else 
                {

                    JOptionPane.showMessageDialog(null, "没有找到匹配的内容", "查找的结果", JOptionPane.INFORMATION_MESSAGE);  //如果没有找到匹配内容，就显示一个消息对话框

                }
            }
        }
    }

}
