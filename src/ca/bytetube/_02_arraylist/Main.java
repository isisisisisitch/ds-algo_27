package ca.bytetube._02_arraylist;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }


        System.out.println( arrayList.remove(5));
        System.out.println(arrayList.set(5,5));
        System.out.println(arrayList.get(5));
        System.out.println(arrayList.set(1,null));
        System.out.println(arrayList.indexOf(null));
        System.out.println(arrayList.contains(5));


    }
}
