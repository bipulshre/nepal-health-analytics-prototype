package com.mycompany.nepalhealthapi.service;


import com.mycompany.nepalhealthapi.model.HealthRecord;
import com.mycompany.nepalhealthapi.model.SegmentKPI;
import com.mycompany.nepalhealthapi.repository.CsvDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SegmentService {

    private final CsvDataRepository csvDataRepository;

    public SegmentService(CsvDataRepository csvDataRepository){
        this.csvDataRepository = csvDataRepository;
    }

    public List<SegmentKPI> getAverageRiskBySegment(){
        List<HealthRecord> records = csvDataRepository.findAll();

        Map<String, Double> grouped = records.stream().collect(Collectors.groupingBy(
                HealthRecord::getSegmentName,
                Collectors.averagingDouble(HealthRecord::getDiabetesRiskScore)
        ));

        return grouped.entrySet()
                .stream()
                .map(e -> new SegmentKPI(e.getKey(),e.getValue()))
                .toList();
    }
}
