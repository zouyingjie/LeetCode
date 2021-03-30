package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {

	result := &ListNode{Val: 0}
	tail := result
	isopsephy := 0

	for ; l1 != nil && l2 != nil; {

		val1 := 0
		val2 := 0

		if l1 != nil {
			val1 = l1.Val
		}

		if l2 != nil {
			val2 = l2.Val
		}

		sum := val1 + val2 + isopsephy

		if sum >= 10 {
			sum = sum % 10
			isopsephy = 1
		} else {
			isopsephy = 0
		}
		tail.Val = sum

		if l1 != nil {
			l1 = l1.Next
		}

		if l2 != nil {
			l2 = l2.Next
		}
		if l1 == nil && l2 == nil {
			if isopsephy > 0 {
				tail.Next = &ListNode{Val: isopsephy}
				tail = tail.Next
			}
			break
		}

		tail.Next = &ListNode{Val: 0}
		tail = tail.Next

	}

	return result
}

func addTwoNumbers2(l1 *ListNode, l2 *ListNode) *ListNode {

	result := &ListNode{}
	tail := result
	carry := 0
	for ; ; {
		sum := l1.Val + l2.Val + carry

		if sum >= 10 {
			sum = sum % 10
			carry = 1
		} else {
			carry = 0
		}

		tail.Val = sum
		l1 = l1.Next
		l2 = l2.Next

		if l1 != nil && l2 != nil {
			tail.Next = &ListNode{}
			tail = tail.Next
		} else {
			break
		}
	}

	var remainingList *ListNode
	if l1 != nil {
		remainingList = l1
	} else if l2 != nil {
		remainingList = l2
	}

	for ; remainingList != nil; {
		tail.Next = &ListNode{}
		tail = tail.Next
		sum := remainingList.Val + carry

		if sum >= 10 {
			sum = sum % 10
			carry = 1
		} else {
			carry = 0
		}

		tail.Val = sum
		remainingList = remainingList.Next
	}

	if carry > 0 {
		tail.Next = &ListNode{Val: carry}
	}

	return result

}

func main() {
	l1 := &ListNode{Val: 1}
	l1.Next = &ListNode{Val: 8}

	l2 := &ListNode{Val: 0}
	addTwoNumbers2(l1, l2)
}
