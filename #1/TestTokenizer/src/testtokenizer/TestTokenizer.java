/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtokenizer;

import java.util.StringTokenizer;

/**
 *
 * @author khoi
 */
public class TestTokenizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1="Obama Putin Un";
        StringTokenizer token1=new StringTokenizer(s1);
        while(token1.hasMoreTokens()){
            String value=token1.nextToken();
            System.out.println(value);
        }
        System.out.println("---------");
        String s2=("Obama;Putin;Un!Kim Jun");
        StringTokenizer token2=new StringTokenizer(s2,";! ");
        while(token2.hasMoreTokens()){
            String value=token2.nextToken();
            System.out.println(value);
        }
    }
    
}
