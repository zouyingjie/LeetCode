package main

func lengthOfLongestSubstring(s string) int {

	m := make(map[rune]int)
	maxLength := 0
	start := 0

	for index, value := range s {

		if value, ok :=m[value]; ok && value >= start {
			start = value + 1
		}

		currentLength := index - start + 1
		if currentLength > maxLength {
			maxLength = currentLength
		}
		m[value] = index
	}
	return maxLength
}

func main() {
	
}
