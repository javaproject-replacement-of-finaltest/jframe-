import java.util.ArrayList;
import java.io.Serializable;
class User implements Serializable{
    protected int account;
    protected String name;
    protected ArrayList<Book>Bookid=new ArrayList<Book>();
    protected int password;
    protected int quantity;
    
    public User(int account,String name,int password){
        setaccout(account);
        setname(name);
        setpassword(password);
        quantity=0;
    }
    public int getaccount(){
        return this.account;
    }
    public void setaccout(int account){
        this.account=account;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public int getpassword(){
        return password;
    }
    public void setpassword(int password){
        this.password=password;
    }
    public int getquantity(){
        return quantity;
    }
    public void setquantity(){
        this.quantity++;
    }
    public String toString(){
        return "姓名:"+getname()+"\n帳號:"+getaccount();
    }
}