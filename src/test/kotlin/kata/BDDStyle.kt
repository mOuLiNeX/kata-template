package kata

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BDDStyle : BehaviorSpec({
    given("An addition") {
        val sut = Sample()
        `when`("I add 2 integers") {
            then("The result is the sum") {
                sut.addition(1, 1) shouldBe 2
            }
            then("The result is the same regardless of params order") {
                sut.addition(2, 1) shouldBe sut.addition(1, 2)
            }
        }

    }
})