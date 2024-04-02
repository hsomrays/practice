package com.example.practicespring.mapper;

import com.example.practicespring.dto.ProducerDto;
import com.example.practicespring.entity.Producer;

public class ProducerMapper {

    public static ProducerDto mapToProducerDto(Producer producer){
        return new ProducerDto(
                producer.getId(),
                producer.getName(),
                producer.getWorkExperience(),
                producer.getCompany(),
                producer.getSongs()
        );
    }

    public static Producer mapToProducer(ProducerDto producerDto){
        return new Producer(
                producerDto.getId(),
                producerDto.getName(),
                producerDto.getWorkExperience(),
                producerDto.getCompany(),
                producerDto.getSongs()
        );
    }
}
