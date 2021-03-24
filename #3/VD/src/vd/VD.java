package vd;

import java.util.stream.*;
import java.util.*;

public class VD {
    public static void main(String[] args) {
         List<Vd1> list = new ArrayList<Vd1>();
        list.add(new Vd1("1726", "John Easton", "Lancaster"));
        list.add(new Vd1("4321", "Max Carrados", "London"));
        list.add(new Vd1("2234", "Andrew Lewis", "Lancaster"));
        list.add(new Vd1("5223", "Michael Benson", "Leeds"));
        list.add(new Vd1("5225", "Sanath Jayasuriya", "Leeds"));
        list.add(new Vd1("7765", "Samuael Vatican", "California"));
        list.add(new Vd1("3442", "Mark Farley", "Ladykirk"));
        list.add(new Vd1("3443", "Alex Stuart", "Ladykirk"));
        list.add(new Vd1("4321", "Michael Stuart", "California"));

       List<Vd1> loc = list.stream().filter(st -> st.getLocation().equalsIgnoreCase("Lancaster")).collect(Collectors.toList());
        System.out.println("London "+loc.toString());
    }
}
