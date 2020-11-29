package kata;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SampleTest {

    Sample sut;

    @BeforeEach
    public void setUp() {
        sut = new Sample();
    }

    @Test
    public void testSingleAddition() {
        assertThat(sut.addition(1, 1)).isEqualTo(2);
    }

    @Test
    public void testAdditions() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(sut.addition(1, 1)).isEqualTo(2);
            softly.assertThat(sut.addition(1, 10)).isEqualTo(11);
            softly.assertThat(sut.addition(4, 1)).isEqualTo(5);
            softly.assertThat(sut.addition(2, 1)).isEqualTo(3);
        });
    }
}