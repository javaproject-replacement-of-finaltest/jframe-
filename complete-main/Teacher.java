import java.io.Serializable;
class Teacher extends User2 implements Serializable{

    public Teacher(int account, String name, int password) {
        super(account, name, password);
    }
    
}
