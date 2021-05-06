/**
* This class represents a Vet object
* @author Athena Wu
* @version 1.0
 */
public class Vet {
    /**
    * Method that prints to toString method of the pet
    * @param pet the pet that is being passed into the method
     */
    public static void inspectPet(Pet pet) {
        if (pet instanceof Cat) {
            ((Cat) pet).toString();
        } else if (pet instanceof Dog) {
            ((Dog) pet).toString();
            ((Dog) pet).bark();
        } else if (pet instanceof Narwhal) {
            ((Narwhal) pet).toString();
        }
    }
    /**
    * Method that accepts a Pet object and performs corresponding actions depending on the Pet
    * @param pet the pet that's being passed in
     */
    public static void treatPet(Pet pet) {
        if (pet instanceof Dog) {
            System.out.println("Welcome to the vet " + ((Dog) pet).getName());
            ((Dog) pet).treat();
            System.out.println("Wow what a cute dog!");
            giveDogTreat(((Dog) pet)); //why would this work? wouldn't it not cast because pet is a Pet and not
                //all Pet are Dog?
        } else if (pet instanceof Cat) {
            System.out.println("Welcome to the vet " + ((Cat) pet).getName());


        }
    }
    /**
    * Method that decreases the dog's pain by 2
    * @param dog the Dog object being passed in.
     */
    public static void giveDogTreat(Dog dog) {
        int newPainLevel = dog.getPainLevel() - 2;
        dog.setPainLevel(newPainLevel);
    }
}