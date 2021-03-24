package tets2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tets2 {
    public static void main(String[] args) {
        ArrayList<as> ar=new ArrayList<>();
        ar.add(new as(18, "Hoang Dang Khoi", "A"));
        ar.add(new as(16, "An Quang Ngoc", "A"));
        ar.add(new as(19, "Dinh The Vinh", "C"));
        ar.add(new as(18, "Dinh The Vinh", "C"));
        ar.add(new as(17, "Dinh The Vinh", "D"));
        ar.add(new as(17, "Dinh The Vinh", "D"));
        ar.add(new as(18, "Dinh The Vinh", "C"));
        ar.add(new as(18, "Dinh The Vinh", "A"));
        ar.add(new as(16, "Dinh The Vinh", "A"));
        ar.add(new as(19, "Dinh The Vinh", "D"));
        ar.add(new as(16, "Dinh The Vinh", "D"));
        ar.add(new as(19, "Dinh The Vinh", "A"));
        ar.add(new as(18, "Dinh The Vinh", "A"));
        ar.add(new as(11, "Dinh The Vinh", "C"));
        ar.add(new as(11, "Dinh The Vinh", "D"));
        ar.add(new as(12, "Dinh The Vinh", "B"));
        ar.add(new as(12, "Dinh The Vinh", "B"));
        ar.add(new as(18, "Dinh The Vinh", "A"));
        ar.add(new as(19, "Dinh The Vinh", "B"));
        Comparator<as> com=new Comparator<as>() {
            @Override
            public int compare(as o1, as o2) {
               if(o1.getId()!=o2.getId())
                   return o1.getId().compareTo(o2.getId());
            return o1.getTen().compareTo(o2.getTen());
                    }
        };
        Collections.sort(ar, com);
        for(as a:ar)
            System.out.println(a.toString());
    }   
}