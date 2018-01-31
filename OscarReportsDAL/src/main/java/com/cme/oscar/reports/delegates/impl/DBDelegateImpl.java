package com.cme.oscar.reports.delegates.impl;

import com.cme.oscar.reports.delegates.DBDelegate;
import com.cme.oscar.reports.dtos.ReportManager;
import com.cme.oscar.reports.enums.ErrorConstants;
import com.cme.oscar.reports.exceptions.ProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBDelegateImpl implements DBDelegate{

    @Autowired
    private ReportManager reportManager;
}
