package com.mycompany.nepalhealthapi.repository;


import com.mycompany.nepalhealthapi.model.HealthRecord;
import com.mycompany.nepalhealthapi.utils.CsvReaderUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CsvDataRepository {
    public List<HealthRecord> findAll() {
        return CsvReaderUtil.readHealthData();
    }
}
