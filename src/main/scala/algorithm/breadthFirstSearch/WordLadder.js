/*
https://leetcode.com/problems/word-ladder-ii/description/

For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]

 */

take = (beginWord, endWord, wordList) => {
    const len = wordList.length;
    let result = [];
    findMatched(beginWord, endWord, 0, wordList, len, [beginWord], result);

    return result;
};

findMatched = (currentWord,
               endWord,
               j,
               wordList,
               length,
               acc,
               result) => {
    if (currentWord === endWord) {
        //find the smallest path I hate this branch btw...
        if (result.length > 0) {
            if (acc.length < result[0].length) {
                while(result[0]) {
                    result.shift();
                }
                result.push(acc);
            } else if (acc.length === result[0].length) {
                result.push(acc);
            }
        } else {
            result.push(acc);
        }
        return;
    }
    for (let i = j; i < length; i++) {
        if (diffByOne(currentWord, wordList[i])) {
            findMatched(wordList[i], endWord, i, wordList, length, acc.concat(wordList[i]), result);
        }
    }
};

diffByOne = (word, wordToCompare) => {
    let count = 0;
    const len = word.length;
    if (len !== wordToCompare.length) {
        return false;
    }

    for (let i = 0; i < len; i++) {
        if (word[i] !== wordToCompare[i]) {
            count++;
        }
        if (count > 1) {
            return false;
        }
    }

    return count !== 0;
};