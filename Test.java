public class Test{
    private double length, width;
    public Test(double length, double width){
        length = length;
        width = width;
    }
    public static void main(String[] args){
        Test newTest = new Test(20.21, 13.31);
        System.out.print(newTest.length);
    }
} 

//public void reverse(String[] arr){
   // int length = arr.length;
    //String[] newArray = new String[length]];
    //int subtractValue = 1;
    //for (int i = 0; i < arr.length; i++){
      //  newArray[length-subtractValue] = arr[i];
        //subtractValue=subtractValue-1;
    //}
//}