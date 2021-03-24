package btlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Btlist {
    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<String>();
        Scanner sc=new Scanner(System.in);
        String s[]={"Thứ 2","Thứ 3","Thứ 4","Thứ 5","Thứ 6","Thứ 7"};
        String s2[]={"Thu 2","Thu 3","Thu 4","Thu 5","Thu 6", "Thu 7"};
        for(int i=0;i<s.length;i++){
             list1.add(s[i]);
        }
        for(int i=0;i<s2.length;i++){
             list2.add(s2[i]);
        }
        for(int i=0;i<list2.size();i++){
            list1.add(list2.get(i));
        }
        for(int i=5;i>=3;i--){
                list1.remove(i);
        }
        System.out.println("List 1: ");
        for(String fd:list1){
            System.out.println(fd+"\t");
        }
        list2.removeAll(list2);
        System.out.println();
        System.out.println("List2: ");
        for(String ad:list2){
            System.out.print(ad+"\t");
        }
        System.out.println("Dao Nguoc danh sach: ");
        for(int i=list1.size()-1;i>=0;i--){
            System.out.println(list1.get(i));
        }
    }
    
}
