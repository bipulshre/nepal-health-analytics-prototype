package com.mycompany.nepalhealthapi.controller;


import com.mycompany.nepalhealthapi.model.SegmentKPI;
import com.mycompany.nepalhealthapi.service.SegmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/segments")
public class SegmentController {
    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService){
        this.segmentService = segmentService;
    }

    @GetMapping("/kpi")
    public List<SegmentKPI> getSegmentKpis(){
        return segmentService.getAverageRiskBySegment();
    }
}
