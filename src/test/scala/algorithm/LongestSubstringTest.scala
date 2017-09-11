package algorithm

import infrastructure.BaseTableDrivenTest

class LongestSubstringTest extends BaseTableDrivenTest {

  val table = Table(
     ("String",     "Expected"),

    ("abcabcbb",     3),
    ("bbbbb",        1),
    ("pwwkew",       3)
  )

  test("should get longest substring without repeating characters") {
    forAll(table)((s: String, expected: Int) => {
      LongestSubstring(s) should equal(expected)
    })
  }
}

