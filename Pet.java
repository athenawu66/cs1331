/**
* This class represents a generic pet.
* @author Athena Wu
* @version 1.0
*/
public abstract class Pet {
    private String name;
    private int age;
    private int painLevel;
    /**
    * Constructs a Pet object, taking in a name, age, and
    * pain level.
    * @param name name of the Pet
    * @param age age of Pet
    * @param painLevel level of pain of Pet
     */
    public Pet(String name, int age, int painLevel) {
        this.name = name;
        if (age < 1) {
            this.age = 1;
        } else if (age > 100) {
            this.age = 100;
        } else {
            this.age = age;
        }
        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }
    /**
    * Abstract method that represents this Pet playing with
    * another Pet.
    * @param p other pet that's being played with
     */
    public abstract void playWith(Pet p);
    /**
    * Prints statement regarding Pet object
    * @return string statement regarding Pet object
     */
    public String toString() {
        return "My name is " + name + ", and I am " + age
            + ". On a scale of one to ten my pain level is " + painLevel + ".";
    }
    /**
    * Compares if two Pet objects are equal
    * @return if two Pet objects are equal
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet1 = (Pet) o;
        return (pet1.name.equals(name) && pet1.age == age && pet1.painLevel == painLevel);
    }
    /**
    * Gets name of Pet
    * @return name of Pet
     */
    public String getName() {
        return name;
    }
    /**
    * Gets age of Pet
    * @return age of Pet
     */
    public int getAge() {
        return age;
    }
    /**
    * Get pain level of Pet
    * @return pain level of Pet
    */
    public int getPainLevel() {
        return painLevel;
    }
    /**
    * Set name of Pet
    * @param inputName the new name of Pet
     */
    public void setName(String inputName) {
        name = inputName;
    }
    /**
    * Set age of Pet
    * @param inputAge the new age of Pet
     */
    public void setAge(int inputAge) {
        age = inputAge;
    }
    /**
    * Set pain level of Pet
    * @param inputPainLevel the new pain level of Pet
     */
    public void setPainLevel(int inputPainLevel) {
        painLevel = inputPainLevel;
    }
}