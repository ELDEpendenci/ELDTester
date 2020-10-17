package com.ericlam.mc.eldtester;

import java.util.logging.Logger;

public class LoggerA  implements LogService{
    @Override
    public void log(Logger logger) {
        logger.info("Logging information by LoggerA");
    }
}
