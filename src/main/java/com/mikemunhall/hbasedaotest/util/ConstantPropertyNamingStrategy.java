package com.mikemunhall.hbasedaotest.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Created by MT-T450 on 2017/6/24.
 */
public class ConstantPropertyNamingStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
    @Override
    public String translate(String s) {
        return s.toUpperCase();
    }
}
