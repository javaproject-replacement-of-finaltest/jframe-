import java.util.ArrayList;
import java.util.AbstractList;
import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

class Liberary implements Serializable {
    private ArrayList<Admin> Admin=new ArrayList<Admin>();
    private ArrayList<Student>Student=new ArrayList<Student>();
    private ArrayList<Teacher>Teacher=new ArrayList<Teacher>();
    private ArrayList<Staff>Staff=new ArrayList<Staff>();
    private ArrayList<Book>Book=new ArrayList<Book>();
    int nownumber=0;

    public Liberary(){
        //我先假定圖書館被創造出都是全新的東東
        //先把我設定為管理員
        Admin.add(new Admin(11,"楊薇蓉", 11));
        Admin.add(new Admin(22,"洪宇承", 22));
        Admin.add(new Admin(33,"張婷婷", 33));
        Admin.add(new Admin(44,"李偉云", 44));

        Book.add(new Book("java","test", false,"minnie"));
        Book.add(new Book("java","test", false,"minnie"));
        Book.add(new Book("python","test", false,"minnie"));
        Book.add(new Book("c++","test", false,"minnie"));
        Book.add(new Book("html","test", false,"minnie"));
        Book.add(new Book("macroeconomics","test", true,"yucheng"));
        Book.add(new Book("microeconomics","test", true,"yucheng"));
        Book.add(new Book("corporate finance","test", true,"yucheng"));
        Book.add(new Book("statistics","test", true,"yucheng"));
        Book.add(new Book("monetary economics","test", true,"yucheng"));
        
        System.out.println(Book.get(0).getname());
        System.out.println(Admin.get(0).getname());
        Student.add(new Student(11,"楊薇蓉", 11));
        Student.add(new Student(22,"洪宇承", 22));
        Student.add(new Student(33,"張婷婷", 33));
        Student.add(new Student(44,"李偉云", 44));

        Staff.add(new Staff(11,"楊薇蓉", 11));
        Staff.add(new Staff(22,"洪宇承", 22));
        Staff.add(new Staff(33,"張婷婷", 33));
        Staff.add(new Staff(44,"李偉云", 44));

        Teacher.add(new Teacher(11,"楊薇蓉", 11));
        Teacher.add(new Teacher(22,"洪宇承", 22));
        Teacher.add(new Teacher(33,"張婷婷", 33));
        Teacher.add(new Teacher(44,"李偉云", 44));
    }
    public int getsize(AbstractList list){
        return list.size();
    }
    public AbstractList getStudentArraylist(){
        return Student;
    }
    public AbstractList getTeacherArraylist(){
        return Teacher;
    }
    public AbstractList getStaffArraylist(){
        return Staff;
    }
    public AbstractList getBookArraylist(){
        return Book;
    }
    public AbstractList getAdminArraylist(){
        return Admin;
    }
    public Student getstudent(int i){
        return Student.get(i);
    }
    public void setstudent(Student student){
        Student.add(student);
    }
    //public void deletestudent(int i)
    public Teacher getTeacher(int i){
        return Teacher.get(i);
    }
    public void setTeacher(Teacher teacher){
        Teacher.add(teacher);
    }
    public Admin getAdmin(int i){
        return Admin.get(i);
    }
    public void setAdmin(Admin admin){
        Admin.add(admin);
    }
    public Staff getStaff(int i){
        return Staff.get(i);
    }
    public void setStaff(Staff staff){
        Staff.add(staff);
    }
    public Book getBook(int i){
        return Book.get(i);
    }
    public void setBook(Book book){
        Book.add(book);
    }
    public int register(int choice,int account,int password,String name){
        //記得要確認有無註冊成功
        //我假定帳號不能一樣就好
        AbstractList testtest;
        int result;
        //ArrayList<User> userconnect=new ArrayList<User>();
        switch(choice){
            case 0:
                result=reduceforinregistration(Admin, account);
                if(result==1){
                    return 1;
                }
                Admin.add(new Admin(account,name,password));
                return 0;
            case 1:
                result=reduceforinregistration(Teacher, account);
                if(result==1){
                    return 1;
                }
                Teacher.add(new Teacher(account,name,password));
                return 0;
            case 2:
                result=reduceforinregistration(Staff, account);
                if(result==1){
                    return 1;
                 }
                Staff.add(new Staff(account,name,password));
                return 0;
            default:
                result=reduceforinregistration(Student, account);
                if(result==1){
                    return 1;
                }
                Student.add(new Student(account,name,password));
            return 0;
        }
            
    }
    public int[] login(int choice,int password,int account){
        //我讓login回傳整數陣列:第一個數字為index索引值，第二個數字為account
        int[] returnint=new int[2];
        switch(choice){
            case 0:
                returnint=reduceforinlogin(account,Admin,password);
                break;
            case 1:
                returnint=reduceforinlogin(account,Teacher,password);
                break;
            case 2:
                returnint=reduceforinlogin(account,Staff,password);
                break;
            case 3:
                returnint=reduceforinlogin(account,Student,password);
                System.out.println("我是學生！！！");
                break;
        }

        return returnint;
    }
    public String select(){
        String[] way={"依照作者查詢","依照出版社查詢","依照書名查詢"};
        String output="";
        int waychoose=JOptionPane.showOptionDialog(null, "你要用甚麼方法查詢", "查詢系統",0,3, null,way , null);
        String word=JOptionPane.showInputDialog(null,"查詢名稱");
        switch(waychoose){
            case 0:
                for(int i=0;i<Book.size();i++){
                    if(word.equals(Book.get(i).getauthor())){
                        output+=Book.get(i);
                        output+="\n";
                    }
                }
                break;
            case 1:
                for(int i=0;i<Book.size();i++){
                    if(word.equals(Book.get(i).getpublishinghouse())){
                        output+=Book.get(i);
                        output+="\n";
                    }
                }
                break;
            case 2:
               for(int i=0;i<Book.size();i++){
                   if(word.equals(Book.get(i).getname())){
                        output+=Book.get(i);
                        output+="\n";
                    }
                }
                break;
        }
        return output;
    }
    public String listall(AbstractList user){
        String output="";
        for(int i=0;i<user.size();i++){
            output+=user.get(i)+"\n";
        }
        if(output==""){
            return "目前圖書館無資料";
        }
        return output;
    }
    public int reduceforinregistration(AbstractList superclass,int account){
        for(int i=0;i<superclass.size();i++){
            if(((User) superclass.get(i)).getaccount()==account){
                return 1;          
            }    
        }
        return 0;

    }
    public int[] reduceforinlogin(int account,AbstractList superclass,int password){
        int[] returnint=new int[2];
        for(int i=0;i<superclass.size();i++){
            if(((User) superclass.get(i)).getaccount()==account){
                //test
                System.out.println("account的取値東東為"+((User) superclass.get(i)).getaccount());
                System.out.println("account的東東為"+ account);
                System.out.println("password的東東為"+password);
                System.out.println("我要確認的密碼為"+((User) superclass.get(i)).getpassword());
                System.out.println(password); 
                //test
                if(((User) superclass.get(i)).getpassword()==password){
                        returnint[0]=i;
                        returnint[1]=((User) superclass.get(i)).getaccount();
                        return returnint;
                }else{
                    returnint[0]=1;
                    returnint[1]=-1;
                    return returnint;
                }  
            }    
        }
        returnint[0]=2;
        returnint[1]=-1;
        return returnint;    
    }
    public void producetxt(AbstractList superclass){
        try {
            FileWriter myWriter = new FileWriter("第"+nownumber+"份報告.txt ");
            for(int i=0;i<superclass.size();i++){
              myWriter.write(superclass.get(i).toString()+"\n");
              
            }
            myWriter.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        nownumber++;
    }
    //先暫時不動//
    //學生的特殊功能//
    public String rankoutput(){
        String output="圖書風雲榜-讀書拿獎品";
        String first="第一名是";
        String second="第二名是";
        String third="第三名是";
        int f=0,s=0,t=0; //一、二、三名累積借書數量
        
        
        for(int i=0;i<Student.size();i++){  
            System.out.println("第一名的借閱數量為"+Student.get(i).getquantity());    //找出第一名的借書數量
            if(Student.get(i).getquantity()>f){
                f=Student.get(i).getquantity();
            }
        }
        if(f!=0){
            for(int j=0;j<Student.size();j++){    
                //找出第一名是誰
                if(Student.get(j).getquantity()==f){
                        first += "\n"+Student.get(j).getname()+",目前累計"+f+"本書";
                }
            }
        }
        else{
            first +="無";
        }
       

        for(int k=0;k<Student.size();k++){       //找出第二名的借書數量
            if(Student.get(k).getquantity()!=f && Student.get(k).getquantity()>s){
                s=Student.get(k).getquantity();
            }
        }
        if(s!=0){
            for(int l=0;l<Student.size();l++){       //找出第二名是誰
                if(Student.get(l).getquantity()==s){
                        second += "\n"+Student.get(l).getname()+",目前累計"+s+"本書";
                }
            }
        }
        else{
            second +="無";
        }
        

        for(int a=0;a<Student.size();a++){       //找出第三名的借書數量
            if(Student.get(a).getquantity()!=f && Student.get(a).getquantity()!=s && Student.get(a).getquantity()>t){
                t=Student.get(a).getquantity();
            }
        }
        if(t!=0){
            for(int b=0;b<Student.size();b++){       //找出第三名是誰
                if(Student.get(b).getquantity()==t){
                        third += "\n"+Student.get(b).getname()+",目前累計"+t+"本書";
                }
            }         
            
        }
        else{
            third +="無";
        }
        

        output=output+"\n"+first+"\n"+second+"\n"+third;
        return output;
    }
    
}