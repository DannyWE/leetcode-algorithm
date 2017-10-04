package algorithm

import dataStructure.hashtable.LongestPalindrome
import infrastructure.BaseTableDrivenTest

class LongestPalindromeTest extends BaseTableDrivenTest {

  val table = Table(
     ("String",                                                "Expected"),

     ("babad",                                                 "bab"),
     ("cbbd",                                                  "bb"),
     ("abcdefcghttabt",                                        "cdefc")
  )

  test("should find longest palindrome sub string") {
    forAll(table)((str: String, expected: String) => {
        LongestPalindrome(str) should equal(expected)
    })
  }
}

