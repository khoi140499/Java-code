
package hocstringbuilder;

public class HocStringBuilder {

    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        sb.append("Xin chào");
        sb.append(" các bạn đến với");
        sb.append(" đến với khóa học java");
        String s=sb.toString();
        System.out.print(s);
        sb.delete(5, 8);
        s=sb.toString();
        System.out.println();
        System.out.println(s);
    }
    
}
