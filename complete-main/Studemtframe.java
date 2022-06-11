import javax.sound.midi.SysexMessage;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Studemtframe extends JFrame implements ActionListener{
    final private Font TitleFont = new Font("Times New Roman", Font.ITALIC, 38);
    final private Font buttonFont = new Font("標楷體",Font.BOLD,20 );
    final private Font mainFont = new Font("標楷體", Font.BOLD, 30);
    static JFrame frame;
    public void initialize(){
        /****************** Form Panel(North) *******************/
        JLabel Title = new JLabel();
        Title.setFont(TitleFont);
        Title.setText("Hello~welcome ");

        /****************** Center Label *******************/
        JLabel lbService = new JLabel("請問您需要甚麼服務");
        lbService.setFont(mainFont);

        /****************** Buttons Panel *******************/
        JButton btnRegister = new JButton("借書");
        JButton btnLogin = new JButton("還書");
        JButton btnLibrarybook = new JButton("借閱紀錄");
        JButton btnSearchbook = new JButton("個人資料");
        JButton btnCancel = new JButton("離開");
        JButton btnLeave=new JButton("修改密碼");

        //Icon bookgif = new ImageIcon(this.getClass().getResource("bookpic.gif"));
        //JLabel giflabel = new JLabel(bookgif);
        
        btnRegister.setFont(buttonFont);
        btnLogin.setFont(buttonFont);
        btnCancel.setFont(buttonFont);
        btnSearchbook.setFont(buttonFont);
        btnLibrarybook.setFont(buttonFont);
        btnLeave.setFont(buttonFont);
        btnRegister.setSize(25,10);
        btnLogin.setSize(25,10);
        btnCancel.setSize(25,10);
        btnSearchbook.setSize(25,10);
        btnLibrarybook.setSize(25,10);
        btnLeave.setSize(25, 10);
        btnRegister.addActionListener(this);
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        btnSearchbook.addActionListener(this);
        btnLibrarybook.addActionListener(this);
        btnLeave.addActionListener(this);
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
        buttonPanel.add(btnLeave);

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
        String s = e.getActionCommand();
        System.out.println(s);
        int continu;
        this.setVisible(false);
        if(s.equals("借書")){
            this.setVisible(false);
            do{
                continu=LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber).BorrowBook(LiberaryTest.liberary);
                System.out.println("continue:"+continu);
            }while(continu==1);
            this.setVisible(true);
        }else if(s.equals("還書")){
            this.setVisible(false);
            LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber).returnbook(LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber));
            this.setVisible(true);
        }else if(s.equals("借閱紀錄")){
            this.setVisible(false);
            String output="";
            for(int i=0;i<LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber).BorrowBook.size();i++){
                System.out.println("我尚未借書");
                output+=LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber).BorrowBook.get(i);
                output+="\n";
            }
            if(output==""){
                output="您尚未借閱任何書籍";
            }
            new Resultframestudent(output);
            this.dispose();
        }else if(s.equals("個人資料")){
            this.dispose();
            new Resultframestudent(LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber).toString());
        }else if(s.equals("離開")){
            this.setVisible(false);
            this.dispose();
            new SelectServiceFrame1().initialize();
        }else if(s.equals("修改密碼")){
            int change=Integer.parseInt(JOptionPane.showInputDialog(null,"您想將密碼修改為多少"));
            LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber).setpassword(change);
            JOptionPane.showMessageDialog(null,"修改成功的密碼為"+LiberaryTest.liberary.getstudent(LiberaryTest.loginnumber).getpassword(),"恭喜",1);
            this.setVisible(true);
        }
    }
}
