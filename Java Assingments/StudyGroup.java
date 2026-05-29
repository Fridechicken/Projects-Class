
import java.util.ArrayList;

public class StudyGroup {
    public static void main(String[] args) {
        ArrayList<d11a_Student> group1 = new ArrayList<d11a_Student>();
        ArrayList<d11a_Student> group2 = new ArrayList<d11a_Student>();
        d11a_Student tim = new d11a_Student("Tim", "Comp Sci", "junior", "MSMU");
        d11a_Student jim = new d11a_Student("Jim", "Bio", "freshman", "MSMU");
        d11a_Student bim = new d11a_Student("Bim", "Chem", "senior", "MSMU");
        d11a_Student sim = new d11a_Student("Sim", "Data", "sophmore", "MSMU");
        d11a_Student kim = new d11a_Student("Kim", "Cyber", "freshman", "MSMU");
        d11a_Student fim = new d11a_Student("Fim", "Math", "freshman", "MSMU");
        d11a_Student rim = new d11a_Student("Rim", "Stats", "senior", "MSMU");
        d11a_Student pim = new d11a_Student("Pim", "BioChem", "junior", "MSMU");
        group1.add(tim);
        group1.add(jim);
        group1.add(bim);
        group1.add(sim);
        group2.add(kim);
        group2.add(fim);
        group2.add(rim);
        group2.add(pim);
        System.out.println(group1);
        d11a_Student.goingWell();
        System.out.println(group2);
        d11a_Student.goingPoorly();
        
    }
}
