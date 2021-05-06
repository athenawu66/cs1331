/**
* This class represents an interface that guarantees that an object is Treatable
* @author Athena Wu
* @version 1.0
*/
public interface Treatable {
    /**
    * method that needs to be implemented by every class that implements
    *Treatable and should improve the condition of the object
    */
    void treat();
    /**
    * returns the dog's age in human years
    * @return humanAgeFinal, or the dog's age in human years
    * @param dogAge the age of the dog
    */
    static int convertDogToHumanYears(int dogAge) {
        float humanAge = 9 * (float) Math.log(dogAge) + 31;
        int humanAgeFinal = (int) humanAge;
        return humanAgeFinal;
    }
    /**
    * returns the cat's age in human years
    * @return humanAgeFinal, or the age of the cat in human years
    * @param catAge age of the cat
    */
    static int convertCatToHumanYears(int catAge) {
        float humanAge = 9 * (float) Math.log(catAge) + 18;
        int humanAgeFinal = (int) humanAge;
        return humanAgeFinal;
    }
}