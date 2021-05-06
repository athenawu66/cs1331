/**
* This class represents a Dog object
* @author Athena Wu
* @version 1.0
*/
public class Dog extends Pet implements Treatable {
    private String breed;
    /**
    * Constructs a Dog object given the breed
    * @param breed the breed of the Dog object
     */
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }
    /**
    * Constructs a Dog object given the name, age, painLevel, breed
    * @param name name of the Dog object
    * @param age age of the Dog object
    * @param painLevel pain level of the Dog object
    * @param breed breed of the Dog object
     */
    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }
    /**
    * A method that allows Dog to play with other Pet objects
    * @param p pet object
     */
    public void playWith(Pet p) {
        if (p instanceof Dog) {
            int oldPainLevel = super.getPainLevel();
            int newPainLevel = super.getPainLevel() - 3;
            super.setPainLevel(newPainLevel);
            System.out.println("Woof! I love playing with other dogs so much that my pain level went from "
                + oldPainLevel + " to " + newPainLevel);
        } else if (p instanceof Cat) {
            if (!((Cat) p).getHasStripes()) {
                int oldPainLevel = super.getPainLevel();
                int newPain = super.getPainLevel() - 1;
                super.setPainLevel(newPain);
                System.out.println("Woof. Cats without stripes are okay since they made my pain level go from "
                    + oldPainLevel + " to " + newPain);
            } else {
                int newPainLevel = super.getPainLevel() - 2;
                System.out.println("AHH! I thought you were a tiger!");
            }
        }
    }
    /**
    * reduces the pain level of the Dog object by 3
     */
    public void treat() {
        int painLevel =  super.getPainLevel() - 3;
        super.setPainLevel(painLevel);
    }
    /**
    * Method that prints out "bark bark"
     */
    public void bark() {
        System.out.println("bark bark");
    }
    @Override
    public String toString() {
        return "My name is " + super.getName() + ", I am " + super.getAge()
            + ", and I am a " + breed + ". On a scale of one to ten my pain level is " + super.getPainLevel()
            + ". My age in human years is " + Treatable.convertDogToHumanYears(super.getAge()) + ".";
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog)) {
            return false;
        }
        Dog dog1 = (Dog) o;
        return (super.equals(dog1) && dog1.breed.equals(breed));
    }
    /**
    * method that gets the breed
    * @return breed
    */
    public String getBreed() {
        return breed;
    }
    /**
    * method that sets the breed as the new input breed
    * @param inputBreed the new breed
    */
    public void setBreed(String inputBreed) {
        breed = inputBreed;
    }
}