import java.io.Serializable;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.AbstractList;

class Admin extends User implements Serializable {

    public Admin(int account, String name, int password) {
        super(account, name, password);
    }
    
    public void ADD_BOOK(AbstractList Book,String name,String author,String publishinghouse ) {      //能這樣抓 Book嗎
        boolean state = false;     //直接設定為沒租借
        Book.add(new Book(name,publishinghouse, state,author));  
		JOptionPane.showMessageDialog(null,"新增成功！");
	}
	
	public void REMOVE_BOOK(Liberary liberary) {	
		String output="[依該書名搜尋到的書籍資料,請輸入要刪除ID為何者的書籍?]";   
		int k=0;  //選項數量
		
		JOptionPane.showMessageDialog(null,"輸入以下資訊完成刪除書籍！");		
		String name = JOptionPane.showInputDialog("你想刪除那本書的書名？");

        for(int i=0;i<liberary.getBookArraylist().size();i++) {  //抓出書名相同的物件
            if(name.equals(liberary.getBook(i).getname())){               
            	output+="\n"+liberary.getBook(i).toString();
            	k++;
            }
        }
		
        if(k!=0) {   //如果option1[0]==null 代表找不到該名子的書			
        	int IDinOption=Integer.parseInt(JOptionPane.showInputDialog(null,output));         
			
			for(int i=0;i<liberary.getBookArraylist().size();i++) {   //利用ID刪掉書的物件
                if(IDinOption==liberary.getBook(i).getid()){  //剛剛在option陣列存的ID是否等於book陣列id
                	liberary.getBookArraylist().remove(liberary.getBook(i));
                }
            }
            JOptionPane.showMessageDialog(null,"刪除成功！");
			
        }
        else {
        	JOptionPane.showMessageDialog(null,"刪除失敗！找不到該本書！");
        }
        
	}	
        
	public void REVISE_BOOK(Liberary liberary) {      //id可以修改嗎?
		String output="[依該書名搜尋到的書籍資料，請問要修改ID為何者的書籍?]";   
		String[] option2= {"修改結束","書名","作者","出版社","租借狀況"};   //詢問該本書的想修改哪項資料
		String[] option3= {"租借中","未租借"}; //詢問該本書的租借狀況想改為何者
		int k=0;  //同名書的選項數量   
		int flag=0;
		
		JOptionPane.showMessageDialog(null,"輸入以下資訊完成修改書籍！");		
		String name = JOptionPane.showInputDialog("你想修改那本書的書名？");

        for(int i=0;i<liberary.getBookArraylist().size();i++) {  //抓出書名相同的物件
            if(name.equals(liberary.getBook(i).getname())){               
            	output+="\n"+liberary.getBook(i).toString();
            	k++;
            }
        }

        if(k!=0) {   //如果option1[0]==null 代表找不到該名子的書
        	int IDinOption=Integer.parseInt(JOptionPane.showInputDialog(null,output)); 
            
            for(int i=0;i<liberary.getBookArraylist().size();i++) {   //利用ID刪掉書的物件
                if(IDinOption==liberary.getBook(i).getid()){  //剛剛在option陣列存的ID是否等於book陣列id
                	do{	 //選擇更改哪個選項
                    	int action = JOptionPane.showOptionDialog(null,"選擇你想修改哪項資料", "管理員修改系統",0,3, null,option2 , null);
                    	
                    	switch(action) {
                    		case 0 :
                    			flag=1;
                    			JOptionPane.showMessageDialog(null,"離開修改");
                    			break;
                    		case 1 :              			
                    			String newname = JOptionPane.showInputDialog("欲修改的新書名:");
                    			liberary.getBook(i).setname(newname);     //這樣寫可嗎>先到圖書館抓該本書，再去抓她的set
                    			break;
                    		case 2 :
                    			String newauthor = JOptionPane.showInputDialog("欲修改的新作者:");
                    			liberary.getBook(i).setauthor(newauthor);
                    			break;
                    		case 3 :
                    			String newpublishinghouse = JOptionPane.showInputDialog("欲修改的新出版社:");
                    			liberary.getBook(i).setpublishinghouse(newpublishinghouse);
                    			break;
                    		case 4 :
                    			boolean newstate=false; //先設立為未租借
                    			int j = JOptionPane.showOptionDialog(null,"選擇將該書的借還狀態設為?", "管理員修改系統",0,3, null,option3 , null);
                    			if(j==0) {
                    				newstate = true;
                    			}
                    			else {
                    				newstate = false;
                    			}
                    			liberary.getBook(i).setstate(newstate);
                    			break;
                    	}
                    }while (flag==0);
                	JOptionPane.showMessageDialog(null,"修改成功！");
                	JOptionPane.showMessageDialog(null,"以下為更新後該書資料\n"+liberary.getBook(i).toString());
                }
            }
        }
        else {
        	JOptionPane.showMessageDialog(null,"修改失敗！找不到該本書！");
        }
	}
    
}