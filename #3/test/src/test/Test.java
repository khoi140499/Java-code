package test;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> name=Arrays.asList("Khoi", "Khanh", "Ngoc");
        name.stream().filter(s -> s.startsWith("K")).forEach(System.out::println);
    }
    
}
