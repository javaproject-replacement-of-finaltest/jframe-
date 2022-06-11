import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Resultframestudent extends JPanel{
    JLabel j1;
    JScrollPane scroller;
    JFrame frame;
    JTextArea text;
    /*解釋:
     * 我的jframe會有很多個元件，現在包含一個jpanel還有按鈕(我還沒做)
     * jpanel上面要加上jscrollPane
     * jscroller上面要加上jtextrea
     */
   
    public Resultframestudent(String output){ 
       frame = new JFrame("Borrower Record");
       //super(true);
       j1 = new JLabel(output);
       System.out.println(j1);
       //設定滾輪東東
       text=new JTextArea(10,20);
       text.append(output);
       text.setEditable(false);
       text.setFont(new Font("標楷體",Font.BOLD,18));
       text.setBounds(250, 250, 400, 100); 
       text.setBackground(new Color(245,255,250));
      
       scroller=new JScrollPane(text);
       scroller.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
       scroller.setPreferredSize(new Dimension(240,220));
       scroller.getVerticalScrollBar().setBlockIncrement(1);
       //scroller.setBackground(new Color(210,105,30)); ;
       
       //JScrollBar jscrollBar = new JScrollBar(JScrollBar.VERTICAL, 30, 20, 0, 300);
       scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
       //scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
       add(scroller,BorderLayout.CENTER);


       JButton btnOK = new JButton("Back to service menu");
       btnOK.setFont(new Font("Segoe print",Font.BOLD,15));
       btnOK.setPreferredSize(new Dimension(200,33));
       btnOK.setBackground(new Color(240,248,255));
       setBackground(new Color(245,222,179));
       add(btnOK,BorderLayout.SOUTH);
      //設定frmae//
       frame.getRootPane().setBorder(
        BorderFactory.createEmptyBorder(2, 4, 4, 4)
        );
       frame.setLayout(new BorderLayout());
       frame.setSize(300,320);
       frame.setMinimumSize(new Dimension(250,300));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().add(BorderLayout.CENTER,this);
       frame.setLocationRelativeTo(null); 
       frame.setVisible(true);
       btnOK.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) { //按下"繼續"botton之後會執行
        frame.dispose();
        new Studemtframe().initialize();
        }
    
    });
   }
  
}
