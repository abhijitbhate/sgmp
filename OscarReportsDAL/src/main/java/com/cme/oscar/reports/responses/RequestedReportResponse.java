package com.cme.oscar.reports.responses;

import com.cme.oscar.reports.beans.RequestedReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RequestedReportResponse implements Serializable{

    private static final Logger logger = LoggerFactory.getLogger(RequestedReportResponse.class.getCanonicalName());

    private List<RequestedReport> requestedReportList;
    private int count;

    public RequestedReportResponse() {
    }

    public RequestedReportResponse(List<RequestedReport> requestedReportList, int count) {
        this.requestedReportList = requestedReportList;
        this.count = count;
    }

    public List<RequestedReport> getRequestedReportList() {
        if(this.requestedReportList == null){
            this.requestedReportList = new ArrayList<>(0);
        }
        return requestedReportList;
    }

    public void setRequestedReportList(List<RequestedReport> requestedReportList) {
        this.requestedReportList = requestedReportList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RequestedReportResponse{" +
                "requestedReportList=" + requestedReportList +
                ", count=" + count +
                '}';
    }
}
