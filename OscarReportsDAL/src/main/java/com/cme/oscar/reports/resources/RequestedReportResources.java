package com.cme.oscar.reports.resources;

import com.cme.oscar.reports.beans.RequestedReport;
import com.cme.oscar.reports.delegates.RequestedReportDelegate;
import com.cme.oscar.reports.responses.RequestedReportResponse;
import com.cme.oscar.reports.utils.ResponseUtils;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requestedReports")
public class RequestedReportResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestedReportResources.class.getCanonicalName());

    @Autowired
    private RequestedReportDelegate requestedReportDelegate;

    @GetMapping(value={"", "/{gid}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RequestedReportResponse> getRequestedReports(
            @RequestHeader(value = "X-AUTH-TOKEN") String xAuthToken,

            @RequestParam(value = "startingFrom", defaultValue = "0")
            @Min(value = 0, message = "Starting from value must be positive") int startingFrom,

            @RequestParam(value = "pageSize", defaultValue = "10")
            @Min(value = 0, message = "Page size value must be positive") int pageSize,

            @RequestParam(value = "searchString", required = false)
            @Min(value = 0)
            @Max(value = 20) Optional<String> searchString,

            @ApiParam
            @PathVariable
            @Length.List({
                    @Length(min = 36, message = "The Report GID must be at least 36 characters"),
                    @Length(max = 36, message = "The Report GID must be less than 37 characters")
            }) Optional<String> gid
    )
    {
        LOGGER.info("getRequestedReports: Received request to fetch requested reports list for X-AUTH-TOKEN: {}", xAuthToken);

        RequestedReportResponse response = new RequestedReportResponse();

        if(gid.isPresent()){
            LOGGER.debug("getRequestedReports: Received GID: {}", gid.get());
            response.getRequestedReportList().add(requestedReportDelegate.getRequestedReportByGID(xAuthToken, gid.get()));
            response.setCount(1);

        }else if(searchString.isPresent()){
            LOGGER.debug("getRequestedReports: Received SearchString: {}", searchString.get());
            List<RequestedReport> result = requestedReportDelegate.getRequestedReportBySearchString(xAuthToken, searchString.get());
            response.getRequestedReportList().addAll(result);
            response.setCount(result.size());

        }else{
            LOGGER.debug("getRequestedReports: Fetching All Records");
            response.getRequestedReportList().addAll(requestedReportDelegate.getAllRequestedReports(xAuthToken));
            response.setCount(requestedReportDelegate.getRequestedReportsCount(xAuthToken));
        }

        LOGGER.info("getRequestedReports: finished processing request to fetch requested reports list for X-AUTH-TOKEN: {}. Response: {}", xAuthToken, response);

        return new ResponseEntity<>(response, ResponseUtils.constructHeader(), HttpStatus.OK);
    }
}
