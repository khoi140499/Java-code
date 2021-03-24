package setinterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SetInterface {
    public static void main(String[] args) {
        Set<Integer> hs=new HashSet<>();
        hs.add(41);
        hs.add(32);
        hs.add(67);
        hs.add(11);
        hs.add(23);
        hs.add(9);
        hs.add(78);
        Set<Integer> hsa=new TreeSet<>();
        hsa.add(41);
        hsa.add(32);
        hsa.add(67);
        hsa.add(11);
        hsa.add(23);
        hsa.add(9);
        hsa.add(78);
        List<Integer> li=new ArrayList<>();
        li.add(24);
        li.add(12);
        li.add(78);
        li.add(56);
        Set<Integer> j=new HashSet<>(li);
        System.out.println("Danh sách dùng HashSet: ");
        for(Integer a:hs){
            System.out.println(a);
        }
        System.out.println();
        System.out.println("Danh sách dùng TreeSet: ");
        for(Integer b:hsa){
            System.out.println(b);
        }
        System.out.println();
        System.out.println("---------------");
            System.out.println(j);
        Set<Integer> q=new TreeSet<>();
        Set<Integer> w=new HashSet<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        w=q.stream().filter(number -> number % 2 == 0).collect(Collectors.toSet());
        for(Integer f:w){
            System.out.println(f);
        }
    }
    
}
