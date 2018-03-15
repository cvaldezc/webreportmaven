/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.progpc04.Util;

import java.io.Serializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Christian
 */
public class LoggerUtil implements Serializable {

    private static final long serialVersionUID = -2543135L;

    private final Logger logger = LogManager.getLogger(LoggerUtil.class);

    private static LoggerUtil loggerUtil = null;

    private LoggerUtil() {
    }

    public static LoggerUtil getInstance() {
        if (loggerUtil == null) {
            loggerUtil = new LoggerUtil();
        }
        return loggerUtil;
    }
    
    public Logger getLogger() {
        return logger;
    }

}
