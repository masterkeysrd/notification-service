package com.masterkeys.notificationservice.utils;

public class SimulatorUtil {
    public static void simulateWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
