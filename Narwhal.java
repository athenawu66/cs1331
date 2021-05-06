//I worked on the homework assignment alone, using only course materials.
/**
* This class represents a Narwhal object
* @author Athena Wu
* @version 1.0
 */
public class Narwhal extends Pet {
    private int hornLength;
    /**
    * Constructs a Narwhal object via default values
     */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }
    /**
    * Constructs a Narwhal object given the name, age, pain level, and horn length of the Narwhal object
    * @param name name of the Narwhal object
    * @param age age of the Narwhal object
    * @param painLevel pain level of the Narwhal object
    * @param hornLength horn length of the Narwhal object
     */
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }
    /**
    * Method that represents a Narwhal playing with another pet
    * @param p Pet object being passed in
     */
    public void playWith(Pet p) {
        if (p instanceof Narwhal) {
            System.out.println("Who needs dogs and cats when we have each other");
            int newPainLevel = super.getPainLevel() - 2;
            super.setPainLevel(newPainLevel);
        } else {
            System.out.println("I live in the ocean so I can't play with you");
            int newPainLevel = super.getPainLevel() + 1;
            super.setPainLevel(newPainLevel);
        }
    }
    @Override
    public String toString() {
        return super.toString() + "I have a horn that is " + hornLength + " feet long.";
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Narwhal)) {
            return false;
        }

        Narwhal narwhal1 = (Narwhal) o;
        return (super.equals(narwhal1) && hornLength == narwhal1.hornLength);
    }
    /**
    * Method to get the hornLength
    * @return hornLength
     */
    public int getHornLength() {
        return hornLength;
    }
    /**
    * Method that sets a new hornLength
    * @param newHornLength the new hornLength
     */
    public void setHornLength(int newHornLength) {
        hornLength = newHornLength;
    }
}