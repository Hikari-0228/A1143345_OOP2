import java.awt.*;
//基礎 GUI 元件樣式與版面配置，borderlayout、font and color
import java.awt.event.*;
//事件處理機制
import javax.swing.*;
//Jrame等
public class exercise2 implements ActionListener{
    private JFrame frm;
    private JButton btn;
    private JComboBox<String> jcb_type;
    private JComboBox<String> jcb_unit1;
    private JComboBox<String> jcb_unit2;
    private JTextField jtx1;
    private JPanel central_panel;
    // jtx1是給使用者輸入的
    private JTextField jtx2;
    String[] type={"","長度","重量","溫度"};
    public exercise2(){
        frm= new JFrame();
        frm.setLayout(new BorderLayout());
        frm.setSize(480,280);
        central_panel=new JPanel(new GridLayout(2, 2, 5, 5));
        btn=new JButton();
        jcb_type=new JComboBox<>(type);
        jcb_type.addActionListener(this);
        jcb_unit1=new JComboBox<>();
        jcb_unit2=new JComboBox<>();
        jtx1=new JTextField();
        jtx1.setEditable(true);
        jtx2=new JTextField();
        btn=new JButton("換算");
        btn.addActionListener(this);
        //註冊監聽者
        frm.add(jcb_type,"North");
        frm.add(central_panel,"Center");
        central_panel.add(jtx1);
        central_panel.add(jcb_unit1);
        central_panel.add(jtx2);
        central_panel.add(jcb_unit2);
        frm.add(btn,"South");
        //設定結束
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void set_Menu(){
        //設定選單單位
        String selectunit=(String) jcb_type.getSelectedItem();
        String[] unit;
        if("長度".equals(selectunit)){
            unit=new String[]{"公尺","公分","英吋","英尺"};
        }else if("重量".equals(selectunit)){
            unit=new String[]{"公斤","公克","磅","盎司"};
        }else if("溫度".equals(selectunit)){
            unit=new String[]{"攝氏","華氏","克氏"};
        }else{
            unit=new String[]{};
        }
        jcb_unit1.setModel(new DefaultComboBoxModel<>(unit));
        jcb_unit2.setModel(new DefaultComboBoxModel<>(unit));
    }
    public double length_convert(){
        String unit1=(String) jcb_unit1.getSelectedItem();
        String unit2=(String) jcb_unit2.getSelectedItem();
        double temp=0;
        double ans=0;
        try {
            double input = Double.parseDouble(jtx1.getText());
            //String不可直接轉型成Double，因此要用parseDouble(jtx1.getText());
            switch(unit1){
            case "公尺":
                temp=input*1;
                break;
            case "公分":
                temp=input*0.01;
                break;
            case "英吋":
                temp=input*0.0254;
                break;
            case "英尺":
                temp=input*0.3048;
                break;
            }
            switch(unit2){
            case "公尺":
                ans=temp/1;
                break;
            case "公分":
                ans=temp/0.01;
                break;
            case "英吋":
                ans=temp/0.0254;
                break;
            case "英尺":
                ans=temp/0.3048;
                break;
            }
        } catch (NumberFormatException e) {
            // 如果使用者輸入了不是數字的內容（例如留白或打錯字），會跳到這裡
            System.out.println("請輸入正確的數字格式！");
        }
        return ans;
    }

    public double weight_convert(){
        String unit1=(String) jcb_unit1.getSelectedItem();
        String unit2=(String) jcb_unit2.getSelectedItem();
        double temp=0;
        double ans=0;
        try {
            double input = Double.parseDouble(jtx1.getText());
            //String不可直接轉型成Double，因此要用parseDouble(jtx1.getText());
            switch(unit1){
            case "公斤":
                temp=input*1;
                break;
            case "公克":
                temp=input*0.001;
                break;
            case "磅":
                temp=input*0.4539;
                break;
            case "盎司":
                temp=input*0.0283;
                break;
            }
            switch(unit2){
            case "公斤":
                ans=temp/1;
                break;
            case "公克":
                ans=temp/0.001;
                break;
            case "磅":
                ans=temp/0.4539;
                break;
            case "盎司":
                ans=temp/0.0283;
                break;
            }
        } catch (NumberFormatException e) {
            // 如果使用者輸入了不是數字的內容（例如留白或打錯字），會跳到這裡
            System.out.println("請輸入正確的數字格式！");
        }
        return ans;
    }
    public double temperature_convert(){
        String unit1 = (String) jcb_unit1.getSelectedItem();
        String unit2 = (String) jcb_unit2.getSelectedItem();
        double temp = 0; // 暫存轉為「攝氏」的數值
        double ans = 0;
    
        try {
            double input = Double.parseDouble(jtx1.getText());
        
        // 1. 先統一轉為基準單位：攝氏 (°C)
            switch(unit1){
                case "攝氏":
                    temp = input;
                    break;
                case "華氏":
                    temp = (input - 32) * 5.0 / 9.0;
                    break;
                case "克氏":
                    temp = input - 273.15;
                    break;
                }
        
        // 2. 再從攝氏轉為目標單位
            switch(unit2){
                case "攝氏":
                    ans = temp;
                    break;
                case "華氏":
                    ans = temp * 9.0 / 5.0 + 32;
                    break;
                case "克氏":
                    ans = temp + 273.15;
                    break;
            }
         } catch (NumberFormatException e) {
            System.out.println("請輸入正確的數字格式！");
        }
        return ans;
     }

    public void main(String[] args){
        //負責喚醒
        new exercise2();
    }
    public void actionPerformed(ActionEvent e){
        //事件處理
        if(e.getSource()==jcb_type){
            set_Menu();
        }else if(e.getSource()==btn){
        String selectmode=(String) jcb_type.getSelectedItem();
        double ans=0;
        switch(selectmode){
            case "長度":
                ans=length_convert();
                break;
            case "重量":
                ans=weight_convert();
                break;
            case "溫度":
                ans=temperature_convert();
                break;
        }
        String result=ans+"";
        jtx2.setText(result);
    }
    }
}
