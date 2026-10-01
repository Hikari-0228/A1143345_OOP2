import java.awt.*;
import javax.swing.*;
public class Excerise1{
    static JFrame frm=new JFrame("骰子模擬器");
    static JPanel pne_center=new JPanel();
    static JPanel pne_north=new JPanel();
    static JPanel pne_west=new JPanel();
    static JPanel pne_east=new JPanel();
    static JPanel pne_south=new JPanel();
    static JLabel lab_north=new JLabel("已骰次數: ");
    static JLabel lab=new JLabel();
    static JButton but=new JButton("投骰子");
    public static void main(String[] args) {
        frm.setSize(400,320);
        frm.setLayout(new BorderLayout());
        lab.setFont(new Font("Arial", Font.BOLD,60));
        lab_north.setFont(new Font("標楷體",Font.BOLD,20));
        int point=(int)(Math.random()*(6-1+1))+1;
        lab.setText(""+point);
        pne_center.add(lab);
        pne_north.add(lab_north);

        frm.add(pne_center,BorderLayout.CENTER);
        frm.add(pne_north,BorderLayout.NORTH);
        frm.add(pne_west,BorderLayout.WEST);
        frm.add(pne_east,BorderLayout.EAST);
        pne_south.add(but);
        frm.add(pne_south,BorderLayout.SOUTH);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}