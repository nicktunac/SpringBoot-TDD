package com.kodigo.weightlogger;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collection;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
public class WeightDataRepositoryTest {


    @Autowired
    private WeightDataRepository repository;

    @Test
    public void findByWeightDataId() {

        this.repository.save(new WeightData(null, 72.15D, LocalDate.now()));

        Collection<WeightData> byWeight =  this.repository.findByWeight(72.15D);

        Assertions.assertThat(byWeight.size()).isEqualTo(1);
        Assertions.assertThat(byWeight.iterator().next().getId()).isGreaterThan(0);
        Assertions.assertThat(byWeight.iterator().next().getWeight()).isEqualTo(72.15D);

    }

}
