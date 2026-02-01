package com.mycompany.nepalhealthapi.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class HealthRecord {
    private int personId;
    private int age;
    private double bmi;
    private int lifestyleRiskScore;
    private int sesRiskScore;
    private String segmentName;
    private double diabetesRiskScore;
}
