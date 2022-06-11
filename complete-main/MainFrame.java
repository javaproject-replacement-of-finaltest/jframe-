import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame{ //窗口
    final private Font TitleFont = new Font("Times New Roman", Font.ITALIC, 23);
    final private Font mainFont = new Font("細明本",Font.BOLD,16 );
    final private Font inputFont = new Font("細明本",Font.BOLD,20);
    JTextField tfAccount,tfPassword;
    //JLabel lbWelcome;
    
    
    public void initialize(){
        /****************** Form Panel(North) *******************/
        JLabel Title = new JLabel();
        Title.setFont(TitleFont);
        //Title.setBackground(new Color(176,224,230));
        /****************** Center Label *******************/
        ImageIcon icon = new ImageIcon("Librarypic2.jpg"); //圖片找不到
        JLabel librarypic = new JLabel(icon);
        librarypic.setVisible(true);
        librarypic.setSize(600, 380); 
       // libraryphoto.setIconImage(icon.getImage());

        /****************** Buttons Panel *******************/
        JButton btncontinue = new JButton("Continue");
        btncontinue.setFont(TitleFont);
        btncontinue.setPreferredSize(new Dimension(100,35));
        btncontinue.setBackground(new Color(245,222,179));
        //btncontinue.setBorder(BorderFactory.createLineBorder(new Color(139,69,19)));
        btncontinue.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) { //按下"繼續"botton之後會執行
                    SelectServiceFrame1 frame=new SelectServiceFrame1();
                    new SelectServiceFrame1().initialize();
                    setVisible(false);
            }

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,1,5,5));
        buttonPanel.add(btncontinue);
        

        JPanel mainPanel = new JPanel(); //面板
        JFrame myframe = new JFrame();
        mainPanel.setLayout(new BorderLayout()); //create layout manager
        mainPanel.setBorder(BorderFactory.createEmptyBorder(45,85,40,85));
        mainPanel.setBackground(new Color(51,181,249));
        //mainPanel.add(Title, BorderLayout.NORTH);
        mainPanel.add(librarypic);
        mainPanel.add(Title, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("     歡迎來到 Java 圖書館"); //標題
        
        setSize(600,370); //窗口尺寸
        setMinimumSize(new Dimension(200,300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true); //make the frame visible
    }
    public static void main(String [] args){
        MainFrame loginFrame = new MainFrame();
        loginFrame.initialize();
    }
}
