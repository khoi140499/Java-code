package bai11;
public class Bai11 {
    public static void main(String[] args) {
        MyPoint mp1=new MyPoint(0, 0);
        MyPoint mp2=new MyPoint(0, 3);
        MyPoint mp3=new MyPoint(3, 0);
        MyPoint mp=new MyPoint();
        mp.distance(mp1, mp2);
        mp.distance(mp1, mp3);
        mp.distance(mp2, mp3);
        if(mp.distance(mp1, mp2)+mp.distance(mp1, mp3)>mp.distance(mp2, mp3) && mp.distance(mp1, mp2)+mp.distance(mp2, mp3)>mp.distance(mp1, mp3) && mp.distance(mp1, mp3)+
                mp.distance(mp2, mp3)>mp.distance(mp1, mp2)){
            if(mp.distance(mp1, mp2)==mp.distance(mp1, mp3) && mp.distance(mp1, mp3)!=mp.distance(mp2, mp3)||mp.distance(mp1, mp3)==mp.distance(mp2, mp3) && mp.distance(mp2, mp3)!=mp.distance(mp1, mp2)|| mp.distance(mp1, mp2)==mp.distance(mp2, mp3) &&  mp.distance(mp1, mp2)!=mp.distance(mp1, mp3)){
                System.out.println("Tam Giac Can!!!");
            }
            else if(mp.distance(mp1, mp2)==mp.distance(mp1, mp3) && mp.distance(mp1, mp3)==mp.distance(mp2, mp3)){
                System.out.println("Tam Giac Deu!!!");
            }
            else if((mp.distance(mp1, mp2)*mp.distance(mp1, mp2))+(mp.distance(mp1, mp3)*mp.distance(mp1, mp3))==(mp.distance(mp2, mp3)*mp.distance(mp2, mp3)) &&
                    (mp.distance(mp1, mp3)*mp.distance(mp1, mp3))+( mp.distance(mp2, mp3)* mp.distance(mp2, mp3))==(mp.distance(mp1, mp2)*mp.distance(mp1, mp2)) 
                    && (mp.distance(mp1, mp2)*mp.distance(mp1, mp2))+( mp.distance(mp2, mp3)* mp.distance(mp2, mp3))==(mp.distance(mp1, mp3)*mp.distance(mp1, mp3))){
                if(mp.distance(mp1, mp2)==mp.distance(mp1, mp3) && mp.distance(mp1, mp2)==mp.distance(mp2, mp3)
                        &&  mp.distance(mp1, mp3)==mp.distance(mp2, mp3)){
                    System.out.println("Tam Giac Vuong Can!!!");
                }
                else System.out.println("Tam Giac Vuong!!!");
            }
            else {
                 System.out.println("Tam giac thuong!!!");
            }
        }
        else System.out.println("No");
    }
    
}
