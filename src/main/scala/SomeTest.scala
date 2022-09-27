package Addition
import org.scalatest.flatspec.AnyFlatSpec

class SomeTest extends AnyFlatSpec {
 "Addition of 2 Numbers should " should "be accurate" in {
    assert(Addition.Add(5, 6) == 11)
    println("Test Successful")
  }
//WordSpec
  // Matchers
}
    //should be equal
    /*
    it should "throw an IOException in case of incorrect sum" in {
      assertThrows[IOException]
        {
        println("Incorrect Sum - Test Failing")
        }
    }*/
