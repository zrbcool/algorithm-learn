package src
import (
	"testing"
)

func TestRemoveDuplicates(t *testing.T) {
	var arr = []int{1,2,3}
	result := removeDuplicates(arr)
	t.Log(result)
}