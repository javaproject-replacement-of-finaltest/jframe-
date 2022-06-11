import javax.swing.JFrame;
import javax.swing.text.AbstractDocument.BranchElement;
import javax.swing.text.StyledEditorKit.FontSizeAction;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterFrame extends JFrame implements ActionListener{
    final private Font TitleFont = new Font("Times New Roman", Font.BOLD, 35);
    final private Font mainFont = new Font("細明本", Font.BOLD, 16);
    final private Font inputFont = new Font("Segoe print",Font.BOLD, 23);
    final private Font btnFont = new Font("Segoe print",Font.BOLD, 20);
    JTextField tfAccountNum, tfUserName;
    JPasswordField pfPassword;
    public void initialize(){
        //標題
        JLabel lbRegisterform = new JLabel("Register ", SwingConstants.CENTER);
        lbRegisterform.setFont(TitleFont);
        //內容
        JLabel lbAccountNum = new JLabel("您的帳號(請輸數字)");
        lbAccountNum.setFont(mainFont);
        JLabel lbUserName = new JLabel("您的姓名");
        lbUserName.setFont(mainFont);
        JLabel lbPassword = new JLabel("密碼(請輸數字)");
        lbPassword.setFont(mainFont);

        tfAccountNum = new JTextField();
        tfAccountNum.setFont(inputFont);
        tfUserName = new JTextField();
        tfUserName.setFont(inputFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(inputFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,6));
        formPanel.setBorder(BorderFactory.createEmptyBorder(25,50,30,50));
        formPanel.add(lbRegisterform);
        formPanel.add(lbAccountNum);
        formPanel.add(tfAccountNum);
        formPanel.add(lbUserName);
        formPanel.add(tfUserName);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
        formPanel.setOpaque(false);

        /********** Button ***********/
        JButton btnRegister = new JButton("OK");
        btnRegister.setFont(btnFont);
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(btnFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,8,2));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnClear);
        buttonPanel.setOpaque(false);
        
        
        btnRegister.addActionListener(this);
        btnClear.addActionListener(this);

        /**********Initialize the form ***********/
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        myPanel.setBackground(new Color(255,235,205));
        myPanel.add(formPanel,BorderLayout.NORTH);
        myPanel.add(buttonPanel,BorderLayout.SOUTH);
        add(myPanel);

        setTitle("Register Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(430,520);
        setMinimumSize(new Dimension(350,450));
        setLocationRelativeTo(null);
        setVisible(true);
        btnClear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                tfAccountNum.setText("");
                pfPassword.setText("");   
            }
        
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        System.out.println(s);
        if(s=="OK"){
            this.setVisible(false);
            int account = Integer.parseInt(tfAccountNum.getText());
            String name = tfUserName.getText();
            int password = Integer.parseInt(String.valueOf(pfPassword.getPassword()));

            int result=LiberaryTest.registratoinbutton(LiberaryTest.choice2,account,password,name);
            //test
            System.out.println("result為"+result);
            switch(result){
                //回傳0--
                case 2:
                    new RegisterFrame().initialize();
                    break;
                //回傳1
                case 1:
                    this.dispose();
                    new SelectServiceFrame1().initialize();
                    break;
                //回傳2
            }
        }  
        
    }
    public static void main(String [] args){
    new RegisterFrame().initialize();
    }
}
