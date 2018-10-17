package org.kata.potter;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.kata.potter.Book.FIVE;
import static org.kata.potter.Book.FOUR;
import static org.kata.potter.Book.ONE;
import static org.kata.potter.Book.THREE;
import static org.kata.potter.Book.TWO;


public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
    }

    @Test
    public void should_getPrice_compute_when_empty() throws Exception {
        // given
        // empty basket

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isZero();
    }

    @Test
    public void should_getPrice_compute_when_1() throws Exception {
        // given
        basket.addAll(ONE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8);
    }

    @Test
    public void should_getPrice_compute_when_2() throws Exception {
        // given
        basket.addAll(TWO);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8);
    }

    @Test
    public void should_getPrice_compute_when_3() throws Exception {
        // given
        basket.addAll(THREE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8);
    }

    @Test
    public void should_getPrice_compute_when_4() throws Exception {
        // given
        basket.addAll(FOUR);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8);
    }

    @Test
    public void should_getPrice_compute_when_5() throws Exception {
        // given
        basket.addAll(FIVE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8);
    }

    @Test
    public void should_getPrice_compute_when_1_1() throws Exception {
        // given
        basket.addAll(ONE, ONE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 * 2);
    }

    @Test
    public void should_getPrice_compute_when_2_2_2() throws Exception {
        // given
        basket.addAll(TWO, TWO, TWO);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 * 3);
    }

    @Test
    public void should_getPrice_compute_when_1_2() throws Exception {
        // given
        basket.addAll(ONE, TWO);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 * 2 * 0.95);
    }

    @Test
    public void should_getPrice_compute_when_1_3_5() throws Exception {
        // given
        basket.addAll(ONE, THREE, FIVE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 * 3 * 0.9);
    }

    @Test
    public void should_getPrice_compute_when_1_2_3_5() throws Exception {
        // given
        basket.addAll(ONE, TWO, THREE, FIVE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 * 4 * 0.8);
    }

    @Test
    public void should_getPrice_compute_when_1_2_3_4_5() throws Exception {
        // given
        basket.addAll(ONE, TWO, THREE, FOUR, FIVE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 * 5 * 0.75);
    }

    @Test
    public void should_getPrice_compute_when_1_1_2() throws Exception {
        // given
        basket.addAll(ONE, ONE, TWO);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 + (8 * 2 * 0.95));
    }

    @Test
    public void should_getPrice_compute_when_1_1_2_2() throws Exception {
        // given
        basket.addAll(ONE, ONE, TWO, TWO);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(2 * (8 * 2 * 0.95));
    }

    @Test
    public void should_getPrice_compute_when_1_1_2_3_3_4() throws Exception {
        // given
        basket.addAll(ONE, ONE, TWO, THREE, THREE, FOUR);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo((8 * 4 * 0.8) + (8 * 2 * 0.95));
    }

    @Test
    public void should_getPrice_compute_when_1_2_2_3_4_5() throws Exception {
        // given
        basket.addAll(ONE, TWO, TWO, THREE, FOUR, FIVE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(8 + (8 * 5 * 0.75));
    }

    @Test
    public void should_getPrice_compute_when_1_1_2_2_3_3_4_5() throws Exception {
        // given
        basket.addAll(ONE, ONE, TWO, TWO, THREE, THREE, FOUR, FIVE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(2 * (8 * 4 * 0.8));
    }

    @Test
    public void should_getPrice_compute_when_1_1_1_1_1_2_2_2_2_2_3_3_3_3_4_4_4_4_4_5_5_5_5() throws Exception {
        // given
        basket.addAll(ONE, ONE, ONE, ONE, ONE,
                TWO, TWO, TWO, TWO, TWO,
                THREE, THREE, THREE, THREE,
                FOUR, FOUR, FOUR, FOUR, FOUR,
                FIVE, FIVE, FIVE, FIVE);

        // when
        double price = basket.getPrice();

        // then
        assertThat(price).isEqualTo(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8));
    }
}