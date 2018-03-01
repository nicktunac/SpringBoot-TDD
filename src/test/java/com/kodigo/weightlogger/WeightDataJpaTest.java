package com.kodigo.weightlogger;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest // Boot 1.4 test slices
public class WeightDataJpaTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void mapping() throws Exception{
        WeightData weight = this.tem.persistFlushFind(new WeightData(null, 72.15D, LocalDate.now()));
        Assertions.assertThat(weight.getWeight()).isEqualTo((Double) 72.15D);
        Assertions.assertThat(weight.getId()).isGreaterThan(0);
    }

}
