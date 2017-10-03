//https://leetcode.com/problems/search-in-rotated-sorted-array/description/

//give kind sorted array 4 5 6 7 0 1 2
//find item index and return -1 if not found

find = (arr, target) => {
    const length = arr.length;
    let start = 0;
    let end = length - 1;

    while ( start <= end ) {
        const mid = Math.floor((start + end) / 2);
        if (arr[mid] === target) {
            return mid;
        } else if (arr[start] <= arr[mid] ) { //execute if left side is sorted
            if (arr[start] <= target && target < arr[mid]  ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else { //otherwise right side must be sorted
            if ( arr[mid] < target && target <= arr[end] ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return -1;
};