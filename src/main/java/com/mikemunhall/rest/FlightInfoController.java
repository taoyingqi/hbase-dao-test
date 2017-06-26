package com.mikemunhall.rest;

import com.mikemunhall.model.FlightInfo;
import com.mikemunhall.service.FlightInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/flightInfo")
public class FlightInfoController {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FlightInfoService service;

    @RequestMapping(value="/{key}", method=RequestMethod.GET)
    public FlightInfo get(@PathVariable String key) {
        return service.get(key);
    }

    @RequestMapping(value="/prefix/{key}", method=RequestMethod.GET)
    public List<FlightInfo> findByKeyPrefix(@PathVariable String key) {
        long start = System.currentTimeMillis();
        List<FlightInfo> flightInfoList = service.findByKeyPrefix(key);
        long end = System.currentTimeMillis();
        LOG.info("[diff time={}ms]", end - start);
        return flightInfoList;
    }

    @RequestMapping(value = "/time")
    public List<FlightInfo> findByTime(@RequestParam String time) {
        long start = System.currentTimeMillis();
        List<FlightInfo> flightInfoList = service.findByTime(time);
        long end = System.currentTimeMillis();
        LOG.info("[diff time={}ms]", end - start);
        return flightInfoList;
    }

    @RequestMapping(value = "/time/period")
    public List<FlightInfo> findByTimePeriod(@RequestParam String startTime, @RequestParam String endTime) {
        long start = System.currentTimeMillis();
        List<FlightInfo> flightInfoList = service.findByTimePeriod(startTime, endTime);
        long end = System.currentTimeMillis();
        LOG.info("[diff time={}ms]", end - start);
        return flightInfoList;
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<FlightInfo> getPage(@RequestParam String key, @RequestParam int pageSize) {
        return service.getPage(key, pageSize);
    }

    @RequestMapping(value="/recreateTable", method=RequestMethod.GET)
    public void recreateTable() throws IOException {
        service.recreateTable();
    }

}
