import javax.swing.*;
import java.awt.*;

public class GoodLogin extends JFrame {
    public GoodLogin() {
        setTitle("登入");
        setSize(300, 180);
        
        // 1. 設定關閉視窗時自動結束程式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 2. 使用 3行2列 的網格佈局，元件會自動擺放與排列
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel l1 = new JLabel("帳號:", SwingConstants.RIGHT);
        JTextField t1 = new JTextField();
        
        JLabel l2 = new JLabel("密碼:", SwingConstants.RIGHT);
        JPasswordField t2 = new JPasswordField(); // 密碼欄位改用 JPasswordField
        
        JButton btn = new JButton("登入");

        // 3. 依序將元件加入視窗
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(new JLabel("")); // 佔位空元件，讓按鈕對齊在右側
        add(btn);

        // 4. 事件監聽：使用 .equals() 比較字串內容
        btn.addActionListener(e -> {
            String username = t1.getText();
            String password = new String(t2.getPassword()); // JPasswordField 取得密碼的方式

            if ("admin".equals(username) && "1234".equals(password)) {
                System.out.println("登入成功");
                JOptionPane.showMessageDialog(this, "登入成功！");
            } else {
                JOptionPane.showMessageDialog(this, "帳號或密碼錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 5. 將視窗置中並顯示（必須放在最後）
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Swing 介面建議在 Event Dispatch Thread (EDT) 中建立
        SwingUtilities.invokeLater(() -> new GoodLogin());
    }
}
