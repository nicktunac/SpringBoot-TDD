package com.kodigo.weightlogger;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class WeightDataTest {

    @Test
    public void creation(){
        WeightData w = new WeightData(1L, 72.15D, LocalDate.now());
        Assert.assertEquals(w.getId(), (Long) 1L);
        Assert.assertEquals(w.getWeight(), (Double) 72.15);
        Assert.assertEquals(w.getDate(), LocalDate.now());
    }

}
