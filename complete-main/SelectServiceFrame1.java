import javax.sound.midi.SysexMessage;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//請問您需要甚麼服務(註冊、登入、取消、查詢書籍、查看所有書籍)

public class SelectServiceFrame1 extends JFrame implements ActionListener{
    final private Font TitleFont = new Font("Times New Roman", Font.ITALIC, 38);
    final private Font buttonFont = new Font("標楷體",Font.BOLD,20 );
    final private Font mainFont = new Font("標楷體", Font.BOLD, 30);
    static JFrame frame;
    public void initialize(){
        /****************** Form Panel(North) *******************/
        JLabel Title = new JLabel();
        Title.setFont(TitleFont);
        Title.setText("Welcome..");

        /****************** Center Label *******************/
        JLabel lbService = new JLabel("請選擇服務項目");
        lbService.setFont(mainFont);

        /****************** Buttons Panel *******************/
        JButton btnRegister = new JButton("註冊");
        JButton btnLogin = new JButton("登入");
        JButton btnLibrarybook = new JButton("查詢書籍");
        JButton btnSearchbook = new JButton("館藏書籍");
        JButton btnCancel = new JButton("取消");
        JButton btnrank = new JButton("圖書風雲榜");

        //Icon bookgif = new ImageIcon(this.getClass().getResource("bookpic.gif"));
        //JLabel giflabel = new JLabel(bookgif);
        
        btnRegister.setFont(buttonFont);
        btnLogin.setFont(buttonFont);
        btnCancel.setFont(buttonFont);
        btnSearchbook.setFont(buttonFont);
        btnLibrarybook.setFont(buttonFont);
        btnrank.setFont(buttonFont);
        btnRegister.setSize(25,10);
        btnLogin.setSize(25,10);
        btnCancel.setSize(25,10);
        btnSearchbook.setSize(25,10);
        btnLibrarybook.setSize(25,10);
        btnrank.setSize(25,10);
        btnRegister.addActionListener(this);
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        btnSearchbook.addActionListener(this);
        btnLibrarybook.addActionListener(this);
        btnrank.addActionListener(this);
        //btnRegister.setForeground(new Color(69,68,68));
        //btnRegister.setBackground(new Color(240,255,255));

 
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,5,7,5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSearchbook);
        buttonPanel.add(btnLibrarybook);
        buttonPanel.add(btnrank);

        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(); //面板
        //JFrame myframe = new JFrame();
        mainPanel.setLayout(new BorderLayout()); //create layout manager
        //mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(35,35,30,35));
        mainPanel.setBackground(new Color(255,235,205));
        //mainPanel.setForeground(new Color(125,229,251));
        mainPanel.add(Title, BorderLayout.NORTH);
        mainPanel.add(lbService, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setTitle("Java Library 給予你最優質的服務!"); //標題
        setSize(550,350); //窗口尺寸
        setMinimumSize(new Dimension(200,300));
        setLocationRelativeTo(null);//顯示在螢幕中間
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true); //make the frame visible
        //測試透明度//

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        //前置作業
        String s = e.getActionCommand();
        System.out.println(s);
        int result;
        //沒用
        this.setVisible(false);
        if(s.equals("註冊")){
            String[] second={"管理員","老師","員工","學生","返回"};
            int now,choice2;
            choice2=JOptionPane.showOptionDialog(null,"請問你的身分?", "歡迎註冊", 0, 3, null,second,null);
            LiberaryTest.choice2=choice2;
            if(choice2==4){
                this.dispose();
                new SelectServiceFrame1().initialize();
            }
            else{
                this.dispose();
                new RegisterFrame().initialize();
            }
        }else if(s.equals("登入")){
            String[] second={"管理員","老師","員工","學生","返回"};
            LiberaryTest.choice2=JOptionPane.showOptionDialog(null,"請問你的身分?", "歡迎登陸", 0, 3, null,second,null);
            if(LiberaryTest.choice2==4){
                this.dispose();
                new SelectServiceFrame1().initialize();
            }
            else{
                this.dispose();
                new Loginfill().initialize();
            };
        }else if(s.equals("取消")){
            LiberaryTest.savefile(LiberaryTest.liberary);
            System.exit(0);
        }else if(s.equals("查詢書籍")){
            LiberaryTest.serchbookbutton();
            //this.setVisible(true);
        }else if(s.equals("館藏書籍")){
            new ScrollbarFrame(LiberaryTest.liberary.listall(LiberaryTest.liberary.getBookArraylist()));
            //this.setVisible(true);
        }else if(s.equals("圖書風雲榜")){
            new ShowRankframe(LiberaryTest.liberary.rankoutput());
            //LiberaryTest.shoowrank();
            this.setVisible(false);
        }
    }
}
