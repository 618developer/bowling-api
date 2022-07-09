package com.developer618.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BowlingTest {
    private Game g;

    @BeforeEach
    void setUp() {
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for(int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        rollMany(2, 5);
    }

    private void rollStrike() {
        g.roll(10); // strike
    }

    @Test
    void gutterGame() {

        rollMany(20, 0);
        assertThat(g.score(), is(equalTo(0)));
    }


    @Test
    void allOnes() {
        rollMany(20, 1);
        assertThat(g.score(), is(equalTo(20)));
    }

    @Test
    void oneSpare() {
        rollSpare();
        g.roll(7);
        rollMany(17, 0);
        assertThat(g.score(), is(equalTo(24)));
    }

    @Test
    void oneStrike() {
        rollStrike();
        g.roll(2);
        g.roll(3);
        rollMany(16, 0);
        assertThat(g.score(), is(equalTo(20)));
    }

    @Test
    void perfectGame() {
        rollMany(12, 10);
        assertThat(g.score(), is(equalTo(300)));
    }

}
