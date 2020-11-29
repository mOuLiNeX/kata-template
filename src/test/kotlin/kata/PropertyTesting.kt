package kata

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class PropertyTesting : StringSpec({
    val sut = Sample()
    "integers under addition should have an identity value" {
        checkAll<Int, Int>(100) { a, b ->
            sut.addition(a, b) shouldBe (a + b)
        }
    }
})