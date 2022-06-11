import javax.sound.midi.SysexMessage;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminlogintionL extends JFrame implements ActionListener{
    final private Font TitleFont = new Font("Times New Roman", Font.ITALIC, 38);
    final private Font buttonFont = new Font("標楷體",Font.BOLD,20 );
    final private Font mainFont = new Font("標楷體", Font.BOLD, 30);
    static JFrame frame;
    public void initialize(){
        /****************** Form Panel(North) *******************/
        JLabel Title = new JLabel();
        Title.setFont(TitleFont);
        Title.setText("hello~welcome");

        /****************** Center Label *******************/
        JLabel lbService = new JLabel("請問您需要甚麼服務");
        lbService.setFont(mainFont);

        /****************** Buttons Panel *******************/
        JButton btnRegister = new JButton("新增書籍");
        JButton btnLogin = new JButton("刪除書籍");
        JButton btnLibrarybook = new JButton("更新書籍");
        JButton btnSearchbook = new JButton("查看所有使用者資料");
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
        this.setVisible(false);
        if(s.equals("新增書籍")){
            this.setVisible(false);
            System.out.println("我進到新增書籍當中");
            //LiberaryTest.liberary.getAdmin(LiberaryTest.loginnumber).ADD_BOOK(LiberaryTest.liberary.getBookArraylist());
            new Addnewbook().initialize();
            //this.setVisible(true);
        }else if(s.equals("刪除書籍")){
            this.setVisible(false);
            LiberaryTest.liberary.getAdmin(LiberaryTest.loginnumber).REMOVE_BOOK(LiberaryTest.liberary);
            this.setVisible(true);
        }else if(s.equals("更新書籍")){
            this.setVisible(false);
            LiberaryTest.liberary.getAdmin(LiberaryTest.loginnumber).REVISE_BOOK(LiberaryTest.liberary);
            this.setVisible(true);
        }else if(s.equals("查看所有使用者資料")){
            String[] selectchoice={"書籍資料","全館管理員名單","全館學生名單","全館老師名單","全館員工名單","離開"};
            this.setVisible(false);
            //我先寫在這裡，之後再放到admin
            int adminchoice;
            int data;
            do{
                adminchoice=JOptionPane.showOptionDialog(null,"請問你要搜尋誰的資料","詢問",0,3,null,selectchoice,0);
                switch(adminchoice){
                    case 0:
                        JOptionPane.showMessageDialog(null,LiberaryTest.liberary.listall(LiberaryTest.liberary.getBookArraylist()),"所有書籍列表",3);
                        data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                        if(data==0){
                            LiberaryTest.liberary.producetxt(LiberaryTest.liberary.getBookArraylist());
                        }
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,LiberaryTest.liberary.listall(LiberaryTest.liberary.getAdminArraylist()),"查看所有管理員", 3);
                        data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                        if(data==0){
                            LiberaryTest.liberary.producetxt(LiberaryTest.liberary.getAdminArraylist());
                        }
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,LiberaryTest.liberary.listall(LiberaryTest.liberary.getStudentArraylist()),"查看所有學生", 3);
                        data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                        if(data==0){
                            LiberaryTest.liberary.producetxt(LiberaryTest.liberary.getStudentArraylist());
                        }
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,LiberaryTest.liberary.listall(LiberaryTest.liberary.getTeacherArraylist()),"查看所有老師", 3);
                        data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                        if(data==0){
                            LiberaryTest.liberary.producetxt(LiberaryTest.liberary.getTeacherArraylist());
                        }
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,LiberaryTest.liberary.listall(LiberaryTest.liberary.getStaffArraylist()),"查看所有員工", 3);
                        data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                        if(data==0){
                            LiberaryTest.liberary.producetxt(LiberaryTest.liberary.getStaffArraylist());
                        }
                        break;
                }
            }while(adminchoice!=5);
            this.setVisible(true);
        }else if(s.equals("離開")){
            this.setVisible(false);
            this.dispose();
            new SelectServiceFrame1().initialize();
        }else if(s.equals("修改密碼")){
            int change=Integer.parseInt(JOptionPane.showInputDialog(null,"您想將密碼修改為多少"));
            LiberaryTest.liberary.getAdmin(LiberaryTest.loginnumber).setpassword(change);
            JOptionPane.showMessageDialog(null,"修改成功的密碼為"+LiberaryTest.liberary.getAdmin(LiberaryTest.loginnumber).getpassword(),"恭喜",3);
            this.setVisible(true);
        }
    }
    public static void main(String[] args){
        new AdminlogintionL().initialize();
    }
}
