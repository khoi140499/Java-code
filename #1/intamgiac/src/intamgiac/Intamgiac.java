package intamgiac;

import java.util.Scanner;

public class Intamgiac {
    public static void hinhvuong(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hinhvuongrong(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void hinhchunhat(int n, int m){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hinhchunhatrong(int n, int m){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1||i==n||j==1||j==m) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void tamgiaccan(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(j==i||j==1||i==n||i==1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void tamgiac2(int n){
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                if(j==i||j==n||i==n||i==1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void tamgiac3(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                
            }
            for(int k=1;k<=i;k++) System.out.print(k);
            System.out.println();
        }
    }
    public static void tamgiac4(int n){
          for(int i=1;i<=n;i++){
              for(int j=1;j<=(2*n-1);j++){
                  if(j>=(n-i+1) && j<=(n+i-1)){
                      System.out.print("*");
                  }
                  else{
                      System.out.print(" ");
                  }
              }
              System.out.println();
          }
    }
    public static void tamgiac5(int n){
          for(int i=1;i<=n;i++){
              for(int j=i;j<=n;j++){
                  System.out.print(" ");
              }
              for(int k=1;k<=i;k++){
                  System.out.print(k);
              }
              for(int l=i-1;l>0;l--){
                  System.out.print(l);
              }
              System.out.println();
          }
    }
    public static void tamgiac6(int n){
          for(int i=1;i<=n;i++){
              for(int j=1;j<=(2*n-1);j++){
                  if(j==(n-i+1)||j==(n+i-1)||i==n){
                      System.out.print("*");
                  }
                  else{
                      System.out.print(" ");
                  }
              }
              System.out.println();
          }
    }
    public static void tamgiac7(int n){
          for(int i=1;i<=n;i++){
              for(int j=1;j<=i;j++){
                      if(j==1||j==i||i==n){
                          System.out.print("*");
                      }
                      else System.out.print(" ");
              }
              System.out.println();
          }
    }
     public static void tamgiac8(int n){
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
     public static void tamgiac9(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
     public static void tamgiac10(int n){
          for(int i=1;i<=n;i++){
              for(int j=1;j<=i;j++){
                          System.out.print(" ");
                      }
              for(int j=1;j<=(n*2-(i*2-1));j++){
                  System.out.print("*");
              }
              System.out.println();
          }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        hinhvuong(n);
        System.out.println("------------------");
        hinhvuongrong(n);
        System.out.println("------------------");
        hinhchunhat(n,m);
        System.out.println("------------------");
        hinhchunhatrong(n,m);
        System.out.println("------------------");
        tamgiaccan(n);
        System.out.println("------------------");
        tamgiac2(n);
        System.out.println("------------------");
        tamgiac3(n);
        System.out.println("------------------");
        tamgiac4(n);
        System.out.println("------------------");
        tamgiac5(n);
        System.out.println("------------------");
        tamgiac6(n);
        System.out.println("------------------");
        tamgiac7(n);
        System.out.println("------------------");
        tamgiac8(n);
        System.out.println("------------------");
        tamgiac9(n);
        System.out.println("------------------");
        tamgiac10(n);
       }
    }
