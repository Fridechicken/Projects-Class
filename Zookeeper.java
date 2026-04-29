/*
* Project 3
* Logan Mitchell
* 4/26/26
* This is my own original work and complies with hands-free sharing
* I discussed this work with no one
*/
public class Zookeeper {
    /**
     * Tests all the setters and meathods
     * @param args
     */
    public static void main(String[] args) {
        Zoo zoo1 = new Zoo();
        Zoo zoo2 = new Zoo("Big Zoo", "Bob", "Dover");
        String[] pool = {"Otter", "Penguin", "Lion", "Giraffe", "Bear", "Monkey"};
        System.out.println("First zoo: "+zoo1.toString());
        System.out.println("Second zoo: "+zoo2.toString());
        zoo1.setName("City Zoo");
        zoo1.setZookeeper("Logan");
        zoo1.setLocation("York");
        zoo1.setOpeningTime(900);
        zoo1.setClosingTime(2000);
        zoo2.buyAnimals(5, pool);
        System.out.println(zoo2.queryAnimals());
        Zoo zoo3 = new Zoo("Big Zoo", "Bob", "Dover");
        System.out.println("Zoo 2 = Zoo 3: " + zoo2.equals(zoo3));
        System.out.println("Zoo 1 = Zoo 2: " + zoo1.equals(zoo2));
    }
}