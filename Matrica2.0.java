package Matematikë;

import javax.swing.*;
import java.util.Arrays;
import java.util.Observable;

public class Matrica {
    public int columnSize;
    public int rowSize;
    double [][] matrix;
    double [][] MATRICA_FILLESTARE;
    boolean minorRunning = false;
    double indexI;
    double indexJ;
    double rez;
    int ranguMatricesFillestare;
    boolean ok = true;
    int counterOfRang = 1;


    public Matrica(int rowSize, int columnSize) {
        setSize(rowSize, columnSize);
    }


    /**
     * setSize eshte metode qe vendos gjatesine e kolonave dbe rreshtave.
     * Në qoftë se parametrat janë negativ, atëherë metoda bën throw IllegalArgumentException
     * @param rowSize
     * @param columnSize
     */
    public void setSize (int rowSize, int columnSize) {
        if (rowSize > 0 && columnSize > 0) {
            this.rowSize = rowSize;
            this.columnSize = columnSize;
            matrix = new double[rowSize][columnSize];

        }
        else {
            throw new IllegalArgumentException("Matrica duhet t'ketë dimensionet pozitive");
        }
    }


    public void lexoElementet() {
        if (!minorRunning){
            MATRICA_FILLESTARE = new double[rowSize][columnSize];
            ranguMatricesFillestare = columnSize;
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                String input = JOptionPane.showInputDialog("Termi (" + (i+1) + ", " + (j+1) + "):");
                if (input != null) {
                    matrix[i][j] = Double.parseDouble(input);
                    if (!minorRunning) {
                        MATRICA_FILLESTARE[i][j] = Double.parseDouble(input);
                    }
                }
                else {
                    System.out.println("Sistemi u mbyll");
                    System.exit(0);
                }
            }
        }
        minorRunning = true;
    }

    public void printoMatricen() {
        System.out.print("{");
        boolean firstRow = true;

        for(int i = 0; i < rowSize; i++) {
            if (firstRow) {
                System.out.print("{");
                firstRow = false;
            }
            else {
                System.out.print(", \n {");
            }
            boolean firstCol = true;
            for (int j = 0; j < columnSize; j++) {
                String vlera = "" + matrix[i][j];
                if (firstCol){
                    firstCol = false;
                }
                else {
                    System.out.print(", ");
                }
                System.out.print(vlera);
            }
            System.out.print("}");
        }
        System.out.print("}");
    }


    public void Sarusit(Matrica m) {
        if (m.rowSize == 3 && m.columnSize == 3) {
            double rez1 = matrix[0][0] * matrix[1][1] * matrix[2][2];
            double rez2 = matrix[0][1] * matrix[1][2] * matrix[2][0];
            double rez3 = matrix[0][2] * matrix[1][0] * matrix[2][1];
            double rez4 = matrix[0][1] * matrix[1][0] * matrix[2][2];
            double rez5 = matrix[0][0] * matrix[1][2] * matrix[2][1];
            double rez6 = matrix[0][2] * matrix[1][1] * matrix[2][0];
            double rez = rez1 + rez2 + rez3 - rez4 - rez5 - rez6;
            System.out.println();
            System.out.print("Me metodën e Saurusit: ");
            System.out.println("D = " + rez);
        }
        else {
            JOptionPane.showMessageDialog(null, "Numri i rreshtave dhe i kolonave duhet të jetë i barabartë me 3");
        }
    }

    public double metodaETrekendeshit (Matrica m) {
        if (m.rowSize == 3 && m.columnSize == 3) {
            double rez1 = matrix[0][0] * matrix[1][1] * matrix[2][2];
            double rez2 = matrix[0][2] * matrix[1][0] * matrix[2][1];
            double rez3 = matrix[2][0] * matrix[0][1] * matrix[1][2];
            double rez4 = matrix[0][2] * matrix[1][1] * matrix[2][0];
            double rez5 = matrix[0][0] * matrix[1][2] * matrix[2][1];
            double rez6 = matrix[2][2] * matrix[0][1] * matrix[1][0];
            double rez = rez1 + rez2 + rez3 - rez4 - rez5 - rez6;
            return rez;
        }
        else {
            JOptionPane.showMessageDialog(null, "Numri i rreshtave dhe i kolonave duhet të jetë i barabartë me 3");
            return -1;
        }
    }




    public double metodaEMinoreve (Matrica m) {
        if (m.rowSize != m.columnSize) {
            System.out.println("Sistemi u mbyll");
            System.exit(0);
        }
        if (m.rowSize == 3) {
            return metodaETrekendeshit(m);
        }

        Matrica temp = new Matrica(ranguMatricesFillestare - counterOfRang, ranguMatricesFillestare - counterOfRang);


        if (minorRunning && m.rowSize != 3) {
            matrix = putValuesWithArray(temp);
        }


        if (ok) {
            ok = false;
            for (int j = 0; j < m.rowSize; j++) {
                indexI = 0;
                indexJ = j;
                metodaEMinoreve(m);
                rez = rez + MATRICA_FILLESTARE[0][j] * Math.pow(-1, j+2) * metodaEMinoreve(temp);
                m = new Matrica(ranguMatricesFillestare, ranguMatricesFillestare);
            }

        }


        return rez;
    }

    public double[][] putValuesWithArray(Matrica m) {
        int u = 0;
        int v = 0;
//        System.out.println("indexI: " + indexI);
//        System.out.println("indexJ1: " + indexJ);



        for (int i = 0; i <ranguMatricesFillestare; i++) {
            v=0;
            for (int j = 0; j < ranguMatricesFillestare; j++) {
                if (i != indexI && j != indexJ){
                        m.matrix[u][v] = MATRICA_FILLESTARE[i][j];
                        v++;
                }
            }
            if(i != indexI) {
                u++;
            }

        }

        return m.matrix;
    }





}
