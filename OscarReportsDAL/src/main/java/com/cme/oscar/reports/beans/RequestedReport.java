package com.cme.oscar.reports.beans;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class RequestedReport implements Serializable{

    private static final long serialVersionUID = -1L;

    @Size(min = 1, max = 36)
    private String gid;
    private String userId;
    private String name;
}
