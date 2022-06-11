import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LiberaryTest{
    static Liberary liberary;
    static int choice2;
    static int returnnumber;
    static int loginnumber;
    //login用來確定是否要繼續
    public static void main(String[] args){
        try{
            Liberary libery=new Liberary();
            //寫入檔案
            //ObjectInputStream is=new ObjectInputStream(new FileInputStream("filenew"));
            //Liberary libery=(Liberary) is.readObject();
            liberary=libery;
            Book.setnownumber(libery.getBook(libery.getBookArraylist().size()-1).getid());
            //測試//
            System.out.println("libery的大小為"+libery.getAdminArraylist().size());
            System.out.println("我要test看看nownumber"+Book.getnownumber());
            //測試//
            MainFrame loginFrame = new MainFrame();
            loginFrame.initialize();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void savefile(Liberary libery){
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("filenew"));
            os.writeObject(libery);
            os.writeInt(Book.nownumber);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static int registratoinbutton(int choice2,int account,int password,String name){
            
            int now=liberary.register(choice2, account, password, name);
            //測試
            System.out.println("現在為now的值"+now);
            System.out.println("現在的choice2"+choice2);
            //測試
            if(now==1){
                JOptionPane.showMessageDialog(null, "已經有相同帳號請重新來過一次", "抱歉",1);
                //return 2 代表有相同帳號
                return 2;
            }
            JOptionPane.showMessageDialog(null, "註冊成功!", "恭喜",1);  
            //TSETTEST//
            System.out.println("老師長度為"+LiberaryTest.liberary.getsize(LiberaryTest.liberary.getTeacherArraylist()));
            //return 1 代表註冊成功
            return 1;
        
    }
    public static void loginbutton(int account,int password){
        int[] answer={0,0};
        answer=LiberaryTest.liberary.login(LiberaryTest.choice2,password, account);
        if(answer[0]==1&&answer[1]==-1){
            JOptionPane.showMessageDialog(null, "密碼錯誤", "抱歉",1);
            returnnumber=1;
            return;
        }else if(answer[0]==2&&answer[1]==-1){
            JOptionPane.showMessageDialog(null, "無該帳號", "抱歉",1);
            returnnumber=1; 
            return;
        }
        JOptionPane.showMessageDialog(null, "登陸成功!", "恭喜",1);  
        returnnumber=0;
        loginnumber=answer[0];
        //這裡跟使用者登陸的功能有關
        System.out.println("這裡的話"+LiberaryTest.choice2);
        //我想設置一個變數假如說該變數為1代表我想要繼續進行
        switch(LiberaryTest.choice2){
            case 0:
                new AdminlogintionL().initialize();
                break;
            case 1:
                new Teacherframe().initialize();
                break;
            case 2:
                new Staffframe().initialize();
                break;
            default:
                new Studemtframe().initialize();
                break;
        }
    } 

    public static void  serchbookbutton(){
        String output=LiberaryTest.liberary.select();
        if(output!=""){
            new ScrollbarFrame(output);
        }else{
           new ScrollbarFrame("無此查詢書籍");
        }
    }
    public static void listliberybook(){
        JOptionPane.showMessageDialog(null,LiberaryTest.liberary.listall(LiberaryTest.liberary.getBookArraylist()),"查詢結果",1);
    }
    public static void shoowrank(){
        String output=LiberaryTest.liberary.rankoutput();
        new ShowRankframe(output);
        //JOptionPane.showMessageDialog(null,output+"\n請各位同學再接再厲!");
    }
}

//現在有一個問題點：假如說我不續借，我希望跳轉到最開始的頁面

