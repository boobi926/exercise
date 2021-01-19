import javax.xml.soap.SAAJResult;
import java.util.ArrayList;
import java.util.List;
class Student{
    public String name;
    public String cla;
    public double cor;


    public Student(String name, String cla, double cor) {
        this.name = name;
        this.cla = cla;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cla='" + cla + '\'' +
                ", cor=" + cor +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public void setCor(double cor) {
        this.cor = cor;
    }

    public String getName() {
        return name;
    }

    public String getCla() {
        return cla;
    }

    public double getCor() {
        return cor;
    }
}
public class stuPrint {

    public static void main(String args[]){
      Student student1 = new Student("小王","一班",99.9);
      Student student2 = new Student("小张","二班",95.9);

    List<Student> list = new ArrayList<>();
    list.add(student1);
    list.add(student2);
    
    System.out.println(list);
    }
}
