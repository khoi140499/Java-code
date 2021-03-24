package bai11;

import java.util.Scanner;

public class LoiBienDich {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=a/b;
		try {
			b=sc.nextInt();
					throw new Exception("Mau Bang khong Loi");
				}catch (Exception e) {
					e.getMessage();
				}
			}

	}

