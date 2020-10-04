# Background

Backtracking is a `depth-first search` algorithm which explores one branch to a possible solution before moving on to another branch. It is arguably a type of brute force method that could be very practical as an effective implementation for solving [Sudoku](https://en.wikipedia.org/wiki/Sudoku_solving_algorithms#Backtracking) puzzles.

![](https://upload.wikimedia.org/wikipedia/commons/8/8c/Sudoku_solved_by_bactracking.gif)

As shown in the above illustration _gif_, it brute forces by visiting the empty cells in some order, filling in digits sequentially, or backtracking when the number is found to be not valid. It checks if there is any violation (row, column and box contraints), then advances to the next cell.

## Pros and Cons

This algorithm is relatively **simple**, and a solution to any valid Sudoku problem is **guaranteed**. However, the solving time is relatively too slow compared to other algorithms that implements `deductive` method.

# Java Implementation

Two major functionalities built is: `isValid()` and `solve()`, where the first one would call its helper functions to check any constraints violation, and the latter contains the backtracking algorithm that heavily depends on `isValid()` return value.

![](./sudoku.gif)