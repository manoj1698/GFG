//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
   //function for checking safe condition
    public static boolean isSafe(int grid[][], int num, int row, int col){
        for(int i=0; i<9; i++){
            if(grid[i][col] == num){
                return false;
            }
            if(grid[row][i] == num){
                return false;
            }
        }
        
        int StartR = (row/3)*3, StartC = (col/3)*3;
        for(int i=StartR; i<=StartR+2; i++){
            for(int j=StartC; j<StartC+3; j++){
                if(grid[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int row = 0, col = 0;
        return helper(grid, row, col);
    }
    
    static boolean helper(int grid[][], int row, int col){
        if(row == 9){
            return true;       
        }
        int NextR = row, NextC = col+1;
        if(col+1 == 9){
            NextR = row+1; NextC = 0;
        }
        
        if(grid[row][col] != 0){
            return helper(grid, NextR, NextC);
        }
        
        for(int i=1; i<=9; i++){
            if(isSafe(grid,i,row,col)){
                grid[row][col] = i;
                if(helper(grid,NextR,NextC)){
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}