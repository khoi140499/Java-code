package giaiphuongtrinhbac2ui;
public class main {
    private float a;
    private float b;
    private float c;

    public main(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public String main(){
        String kq="";
        if(this.a==0){
            if(this.b==0){
                if(c==0){
                    kq="Vo so nghiem";
                }
                else{
                    kq="Vo nghiem";
                }
            }
            else{
                kq="X="+(-this.c/this.b);
            }
        }
        float delta=(this.b*this.b-4*this.a*this.c);
        if(delta>0){
            float x1=(float)(-this.b-Math.sqrt(delta))/(2*this.a);
            float x2=(float)(-this.b+Math.sqrt(delta))/(2*this.a);
            kq="x1= "+x1+" ; x2= "+x2;
        }
        else if(delta==0){
            kq=" "+-b/(2*a);
        }
        else{
            kq="Vo nghiem";
        }
        return kq;
    }
}
