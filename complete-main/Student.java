import java.io.Serializable;
class Student extends User2 implements Serializable{

    public Student(int account, String name, int password) {
        super(account, name, password);
    }
    
}
