package com.example.practicespring.service.impl;

import com.example.practicespring.entity.Producer;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.repository.ProducerRepository;
import com.example.practicespring.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Override
    public Producer createProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public Producer getProducerById(Long producerId) {
        return producerRepository.findById(producerId)
                .orElseThrow(() -> new ResourceNotFoundException("Producer does not exist with the given id: " + producerId));
    }

    @Override
    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    @Override
    public Producer updateProducer(Long producerId, Producer updatedProducer) {
        Producer producer = producerRepository.findById(producerId)
                .orElseThrow(() -> new ResourceNotFoundException("Producer does not exist with the given id: " + producerId));

        producer.setName(updatedProducer.getName());
        producer.setCompany(updatedProducer.getCompany());
        producer.setWorkExperience(updatedProducer.getWorkExperience());

        return producerRepository.save(producer);
    }

    @Override
    public void deleteProducer(Long producerId) {
        producerRepository.deleteById(producerId);
    }
}