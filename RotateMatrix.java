package Basics;

public class RotateMatrix {
    public static void rotate(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR){
            rotateEdge(matrix,tR,tC,dR,dC);
        }

    }
    public static void rotateEdge(int[][] matrix,int tR,int tC,int dR,int dC){
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0;i < times;i++){
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }
    public static void printMatrix(int[][] matrix){
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateEdge(matrix,0,0,matrix.length - 1,matrix[0].length - 1);
        System.out.println("================");
        printMatrix(matrix);
    }
}
