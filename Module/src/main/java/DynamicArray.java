import java.util.Arrays;

//object that grows as the amount of objects in the array increase
public class DynamicArray {

    private int[] list;
    private int live = 0;

    //constructor in order to create the object
    public DynamicArray(int[] list, int live){
        this.list  = list;
        this.live = live;
    }

    //checks that the objects are exactly the same
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (!(a instanceof DynamicArray other)) {
            return false;
        }
        return this.live == other.live && Arrays.equals(this.list, other.list);
    }

    //creates an empty DynamicArray
    public DynamicArray empty(){
        return new DynamicArray(new int[4], 0);
    }

    //checks that they have the same sequence of integers regardless of size
    public boolean equalElts(DynamicArray compare){
        if (this.live != compare.live) {
            return false;
        }
        for (int i = 0; i < this.live; i++) {
            if (this.list[i] != compare.list[i]) {
                return false;
            }
        }
        return true;
    }

    //gets teh value at a certain index of the list
    public int get(int i){
        return list[i];
    }

    //the number of elements in the list
    public int length(){
        return live;
    }

    //changes a value at a certain index in the list to a new value
    public void set(int i, int value){
        list[i] = value;
    }

    //insert a value at a certain point in the list while keeping all the other values in the list
    public void insert(int i, int a){
        if (live == list.length){
            list = Arrays.copyOf(list, list.length*2);
            for (int j = live; j > i; j--) {
                list[j] = list[j - 1];
            }
            list[i] = a;
            live++;
        } else {
            for (int j = live; j > i; j--) {
                list[j] = list[j - 1];
            }
            list[i] = a;
            live++;
        }
    }

    //add a value to the end of the list
    public void addToEnd(int a){
        insert(live, a);
    }

    //add a value to the beginning of the list
    public void addToStart(int a){
        insert(0, a);
    }

    //remove a value at a certain index of the list
    public void remove(int i){
        for (int j = i; j < live - 1; j++) {
            list[j] = list[j + 1];
        }
        live--;
    }

}

/*
1. Array lists can hold anything in them while our lists can only hold ints
2. ArrayLists start with an automatic capcity of 10 while ours do not
3. has a trimToSize mehtod that cuts the ArrayList don to current size while
our list can never gat smaller
 */