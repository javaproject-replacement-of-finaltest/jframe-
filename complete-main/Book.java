import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;

class Book implements Serializable{
    private String name;
    private String author;
    static int nownumber=0;
    //我現在要讓id保持獨立，而且id要由我指派，所以我就模仿mysql讓數字不斷相加，就算書本被刪除我也不介意
    private int id;
    private String publishinghouse;
    //我假定true為在架上
    //我假定false為不在架上
    private boolean state;
    //現在我要處理關於data的問題，我打算取出現在的時間，然後透過calender加上30天，最後在還書當天使用data的內建方法去進行兩個時間的比較
    private LocalDate time;
    private int totalscore=0;
    private int times=0;
    private double score=0;
    
    
    public Book(String name,String publishinghouse,boolean state,String author){
        setname(name);
        nownumber++;
        setid();
        setpublishinghouse(publishinghouse);
        setstate(state);
        System.out.println("此書籍的nownumber為"+nownumber);
        setauthor(author);
        System.out.print(getid());
    }
    //
    public void setid(){
        this.id=nownumber;
    }
    public int getid(){
        return id;
    }
    //
    public void setauthor(String author){
        this.author=author;
    }
    public String getauthor(){
        return author;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public String getpublishinghouse(){
        return publishinghouse;
    }
    public void setpublishinghouse(String publishinghouse){
        this.publishinghouse=publishinghouse;
    }
    public boolean getstate(){
        return state;
    }
    public void setstate(boolean state){
        this.state=state;
    }
    public LocalDate getDate(){
        return time;
    }
    public void setDate(LocalDate time){
        this.time=time;
    }
    public static int getnownumber(){
        return nownumber;
    }
    public static void setnownumber(int getnownumber){
        nownumber=getnownumber;
    }
    public void settimes(){
        this.times++;
    }
    public int gettimes(){
        return times;
    }
    public void settotalscore(int input){
        this.totalscore+=input;
    }
    public int gettotalscore(){
        return totalscore;
    }
    public double getscore(){
        if(gettimes()!=0){
            this.score=gettotalscore()/gettimes();
            return score;
        }
        else{
            return 0;
        }
    }

    public String toString(){
        String output="書籍名稱："+getname()+"\n書籍id:"+getid()+"\n書籍出版社:"+getpublishinghouse()+"\n作者名稱:"+getauthor()+"\n"+"借閱狀態"+(state==false?"尚可借閱":"到期日期為:"+getDate())+"\n"+"評分:"+((getscore()!=0?(getscore()+"分"):"目前暫無評分")+"\n");
        return output;
        //要改
    }
    

}