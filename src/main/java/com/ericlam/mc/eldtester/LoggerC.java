package com.ericlam.mc.eldtester;

import java.util.logging.Logger;

public class LoggerC implements LogService{
    @Override
    public void log(Logger logger) {
        logger.info("Logging information by LoggerC");
    }
}
