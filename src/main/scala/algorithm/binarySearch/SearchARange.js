//https://leetcode.com/problems/search-for-a-range/description/

//i.e given [5, 7, 7, 8, 8, 10] return [3, 4]. cant find return [-1, -1]

findRange = (arr, len, target) => {
    let start = 0;
    let end = len - 1;

    while (start <= end) {
        const mid = Math.floor((start + end) / 2);

        if (arr[mid] === target) {
            let indexStart = mid;
            let indexEnd = mid;

            while(arr[indexStart - 1] === arr[mid]) {
                indexStart --;
            }

            while(arr[indexEnd + 1] === arr[mid]) {
                indexEnd ++;
            }

            return [indexStart, indexEnd];
        } else if (arr[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return [-1, -1];
};