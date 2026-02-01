package com.mycompany.nepalhealthapi.utils;

import com.mycompany.nepalhealthapi.model.HealthRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderUtil {

    public static List<HealthRecord> readHealthData(){

        List<HealthRecord> records = new ArrayList<>();

        try{
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(
                    CsvReaderUtil.class
                            .getClassLoader()
                            .getResourceAsStream("data/nepal_scored.csv")
            ));

            for (CSVRecord row : parser) {
                HealthRecord record = new HealthRecord();
                record.setPersonId(Integer.parseInt(row.get("person_id")));
                record.setAge(Integer.parseInt(row.get("age")));
                record.setBmi(Double.parseDouble(row.get("BMI")));
                record.setLifestyleRiskScore(Integer.parseInt(row.get("lifestyle_risk_score")));
                record.setSesRiskScore(Integer.parseInt(row.get("ses_risk_score")));
                record.setSegmentName(row.get("segment_name"));
                record.setDiabetesRiskScore(Double.parseDouble(row.get("diabetes_risk_score")));

                records.add(record);
            }
        }catch (Exception e){
            throw new RuntimeException("Error reading csv:", e);
        }



        return records;
    }

}
