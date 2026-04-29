import java.util.ArrayList;
import java.util.Random;
/**
 * This sets up the variables, the getters and setters, constructors, and meathods
 */
public class Zoo {
    private String name;
        private String zookeeper;
        private String location;
        private int openingTime;
        private int closingTime;
        private ArrayList<String> animals;
        public Zoo() {
            this.name = "Every zoo needs a name";
            this.zookeeper = "Who is the keeper";
            this.location = "Where should we be";
            this.openingTime = 800;
            this.closingTime = 1700;
            this.animals = new ArrayList<>();
        }
        public Zoo(String name, String zookeeper, String location) {
            this.name = name;
            this.zookeeper = zookeeper;
            this.location = location;
            this.openingTime = 800;
            this.closingTime = 1700;
            this.animals = new ArrayList<>();
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getZookeeper(){
            return zookeeper;
        }
        public void setZookeeper(String zookeeper){
            this.zookeeper = zookeeper;
        }
        public String getLocation(){
            return location;
        }
        public void setLocation(String location){
            this.location = location;
        }
        public int getOpeningTime(){
            return openingTime;
        }
        public void setOpeningTime(int openingTime){
            this.openingTime = openingTime;
        }
        public int getClosingTime(){
            return closingTime;
        }
        public void setClosingTime(int closingTime){
            this.closingTime = closingTime;
        }
        /**
         * this method sets a deafult string
         */
        public String toString() {
            String info = name+" opens at: "+openingTime+". And closes at "+closingTime+". The zookeeper is: "+zookeeper+". And is located in: "+location;
            return info;
        }
        /**
         * takes two strings and checks if equal
         * @param other the string being compared
         * @return if they are equal are not
         */
        public boolean equals(Zoo other) {
            return (this.location.equals(other.getLocation()) && this.name.equals(other.getName()) && this.openingTime == other.getOpeningTime() && this.closingTime == other.getClosingTime() && this.zookeeper.equals(other.getZookeeper()));
        }
        /**
         * 
         * @param count number of animals to add
         * @param animalPool animals to chose from
         */
        public void buyAnimals(int count, String[] animalPool) {
            Random rand = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = rand.nextInt(animalPool.length);
                animals.add(animalPool[randomIndex]);
            }
        }
        /**
         * finds animals in zoo and returns them
         * @return the animals
         */
        public String queryAnimals() {
            return "Animals in " + name + ": " + String.join(", ", animals);
        }
}
