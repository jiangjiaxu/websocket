package com.jiang.websocket.service;

import com.jiang.websocket.entity.bo.SysLogBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysLogService {

    public boolean save(SysLogBO sysLogBO){
        System.out.println(sysLogBO);
        log.info(sysLogBO.getParams());
        return true;
    }
}

