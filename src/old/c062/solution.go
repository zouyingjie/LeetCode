package main


func uniquePaths(m int, n int) int {
	if (m == 0 || n == 0) {
		return 0;
	}
	if (m == 1 || n == 1) {
		return 1;
	}

	grid := [][]int;
	for i := 0; i < n; i++  {
		for j := 0; i < m; j ++ {
			grid[i][j] = 0;
		}
	}
	return helper(n - 2, m-1) + helper(n-1, m - 2);
}

func helper(x, y int, grid [][]int)  int{
	if (x == 0 && y == 0) {
		return 1;
	}

	if (x < 0 || y < 0) {
		return 0;
	}
	if (grid[x][y] == 0) {
		sum := helper(x - 1, y, &grid) + helper(x, y - 1, &grid);
		grid[x][y] = sum
	}
	return grid[x][y];
}
