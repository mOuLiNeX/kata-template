package kata

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class JUnitStyle : AnnotationSpec() {

    lateinit var sut: Sample

    @BeforeEach
    fun beforeTest() {
        sut = Sample()
    }

    @Test
    fun testAddition() {
        sut.addition(1, 1) shouldBe 2
    }
}