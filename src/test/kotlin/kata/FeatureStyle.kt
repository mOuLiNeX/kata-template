package kata

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

class FeatureStyle : FeatureSpec({
    feature("Add addition") {
        val sut = Sample()
        scenario("should give the sum of 2 ints") {
            assertSoftly {
                sut.addition(1, 1) shouldBe 2
                sut.addition(1, 3) shouldBe 4
                sut.addition(10, 1) shouldBe 11
            }
        }
    }
})