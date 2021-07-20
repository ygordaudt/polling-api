package com.example.polling.service;

import org.junit.Test;

import java.util.Arrays;

public class PerformanceTest {

    @Test(timeout = 100)
    public void testPerformance() {
        int numbers[] = {10, 50, 30, 20};

        for (int i=0; i<=1000000; i++) {
            numbers[0] = i;
            Arrays.sort(numbers);
        }
    }
}
