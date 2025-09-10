import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void test() {
        IList<Integer> list = new MyLinkedList<>();
        System.out.println(list.size());
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(5);
        list.add(null);
        list.add(7);
        System.out.println(list.size());
        System.out.println(list.get(4));
        int index = list.indexOf(null);
        System.out.println(index);
        index = list.indexOf(7);
        System.out.println(index);
        System.out.println(list.contains(3));
        System.out.println(list.contains(0));
        System.out.println(list.set(3, 55));
        System.out.println(list.get(3));
        System.out.println("==================");
        System.out.println(list.size());
        int num = list.remove(2);
        System.out.println(list.size());
        System.out.println(num);
        System.out.println("==================");
        System.out.println(list.remove((Integer)2));
        System.out.println(list.size());
        for (Integer n : list) {
            System.out.println(n);
        }
        System.out.println("======== List of String ==========");
        IList<String> myList = new MyLinkedList<>();
        myList.add("Boston");
        myList.add("Atlanta");
        myList.add("Chicago");
        myList.add("Boston");
        myList.add("New York");
        System.out.println(myList.size());
        System.out.println(myList.get(3));
        System.out.println(myList.indexOf("Boston"));
        System.out.println(myList.remove(0));
        System.out.println(myList.size());
        System.out.println(myList.remove("Boston"));
        System.out.println(myList.contains("Boston"));
        System.out.println(myList.add(2, "Boston"));
        System.out.println(myList.size());
        System.out.println(myList.get(2));
        for (String str : myList) {
            System.out.println(str);
        }
        myList.clear();
        System.out.println(myList.size());
    }

}