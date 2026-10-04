import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class A1143345_excerise1 implements ActionListener {
    private JFrame frm;
    private JPanel pnl;
    private JButton btn;
    private JLabel lab_center;
    private JLabel lab_north;
    static int count=0;
    static double sum=0.0;

    public A1143345_excerise1(){
        frm=new JFrame("骰子模擬器");
        frm.setSize(400,300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new BorderLayout());
        pnl=new JPanel();
        pnl.setLayout(new BorderLayout());
        lab_center=new JLabel();
        lab_north=new JLabel();
        lab_center.setFont(new Font("微軟正黑體",Font.BOLD,60));
        lab_center.setHorizontalAlignment(SwingConstants.CENTER);
        lab_north.setFont(new Font("微軟正黑體",Font.BOLD,20));
        btn=new JButton("投骰子");
        btn.addActionListener(this);
        //用this，代表現在這個建構子建立的物件
        //如果在這重新new一個新物件會變無限迴圈
        frm.add(pnl);
        pnl.add(lab_center,"Center");
        pnl.add(lab_north,"North");
        pnl.add(btn,"South");

        frm.setVisible(true);
    }

    public int roll(){
        Random dice=new Random();
        int num=dice.nextInt(6)+1;
        count++;
        sum+=num;
        return num;
        //隨機點數
    }
    public double average(){
        double ans=sum/count;
        return ans;
        //計算平均
    }


    public static void main(String[] args){
        new A1143345_excerise1();
        //主程式只負責喚醒
    }
    public void actionPerformed(ActionEvent e){
        int point=roll();
        if(point==1){
            lab_center.setForeground(Color.RED);
        }else if(point==6){
            lab_center.setForeground(Color.GREEN);
        }else{
            lab_center.setForeground(Color.BLACK);
        }
        lab_center.setText(""+point);
        lab_north.setText(String.format("已骰次數: %d 點數總和: %d 點數平均: %.2f",count,(int)sum,average()));
        //只要建構子寫好add()，這裡更新文字，版面上就會跟著更新
        //因為想要取小數點到第n位，採用String.format()
    }
}
