import java.awt.*;
import javax.swing.*;

public class TextArea {
    public static JTextArea createTextArea() {
        JTextArea textArea = new JTextArea("");
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        textArea.setLineWrap(true);    //默认开启自动换行
        textArea.setWrapStyleWord(true);    //默认单词在一行不足容纳时换行
        return textArea;
    }
}
