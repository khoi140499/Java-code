package bai12;
public class MaTran {
    private float a[][];
    private int rows;
    private int cols;

    public MaTran() {
        this.rows=this.cols=3;
        a=new float[3][3];
    }
    public MaTran(float[][] a, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        a=new float[rows][cols]
    }
    public float[][] getA() {
        return a;
    }
    public void setA(float[][] a) {
        this.a = a;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getCols() {
        return cols;
    }
    public void setCols(int cols) {
        this.cols = cols;
    }
    public void add(MaTran m){
        float tong;
        if(this.getCols()!=m.getRows()){
            System.err.println();
        }
        else{
            for(int i=0;i<this.rows;i++){
                for(int j=0;j<this.cols;j++){
                    for(int l=0;l<m.rows;l++){
                        tong=tong + m.a
                    }
                }
            }
        }
    }
}
