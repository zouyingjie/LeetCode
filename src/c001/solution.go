package main

import "fmt"

func twoSum(nums []int, target int) []int {
    
    a := make(map[int]int)

    result := []int{0, 0}

    for index, num := range nums {
        if _, ok := a[target - num]; ok {
            result[0] = a[target - num]
            result[1] = index
            return result
        }
        a[num] = index
    }
    return nil

}

func main() {

    nums := []int {2, 7, 11, 15}
    target := 9
    sum := twoSum(nums, target)

    fmt.Println(sum)
}