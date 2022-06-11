import javax.sound.midi.SysexMessage;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//請問您需要甚麼服務(註冊、登入、取消、查詢書籍、查看所有書籍)

public class Loginfill extends JFrame implements ActionListener{
    final private Font TitleFont = new Font("Times New Roman", Font.BOLD, 35);
    final private Font mainFont = new Font("細明本", Font.BOLD, 16);
    final private Font inputFont = new Font("Segoe print",Font.BOLD, 25);
    final private Font btnFont = new Font("Segoe print",Font.BOLD, 20);
    JTextField tfAccountNum, tfUserName;
    JPasswordField pfPassword;
    public void initialize(){
        //標題
        JLabel lbRegisterform = new JLabel("Login", SwingConstants.CENTER);
        lbRegisterform.setFont(TitleFont);
        //內容
        JLabel lbAccountNum = new JLabel("您的帳號(為數字)");
        lbAccountNum.setFont(mainFont);

        JLabel lbPassword = new JLabel("密碼(為數字)");
        lbPassword.setFont(mainFont);

        tfAccountNum = new JTextField();
        tfAccountNum.setFont(inputFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(inputFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,6));
        formPanel.setBorder(BorderFactory.createEmptyBorder(25,50,25,50));
        formPanel.add(lbRegisterform);
        formPanel.add(lbAccountNum);
        formPanel.add(tfAccountNum);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
        formPanel.setOpaque(false);

        /********** Button ***********/
        JButton btnLogin = new JButton("OK");
        btnLogin.setFont(btnFont);
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(btnFont);
        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,8,3));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,50,30,50));
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnClear);
        buttonPanel.setOpaque(false);
        
        
        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);

        /**********Initialize the form ***********/
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        myPanel.setBackground(new Color(255,235,205));
        myPanel.add(formPanel,BorderLayout.NORTH);
        myPanel.add(buttonPanel,BorderLayout.SOUTH);
        add(myPanel);

        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,480);
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
        //test
        System.out.println(s);
        //test
        if(s=="OK"){
            this.setVisible(false);
            int account = Integer.parseInt(tfAccountNum.getText());
            int password = Integer.parseInt(String.valueOf(pfPassword.getPassword()));
            LiberaryTest.loginbutton(account,password);
            //在新頁面做出來之前的暫時版本//
            //test
            System.out.println(LiberaryTest.returnnumber);
            //test
            if(LiberaryTest.returnnumber==1){
                this.dispose();
                new SelectServiceFrame1().initialize();
            }else{
                this.dispose();
                System.out.println("我進來了!!");
                //new AdminlogintionL().initialize();
            }
        }
    }
    public static void main(String[] args){
        new Loginfill().initialize();
    }
}
