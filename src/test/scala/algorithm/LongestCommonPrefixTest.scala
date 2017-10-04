package algorithm

import algorithm.basic.LongestCommonPrefix
import infrastructure.BaseTableDrivenTest

class LongestCommonPrefixTest extends BaseTableDrivenTest {

  val table = Table(
    ("String List",                                        "Expected"),

    (List("test", "tea"),                                   "te"),
    (List("abcd", "abc", "abcde"),                         "abc"),
    (List("abcd", "a", "abc"),                             "a")
  )

  test("should ") {
    forAll(table)((strList: List[String], expected: String) => {
        LongestCommonPrefix(strList) should equal(expected)
    })
  }
}

