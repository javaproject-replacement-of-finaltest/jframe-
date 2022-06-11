import javax.sound.midi.SysexMessage;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//請問您需要甚麼服務(註冊、登入、取消、查詢書籍、查看所有書籍)

public class Addnewbook extends JFrame implements ActionListener{
    final private Font TitleFont = new Font("Times New Roman", Font.BOLD, 35);
    final private Font mainFont = new Font("細明本", Font.BOLD, 16);
    final private Font inputFont = new Font("Segoe print",Font.BOLD, 23);
    final private Font btnFont = new Font("Segoe print",Font.BOLD, 20);
    JTextField tfNewname, tfAuthorname,tfAuthorization;

    public void initialize(){
        //標題
        JLabel lbRegisterform = new JLabel("Add new book!", SwingConstants.CENTER);
        lbRegisterform.setFont(TitleFont);
        //內容
        JLabel lbNewname = new JLabel("請輸入書本名稱");
        lbNewname.setFont(mainFont);

        JLabel lbAuthorname = new JLabel("請輸入書本作者");
        lbAuthorname.setFont(mainFont);

        JLabel lbAuthorization = new JLabel("請輸入出版社");
        lbAuthorization.setFont(mainFont);

        tfNewname = new JTextField();
        tfNewname.setFont(inputFont);

        tfAuthorname = new JTextField();
        tfAuthorname.setFont(inputFont);

        tfAuthorization = new JTextField();
        tfAuthorization.setFont(inputFont);

       
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,6));
        formPanel.setBorder(BorderFactory.createEmptyBorder(25,50,35,50));
        formPanel.add(lbRegisterform); 
        formPanel.add(lbNewname); //書籍名稱
        formPanel.add(tfNewname);
        formPanel.add(lbAuthorname); //作者
        formPanel.add(tfAuthorname);
        formPanel.add(lbAuthorization); //出版社
        formPanel.add(tfAuthorization);
        formPanel.setOpaque(false);

        /********** Button ***********/
        JButton btnOK = new JButton("OK");
        btnOK.setFont(btnFont);
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(btnFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,8,2));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
        buttonPanel.add(btnOK);
        buttonPanel.add(btnClear);
        buttonPanel.setOpaque(false);
        
        
        btnOK.addActionListener(this);
        btnClear.addActionListener(this);

        /**********Initialize the form ***********/
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        myPanel.setBackground(new Color(255,235,205));
        myPanel.add(formPanel,BorderLayout.NORTH);
        myPanel.add(buttonPanel,BorderLayout.SOUTH);
        add(myPanel);

        setTitle("New Book");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(430,520);
        setMinimumSize(new Dimension(350,450));
        setLocationRelativeTo(null);
        setVisible(true);

        btnClear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                tfNewname.setText("");
                tfAuthorization.setText("");
                tfAuthorname.setText("");   
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
            String authorname= tfAuthorname.getText();
            String publishing= tfAuthorization.getText();
            String name=tfNewname.getText();
            
            //呼叫admin內的方法
            LiberaryTest.liberary.getAdmin(LiberaryTest.liberary.nownumber).ADD_BOOK(LiberaryTest.liberary.getBookArraylist(), name, authorname, publishing);
            this.dispose();
            new AdminlogintionL().initialize();
        }
    }
    public static void main(String[] args){
        new Addnewbook().initialize();
    }
}


