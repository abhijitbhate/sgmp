package com.cme.oscar.reports.delegates;

import com.cme.oscar.reports.beans.RequestedReport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RequestedReportDelegate {

    RequestedReport getRequestedReportByGID(String userId, String gid);
    List<RequestedReport> getRequestedReportBySearchString(String userId, String searchString);
    List<RequestedReport> getAllRequestedReports(String userId);
    int getRequestedReportsCount(String userId);
}
