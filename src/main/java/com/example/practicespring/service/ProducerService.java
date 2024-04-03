package com.example.practicespring.service;

import com.example.practicespring.entity.Producer;

import java.util.List;

public interface ProducerService {
    Producer createProducer(Producer producer);
    Producer getProducerById(Long producerId);
    List<Producer> getAllProducers();
    Producer updateProducer(Long producerId, Producer updatedProducer);
    void deleteProducer(Long producerId);

}
