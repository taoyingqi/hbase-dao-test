package com.mikemunhall.rest;

import com.mikemunhall.model.FlightInfo;
import com.mikemunhall.service.FlightInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flightInfo")
public class FlightInfoController {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FlightInfoService service;

    // rowkey 查询
    @GetMapping("/{key}")
    public FlightInfo get(@PathVariable String key) {
        return service.get(key);
    }

    // rowkey 前缀查询
    @GetMapping("/prefix/{key}")
    public List<FlightInfo> findByKeyPrefix(@PathVariable String key) {
        long start = System.currentTimeMillis();
        List<FlightInfo> flightInfoList = service.findByKeyPrefix(key);
        long end = System.currentTimeMillis();
        LOG.info("[diff time={}ms]", end - start);
        return flightInfoList;
    }

    // 时间点查询
    @GetMapping("/time")
    public List<FlightInfo> findByTime(@RequestParam String time) {
        long start = System.currentTimeMillis();
        List<FlightInfo> flightInfoList = service.findByTime(time);
        long end = System.currentTimeMillis();
        LOG.info("[diff time={}ms]", end - start);
        return flightInfoList;
    }

    // 时间段查询
    @GetMapping("/time/period")
    public List<FlightInfo> findByTimePeriod(@RequestParam String startTime, @RequestParam String endTime) {
        long start = System.currentTimeMillis();
        List<FlightInfo> flightInfoList = service.findByTimePeriod(startTime, endTime);
        long end = System.currentTimeMillis();
        LOG.info("[diff time={}ms]", end - start);
        return flightInfoList;
    }

    // 分页
    @GetMapping("")
    public List<FlightInfo> getPage(@RequestParam String key, @RequestParam int pageSize) {
        return service.getPage(key, pageSize);
    }

    // ADEPS 起飞机场查询
    @GetMapping("/ADEPS")
    public List<FlightInfo> findByADEPS(@RequestParam String ADEPS) {
        long start = System.currentTimeMillis();
        List<FlightInfo> flightInfoList = service.findByADEPS(ADEPS);
        long end = System.currentTimeMillis();
        LOG.info("[diff time={}ms]", end - start);
        return flightInfoList;
    }

}
