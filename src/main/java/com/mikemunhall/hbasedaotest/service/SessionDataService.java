package com.mikemunhall.hbasedaotest.service;

import com.mikemunhall.hbasedaotest.dao.FlightInfoDao;
import com.mikemunhall.hbasedaotest.model.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SessionDataService {

    @Autowired
    private FlightInfoDao dao;

    public SessionDataService() { }

    public FlightInfo getSession(String sessionId) {
        return dao.findOne(sessionId);
    }

    public List<FlightInfo> getSessions() {
        return dao.findAll();
    }

    public void recreateTable() throws IOException {
        dao.drop();
        dao.init();
    }
}
