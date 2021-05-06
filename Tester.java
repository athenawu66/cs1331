public class tester{
    private int age;
    private String major;
    private String housingLocation;
    public tester(int age, String major, String housingLocation){
        this.age = age;
        this.major = major;
        this.housingLocation = housingLocation;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public void setMajor(String newMajor){
        this.major = newMajor;
    }

    public void setHousingLocation(String newHousingLocation){
        this.housingLocation = newHousingLocation;
    }

    public String getMajor(){
        return this.major;
    }
   
}