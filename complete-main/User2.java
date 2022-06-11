import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;
import java.time.temporal.*;

import java.time.LocalDate;

class User2 extends User implements Serializable{ //Member class

    int NumberofBorrowed; 
	int payfine;
	static int nownumber=0;
    ArrayList<Book> BorrowBook=new ArrayList<Book>();
	
    public User2(int account, String name, int password) {
        super(account, name, password);
		NumberofBorrowed=0;

    }
    //某使用者正在借的數量
    public void setNumberofBorrowed(int numberofborrowed) {
        this.NumberofBorrowed = numberofborrowed;
    }
    public int getNumberofBorrowed(int i) {
        NumberofBorrowed+=i;
        return NumberofBorrowed;
    }
    public void setPayfine(){
		this.payfine = 30;
	}
	public long getPayfine(){
		return payfine;
	}
     //當我進行客戶查詢的時候就輸出這個
     public String brorrowtoString(){
        String output="";
        output+="姓名:"+getname()+"\n借閱紀錄:\n";
        for(int i=0;i<Bookid.size();i++){
            output+=Bookid.get(i)+"\n";
        }
        return output;
    }
   
    public int BorrowBook(Liberary liberary) { //從library傳入引數
		//圖書館全部書籍的數量
		String Options[] = { "作者" , "書本名稱" , "書本ID" };
		int option;
		String input;
		if(NumberofBorrowed >= 3){ //先設定只能借2本
			JOptionPane.showMessageDialog(null,"您已達到借書數量上限","抱歉",1);
		}
		else{
		option = JOptionPane.showOptionDialog(null,"請問您要以何種方式做查詢?", "請選擇" ,0,3,null,Options,null);
		System.out.println("option為"+option);
		ArrayList<Book> place = new ArrayList<>();
		switch(option) {
			case 0: //Author name
				int r = 0;
				int q=0;
				input = JOptionPane.showInputDialog(null, "請輸入欲查詢作者之姓名:");
				//用作者找書
				for(int i = 0; i < liberary.getBookArraylist().size() ; i++) 
				{   
						
					if (input .equals(liberary.getBook(i).getauthor()))
					{	//代表有這本書
						if(liberary.getBook(i).getstate()==true)  //書已被借走
						{
							//continue;
						}
						else 
						{		
							r=1;
							place.add(liberary.getBook(i));
						}
					}
				}
				if(r==1){
					//前置處理
					String[] placebookname=new String[place.size()];
					for(int i=0;i<place.size();i++){
						placebookname[i]=place.get(i).getname()+"  id為:"+place.get(i).getid();
					}
					String choosebook;
					int j,b=0;
					choosebook=(String)JOptionPane.showInputDialog(null,"你想借閱哪本書?","借書",JOptionPane.QUESTION_MESSAGE,null,placebookname, null);
					System.out.println(choosebook);
					for( j = 0 ; j < place.size(); j++){
						if(choosebook == placebookname[j]){
							 b = j;
							 break;
						}
					}
					System.out.println(b);
					System.out.println(choosebook);
					getNumberofBorrowed(1);
					BorrowBook.add(place.get(b));
					place.get(b).setstate(true);
					LocalDate todaysDate = LocalDate.now();
					//Date borrowdate = sdf.parse(todaysDate);
					place.get(b).setDate(todaysDate);
					if(choosebook != null){
						JOptionPane.showMessageDialog(null,"借閱成功!\n借閱日期:" + place.get(b).getDate());	
					}
					int data;
                    data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                    if(data==0){
                        listdetail(((Book)place.get(b)));
                    }
					
				}else{
					JOptionPane.showMessageDialog(null, "未找到相關書籍");
				}
				q=JOptionPane.showConfirmDialog(null,"請問要續續借下一本書嗎?","詢問",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(q != 0)
				{ //不重新輸入
					JOptionPane.showMessageDialog(null,"借書服務到此","服務結束",1);
					return 0;
				} 
				return 1;
				
				//JOptionPane.showConfirmDialog(null,"已達到借書上限，無法再借閱新的書籍\n","抱歉",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
			case 1: //bookname
				int p = 0;
				input = JOptionPane.showInputDialog(null,"請輸入欲查尋之書本名稱:");
				for(int i = 0; i < liberary.getBookArraylist().size() ; i++) 
				{   
						
					if (input .equals(liberary.getBook(i).getname()))
					{	//代表有這本書
						if(liberary.getBook(i).getstate()==true)  //書已被借走
						{
							//continue;
						}
						else 
						{
							p=1; 
							place.add(liberary.getBook(i));
						}
					}
				}
				if(p==1){ //開始借書
					//前置處理
					String[] placebookname = new String[place.size()];
					for(int i=0;i<place.size();i++){
						placebookname[i]=place.get(i).getname()+"  id為:"+place.get(i).getid();
					}
					String choosebook;
					int j,b=0;
					choosebook=(String)JOptionPane.showInputDialog(null,"你想借閱哪本書?","借書",JOptionPane.QUESTION_MESSAGE,null,placebookname, null);
					System.out.println(choosebook);
					for( j = 0 ; j < place.size(); j++){
						if(choosebook == placebookname[j]){
							 b = j;
							 break;
						}
					}
					System.out.println(b);
					System.out.println(choosebook);
					getNumberofBorrowed(1);
					BorrowBook.add(place.get(b));
					place.get(b).setstate(true);
					LocalDate todaysDate = LocalDate.now();
					//Date borrowdate = sdf.parse(todaysDate);
					place.get(b).setDate(todaysDate);
					if(choosebook != null){
						JOptionPane.showMessageDialog(null,"借閱成功!\n借閱日期:" + place.get(b).getDate());	
					}
					int data;
                    data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                    if(data==0){
                        listdetail(((Book)place.get(b)));
                    }
					
				}else{
					JOptionPane.showMessageDialog(null, "未找到相關書籍");
				}
				q=JOptionPane.showConfirmDialog(null,"請問要續續借下一本書嗎?","詢問",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(q != 0)
				{ //不重新輸入
					JOptionPane.showMessageDialog(null,"借書服務到此","服務結束",1);
					return 0;
				} 
				return 1;
			default:
				int pdefault = 0;
				int intinput = Integer.parseInt(JOptionPane.showInputDialog(null,"請輸入欲查尋之書ID:"));
				for(int i = 0; i < liberary.getBookArraylist().size() ; i++) 
				{   
						
					if (intinput==liberary.getBook(i).getid())
					{	//代表有這本書
						if(liberary.getBook(i).getstate()==true)  //書已被借走
						{
							//continue;
						}
						else 
						{
							pdefault=1; 
							place.add(liberary.getBook(i));
						}
					}
				}
				if(pdefault==1){ //開始借書
					//前置處理
					String[] placebookname = new String[place.size()];
					for(int i=0;i<place.size();i++){
						placebookname[i]=place.get(i).getname()+"  id為:"+place.get(i).getid();
					}
					String choosebook;
					int j,b=0;
					choosebook=(String)JOptionPane.showInputDialog(null,"你想借閱哪本書?","借書",JOptionPane.QUESTION_MESSAGE,null,placebookname, null);
					System.out.println(choosebook);
					for( j = 0 ; j < place.size(); j++){
						if(choosebook == placebookname[j]){
							 b = j;
							 break;
						}
					}
					System.out.println(b);
					System.out.println(choosebook);
					getNumberofBorrowed(1);
					BorrowBook.add(place.get(b));
					place.get(b).setstate(true);
					LocalDate todaysDate = LocalDate.now();
					//Date borrowdate = sdf.parse(todaysDate);
					place.get(b).setDate(todaysDate);
					if(choosebook != null){
						JOptionPane.showMessageDialog(null,"借閱成功!\n借閱日期:" + place.get(b).getDate());	
					}
					int data;
                    data=JOptionPane.showConfirmDialog(null,"請問要列印詳細明細嗎?");
                    if(data==0){
                        listdetail(((Book)place.get(b)));
                    }
					
				}else{
					JOptionPane.showMessageDialog(null, "未找到相關書籍");
				}
				q=JOptionPane.showConfirmDialog(null,"請問要續續借下一本書嗎?","詢問",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(q != 0)
				{ //不重新輸入
					JOptionPane.showMessageDialog(null,"借書服務到此","服務結束",1);
					return 0;
				} 
				return 1;
		}
		
		}
		return 0;	
	}
    public void returnbook(User2 j){
		//找出使用者目前借了哪幾本書
		int q = 0;
		do{
		ArrayList<Book> place = new ArrayList<>(); //放找到的書
		for(Book findBook : j.BorrowBook){
			place.add(findBook);
		}
		System.out.println(place);
		String[] bookreturn = new String[place.size()];
		for(int i=0;i<place.size();i++){
			bookreturn[i]=place.get(i).getname()+"\nid 為"+place.get(i).getid();
		}
		String Options;
		if(j.BorrowBook.size() == 0){
			JOptionPane.showMessageDialog(null,"您目前尚未借閱任何書籍，無須還書，謝謝","訊息",1);
			q = 1;
		}
		else{
		Options = (String)JOptionPane.showInputDialog(null,"請選擇欲退還的書籍","還書",JOptionPane.QUESTION_MESSAGE,null,bookreturn,null);
		//檢查是否還書時間預期
		int r,b=0;
		for( r = 0 ; r < place.size(); r++){
			if(Options == bookreturn[r]){
				b = r;
			 	break;
			}
		}
		LocalDate returnDate = LocalDate.now();
		long diff = ChronoUnit.DAYS.between(place.get(b).getDate(), returnDate);
		System.out.println("借了:" + diff + "天");
		int day = (int)diff;
		String out = "付款完成，退還書成功!\n書籍名稱: " + place.get(b).getname() + "\n到期日: " + place.get(b).getDate() + "\n歸還日期: " + returnDate ;
		if( day >= 0){ //測試先設0天就逾期
			setPayfine();
			int choice;
			choice = JOptionPane.showConfirmDialog(null,"您借的書已逾期" + diff + "天，需繳罰金:" + getPayfine() + "元","提醒",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(choice == 0){//確認還書
				JOptionPane.showMessageDialog(null,out,"訊息",1);
			}//繳費部分還要再想
			else{//不願意繳費，還書失敗
				JOptionPane.showMessageDialog(null,"歸還書失敗!\n請盡快將書籍退還並繳交罰金，謝謝","提醒",1);
			}
		}
		else{ //沒有逾期
			JOptionPane.showMessageDialog(null,out,"訊息",1);
		}
		getNumberofBorrowed(-1);
		j.BorrowBook.remove(place.get(b));
		place.get(b).setstate(false); 
		place.get(b).setDate(null);
		q = JOptionPane.showConfirmDialog(null,"繼續還書嗎?", "詢問" , JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
		}
		if(q != 0)
				{ //不繼續
					JOptionPane.showMessageDialog(null,"還書服務到此","服務結束",3);
				} 
	}while(q == 0);
        //Liberaray那邊的書籍狀態也要被更改
	
    }

	public void listdetail(Book book){
		try {
            FileWriter myWriter = new FileWriter("第"+nownumber+"次借書完整報告.txt");
            myWriter.write(book.toString()+"\n");
            myWriter.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        nownumber++;
	}
	
}

