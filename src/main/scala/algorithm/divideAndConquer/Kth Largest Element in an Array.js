/*
https://leetcode.com/problems/kth-largest-element-in-an-array/description/

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
 */


//To ignore performance, sort and find is ez. I wonder is there a way to divide and conquer for this ?
take = (arr, k) => arr.sort((a, b) => a - b)[arr.length - k];