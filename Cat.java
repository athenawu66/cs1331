/**
* This class represents a Cat object
* @author Athena Wu
* @version 1.0
*/
public class Cat extends Pet implements Treatable {
    private boolean hasStripes;
    /**
    * Creates a Cat object using hasStripes
    * @param hasStripes whether or not the Cat object has stripes
    */
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }
    /**
    * Creates a Cat object using name, age, painLevel, and hasStripes
    * @param name name of the Cat object
    * @param age age of the Cat object
    * @param painLevel level of pain of the Cat object
    * @param hasStripes whether or not the Cat has stripes
    */
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }
    /**
    * Creates a method that allows a Cat object to play with another pet
    * @param p Pet object that the cat can play with
    */
    public void playWith(Pet p) {
        int oldPainLevel = super.getPainLevel();
        if (p instanceof Cat) {
            if (((Cat) p).getHasStripes() && hasStripes || (!(((Cat) p).getHasStripes()
                    && hasStripes))) {
                int newPainLevel = super.getPainLevel() - 4;
                super.setPainLevel(newPainLevel);
            } else {
                int newPainlevel = oldPainLevel - 2;
                super.setPainLevel(newPainlevel);
            }
            System.out.println("Meow! I love playing with other cats with the same pattern as me");
        } else if (p instanceof Dog) {
            int newPainLevel = oldPainLevel + 1;
            System.out.println("Meow. Go away " + p.getName() + "! I don't like playing with Dogs!");
        }
    }
    /**
    * reduces pain level by 3
    */
    public void treat() {
        int oldPainLevel = super.getPainLevel();
        int newPainLevel = oldPainLevel - 1;
        super.setPainLevel(newPainLevel);
    }
    @Override
    public String toString() {
        return "My name is " + super.getName() + ", and I am " + super.getAge()
            + ". On a scale of one to ten my pain level is " + super.getPainLevel() + ". My age in human years is "
            + Treatable.convertCatToHumanYears(super.getAge()) + ".";
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat)) {
            return false;
        }
        Cat cat1 = (Cat) o;
        return (super.equals(cat1) && cat1.hasStripes == hasStripes);
    }
    /**
    * method that gets hasStripes
    * @return hasStripes
    */
    public boolean getHasStripes() {
        return hasStripes;
    }
    /**
    * method that provides hasStripes with a new value
    * @param newHasStripes the new value as to whether or not the Cat
    * object has stripes
    */
    public void setHasStripes(boolean newHasStripes) {
        hasStripes = newHasStripes;
    }
}