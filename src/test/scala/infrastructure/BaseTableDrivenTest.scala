package infrastructure

import org.scalatest.{FunSuite, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks

trait BaseTableDrivenTest extends FunSuite with TableDrivenPropertyChecks with Matchers {

}
