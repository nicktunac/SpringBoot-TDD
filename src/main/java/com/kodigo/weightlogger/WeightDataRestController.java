package com.kodigo.weightlogger;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class WeightDataRestController {

    private final WeightDataRepository weightDataRepository;

    public WeightDataRestController(WeightDataRepository weightDataRepository) {
        this.weightDataRepository = weightDataRepository;
    }

    @GetMapping(value = "/weights")
    public Collection<WeightData> weightData() {
        return this.weightDataRepository.findAll();
    }

    @GetMapping(value = "/weights/{id}")
    public WeightData findWeightData(@PathVariable Long id) {
        return this.weightDataRepository.findOne(id);
    }

    @PostMapping(value = "/weights")
    public WeightData addWeightData(@RequestBody WeightData weightData) {
        return this.weightDataRepository.save(weightData);
    }

    @PutMapping(value = "/weights/{id}")
    public WeightData updateWeightData(@PathVariable Long id, @RequestBody WeightData weightData) {

        WeightData currentData = this.weightDataRepository.findOne(id);

        currentData.setDate(weightData.getDate());
        currentData.setWeight(weightData.getWeight());

        return this.weightDataRepository.save(currentData);
    }

    @DeleteMapping(value = "/weights/{id}")
    public ResponseEntity<?> deleteWeightData(@PathVariable Long id) {
        this.weightDataRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public String home() {
        return "Hello World!";
    }

}
