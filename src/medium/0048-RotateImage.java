package medium;

//to run these things you do javac filename in the folder, in medium in this case
//then cd back to src and do java medium/className

//package medium;
//My explanation:
//so the key to solving this problem is understanding the ways that we can manipulate the image
//we can invert it vertically or horizontally, and most importantly, we can do whats called transposing it
//this is why I couldnt solve it initially, because I couldnt think of this way to manipulate the array
//it's basically swapping the i and j values, if that makes sense, which in effect will mirror the array
//along the diagonal, which makes sense, 0,0 1,1 2,2 3,3 those values wouldnt change since i and j are the same
//so to rotate 90 degrees we simply transpose then flip horizontally
//and we can do different kinds of rotations and expand upon this problem by just doing different combinations of those base actions

import java.util.Arrays;

class RotateImage {

    public static int[][] rotate(int[][] grid) {
        //I think it's bad practice to manipulate the input parameter directly but whatever for now I'm short on time
        //good practice would say like int[][] result = grid and use and return result but yeah another day we'll do that
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[i][N - 1 - j];
                grid[i][N - 1 - j] = temp;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[][] {
            {1,2,3},{4,5,6},{7,8,9}
        })));//figure out how to properly print the array, that would be a fun function to make actually
        //yeah make a print2DArray function later
    }
}

//DESCRIPTION
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/