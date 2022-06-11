import java.io.Serializable;
class Staff extends User2 implements Serializable{

    public Staff(int account, String name, int password) {
        super(account, name, password);
    }
    
}
