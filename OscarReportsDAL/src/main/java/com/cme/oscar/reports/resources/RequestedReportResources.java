package com.cme.oscar.reports.resources;

import com.cme.oscar.reports.beans.RequestedReport;
import com.cme.oscar.reports.utils.ResponseUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/requestedReports")
public class RequestedReportResources {

    @GetMapping
    public ResponseEntity<RequestedReport> getRequestedReports(@Valid @RequestParam String type){
        return new ResponseEntity<RequestedReport>(new RequestedReport(), ResponseUtils.constructHeader(), HttpStatus.OK);
    }
}
