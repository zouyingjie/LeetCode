package main

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for index, value := range nums{
		num := target - value
		if _, ok := m[num]; ok {
			return []int{m[num], index}
		}
		m[value] = index
	}
	return nil
}
