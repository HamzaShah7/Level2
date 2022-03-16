import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] arr;

    public Matrix(int columns, int rows){
        this.columns = columns;
        this.rows = rows;
        arr = new int[rows][columns];
    }

    public void setArr (int[][] arr) {
        this.arr = arr;
    }

    public int[][] getArr () {
        return arr;
    }

    public int getElement(int row,int col){
        return arr[row][col];
    }

    public void setColumns (int columns) {
        this.columns = columns;
    }

    public void setRows (int rows) {
        this.rows = rows;
    }

    public int getColumns () {
        return columns;
    }

    public int getRows () {
        return rows;
    }

    public void setElement(int i,int j, int element){
        arr[i][j]= element;
    }

    public void AddMatrix(Matrix arr1, Matrix arr2){
        if (arr1.getRows ()==arr2.getRows () && arr1.getColumns () == arr2.getColumns ()){
            Matrix M2 = new Matrix (arr1.getRows (),arr1.getColumns ());
            for(int i = 0;i<arr1.getRows ();i++){
                for(int j = 0;j<arr1.getColumns ();j++){
                    M2.setElement (i,j,arr1.getElement (i,j)+arr2.getElement (i,j));
                }
                System.out.print ("\n");
            }
        }

    }

    public void printString () {
        System.out.println("Matrix is :");
        for(int i = 0;i<getRows ();i++){
            for(int j = 0;j<getColumns ();j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.print ("\n");
        }

    }
    public static void main (String[] args) {
        Matrix M = new Matrix (4,5);
        for (int row = 0; row < M.getRows (); row++) {
            for (int col = 0; col < M.getColumns (); col++) {
                M.setElement (row,col,row*col);
            }
        }
        Matrix M1 = new Matrix (4,5);
        for (int row = 0; row < M.getRows (); row++) {
            for (int col = 0; col < M.getColumns (); col++) {
                M.setElement (row,col,row*col);
            }
        }
        M.printString ();
        M1.printString ();
    }
}
