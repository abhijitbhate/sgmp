package com.cme.oscar.reports.delegates.impl;

import com.cme.oscar.reports.delegates.DBDelegate;
import com.cme.oscar.reports.delegates.RequestedReportDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestedReportDelegateImpl implements RequestedReportDelegate{

    @Autowired
    private DBDelegate dbDelegate;
}
