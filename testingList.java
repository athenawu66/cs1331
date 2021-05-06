public class testingList{
    public static void main(String args[]){
        LinkedList<String>names = new LinkedList<String>();
        names.addAtIndex("CS_SUCKS",0);
        names.addAtIndex("Help",1);
        names.addAtIndex("hate",1);
        names.addAtIndex("a",3);
        //names.addAtIndex("frick",4);
        System.out.println(names.toArrayList());
        //names.removeFromIndex(400);
        //names.removeFromIndex(0);
        //names.removeFromIndex(0);
        //names.removeFromIndex(1);
        System.out.println(names.toArrayList());
        names.toTheFront("hate");
        System.out.println(names.toArrayList());
        //names.toTheFront("j");
        System.out.println(names.accessMiddle());
        System.out.println(names.get(1));
        LinkedList<String>athena = new LinkedList<String>();
        athena.addAtIndex("help",0);
        System.out.println(athena.accessMiddle());
        System.out.println(athena.removeFromIndex(0));
        System.out.println(athena.accessMiddle());


    }
}