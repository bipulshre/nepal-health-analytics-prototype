package com.mycompany.nepalhealthapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SegmentKPI {
    private String segment;
    private double averageDiabetesRisk;
}
