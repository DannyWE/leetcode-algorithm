package algorithm.basic

object Atoi {
  def apply(s: String): Int = {
    val str = s.trim
    if (str.length < 1) return 0

    // trim white spaces
    var flag = '+'

    // check negative or positive
    var i = 0
    if (str(0).equals('-')) {
      flag = '-'
      i += 1
    }
    else if (str(0).equals('+')) i += 1
    // use double to store result
    var result = 0

    // calculate value
    while ( {
      str.length > i && str(i) >= '0' && str(i) <= '9'
    }) {
      result = result * 10 + (str.charAt(i) - '0')
      i += 1
    }

    if (flag == '-') result = -result

    // handle max and min
    if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE

    if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE

    result
  }
}
