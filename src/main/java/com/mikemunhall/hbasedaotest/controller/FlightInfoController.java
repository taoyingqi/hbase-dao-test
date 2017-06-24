package com.mikemunhall.hbasedaotest.controller;

import com.mikemunhall.hbasedaotest.model.FlightInfo;
import com.mikemunhall.hbasedaotest.service.SessionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/flightInfo")
public class FlightInfoController {

    @Autowired
    private SessionDataService service;

    @RequestMapping(value="/getOne", method=RequestMethod.GET)
    public FlightInfo getSession(@RequestParam("sessionId") String sessionId) {
        return service.getSession(sessionId);
    }

    @RequestMapping(value="/getAll", method=RequestMethod.GET)
    public List<FlightInfo> getSessions() {
        return service.getSessions();
    }

    @RequestMapping(value="/recreateTable", method=RequestMethod.GET)
    public void recreateTable() throws IOException {
        service.recreateTable();
    }

}
