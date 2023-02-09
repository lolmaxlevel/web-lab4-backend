package com.lolmaxlevel.weblab4server.service.logic;

import com.lolmaxlevel.weblab4server.dto.AddAttemptRequest;

public class AreaChecker {
    private AreaChecker() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean checkArea(AddAttemptRequest addAttemptRequest) {
        double x = addAttemptRequest.x();
        double y = addAttemptRequest.y();
        double r = addAttemptRequest.r();
        return checkArea(x, y, r);
    }
    private static boolean checkArea(double x, double y, double r) {
        return attemptIsInRect(x, y, r) || attemptIsInTriangle(x, y, r) || attemptIsInCircle(x, y, r);
    }

    private static boolean attemptIsInRect(double x, double y, double r) {
        return (x>=0 && y>=0 && x<=r/2.0 && y<=r);
    }

    private static boolean attemptIsInCircle(double x, double y, double r) {
        return (x<=0 && y<=0 && x*x+y*y<=r/2.0*r/2.0);
    }

    private static boolean attemptIsInTriangle(double x, double y, double r) {
        return (x >= 0 && y <= 0 && y >= x - r / 2.0);
    }
}
