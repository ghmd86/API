package com.phillips.oit.service;

import java.util.List;

import com.phillips.oit.bean.OITBean;

public interface OITDaoService {
public boolean saveOITData(String data);
public List<OITBean> getOITData();
}
