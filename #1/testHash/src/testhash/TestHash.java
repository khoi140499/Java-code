package testhash;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class TestHash {
    public static void main(String[] args) {
        HashMap<Integer, String> map=new HashMap<Integer, String>();
        map.put(1, "Hoang");
        map.put(2, "Dang");
        map.put(3, "Khoi");
        Collection<String> dsten=map.values();
        for(String ten: dsten){
            System.out.println(ten);
        }
        System.out.println();
        Set<Integer> key=map.keySet();
        for(Integer k:key){
            System.out.println(k);
        }
    }
    
}
