package com.cme.oscar.reports.delegates.impl;

import com.cme.oscar.reports.beans.RequestedReport;
import com.cme.oscar.reports.delegates.DBDelegate;
import com.cme.oscar.reports.delegates.RequestedReportDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestedReportDelegateImpl implements RequestedReportDelegate{

    @Autowired
    private DBDelegate dbDelegate;

    @Override
    public RequestedReport getRequestedReportByGID(String userId, String gid) {
        return new RequestedReport();
    }

    @Override
    public List<RequestedReport> getRequestedReportBySearchString(String userId, String searchString) {
        return new ArrayList<RequestedReport>(0);
    }

    @Override
    public List<RequestedReport> getAllRequestedReports(String userId) {
        return new ArrayList<>(0);
    }

    @Override
    public int getRequestedReportsCount(String userId) {
        return 15;
    }
}
