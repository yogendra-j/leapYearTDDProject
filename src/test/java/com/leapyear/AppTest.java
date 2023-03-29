package com.leapyear;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
class AppTest {
    App app;
    Logging logger;

    @BeforeEach
    void setupTest() {
        logger = Mockito.mock(Logging.class);
        app = new App(logger);
    }

    @Test
    void yearNotDivisibleByFourShouldReturnFalse() {
       boolean isLeapYear = app.isLeapYear(2017);
       verify(logger, Mockito.times(1)).log("2017");
       assertEquals(isLeapYear, false);
    }

    @Test
    void yearDivisbleByFourAndNotByHundredShouldReturnTrue() {
        boolean isLeapYear = app.isLeapYear(2012);
       verify(logger, Mockito.times(1)).log("2012");

       assertEquals(isLeapYear, true);
    }

    @Test
    void yearDivisbleByFourAndByHundredShouldReturnFalse() {
        boolean isLeapYear = app.isLeapYear(1800);
       verify(logger, Mockito.times(1)).log("1800");

       assertEquals(isLeapYear, false);
    }

    @Test
    void yearDivisbleByFourAndByFourHundredShouldReturnTrue() {
        boolean isLeapYear = app.isLeapYear(2000);
       verify(logger, Mockito.times(1)).log("2000");

       assertEquals(isLeapYear, true);
    }
}
