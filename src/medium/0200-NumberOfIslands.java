package medium;

//package medium;
//My explanation:
//a very important thing to remember is that its an array of characters, not ints
//so you have to check grid[i][i] == '1', not grid[i][j] == 1
//but for this problem we want to increment the count everytime we encounter a new island
//and islands are any collection of adjacent 1's
//so we'll iterate through the whole array
//whenever we encounter a 1, we'll increment count call a helper method called clearIsland
//this helper method will return/stop if i or j is out of bounds, or if grid[i][j] is a 0
//then the method will set that space to 0, and call clearIsland recursively on all of its adjacent neighbors
//this will turn all the 1's of the island to zero, and once that's done we go back to the main traversal loop and continue
//this is a depth first search, and the memory is based on the call stack I believe because of all the recursive calls
class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void clearIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        clearIsland(grid, i + 1, j);
        clearIsland(grid, i - 1, j);
        clearIsland(grid, i, j + 1);
        clearIsland(grid, i, j - 1);
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','1','0'}
        }));
        System.out.println(numIslands(new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','1'}
        }));
    }
}

//DESCRIPTION
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 

Example 1:

Input: grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output: 1
Example 2:

Input: grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/