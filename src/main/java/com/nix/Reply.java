package com.nix;

import com.nix.block.CheckDate;
import com.nix.exception.WrongDateException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Reply {
    private static  int  numberOfAttempts = 3;
    private static final int SLEEP = 100;

    public static void run(CheckDate checkDate) throws InterruptedException {
        log.debug("Testing is started...");
        for (int i = 0; i < numberOfAttempts; i++) {
            log.debug("Attempt #" + (i+1));
            try {
                checkDate.run();
                break;
            } catch (WrongDateException e) {
                log.debug("Caught WrongDateException of CheckDate class, message: " + e.getMessage());
                if (i == numberOfAttempts - 1) {
                    log.debug("Attempt limit exceeded");
                    throw e;
                }
                e.printStackTrace();
            }
            Thread.sleep((i * SLEEP));
        }
    }
}
