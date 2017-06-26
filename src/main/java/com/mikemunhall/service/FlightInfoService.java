package com.mikemunhall.service;

import com.mikemunhall.dao.FlightInfoDao;
import com.mikemunhall.model.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FlightInfoService {

    @Autowired
    private FlightInfoDao dao;

    public FlightInfoService() { }

    public FlightInfo get(String key) {
        return dao.get(key);
    }

    public List<FlightInfo> findByKeyPrefix(String key) {
        return dao.findByKeyPrefix(key);
    }

    public List<FlightInfo> findByTime(String time) {
        return dao.findByTime(time);
    }

    public List<FlightInfo> findByTimePeriod(String startTime, String endTime) {
        return dao.findByTimePeriod(startTime, endTime);
    }

    public List<FlightInfo> getPage(String key, int pageSize) {
        return dao.getPage(key, pageSize);
    }

    public void recreateTable() throws IOException {
        dao.drop();
        dao.init();
    }
}
