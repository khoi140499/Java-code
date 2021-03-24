package bai3;
public class Retangle {
    private double width;
    private double height;
    private String color;
    public Retangle(){
        this.width=this.height=1;
    }
    public Retangle(double width, double height, String color){
        this.width=width;
        this.height=height;
        this.color=color;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public double getWidth(){
        return width;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public double getHeight(){
        return height;
    }
    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    public double fineArea(){
        double dt=this.width*this.height;
        return dt;
    }
    public double findPerimeter(){
        double cv=(this.width+this.height)/2;
        return cv;
    }
}
