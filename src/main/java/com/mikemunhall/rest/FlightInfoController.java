package com.mikemunhall.rest;

import com.mikemunhall.model.FlightInfo;
import com.mikemunhall.service.FlightInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/flightInfo")
public class FlightInfoController {

    @Autowired
    private FlightInfoService service;

    @RequestMapping(value="/{key}", method=RequestMethod.GET)
    public FlightInfo get(@PathVariable String key) {
        return service.get(key);
    }

    @RequestMapping(value="/prefix/{key}", method=RequestMethod.GET)
    public List<FlightInfo> findByKeyPrefix(@PathVariable String key) {
        return service.findByKeyPrefix(key);
    }

    @RequestMapping(value = "/time")
    public List<FlightInfo> findByTime(@RequestParam String time) {
        return service.findByTime(time);
    }

    @RequestMapping(value = "/time/period")
    public List<FlightInfo> findByTimePeriod(@RequestParam String startTime, @RequestParam String endTime) {
        return service.findByTimePeriod(startTime, endTime);
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<FlightInfo> getPage() {
        return service.getPage();
    }

    @RequestMapping(value="/recreateTable", method=RequestMethod.GET)
    public void recreateTable() throws IOException {
        service.recreateTable();
    }

}
