package net.immortalrealms.admin.tps;

public class Lag implements Runnable {
    public static int TICK_COUNT = 0;
    public static long[] TICKS = new long[600];

    public static double getTPS() {
        return getTPS(100);
    }

    public static double getTPSPercentage() {
        return Double.valueOf(String.format("%.2f", (100 - getTPS() * 5)));
    }

    public static double getTPS(int ticks) {
        if(TICK_COUNT < ticks) {
            return 20.0D;
        }

        int target = (TICK_COUNT - 1 - ticks) % TICKS.length;
        long elapsed = System.currentTimeMillis() - TICKS[target];

        return ticks / (elapsed / 1000.0D);
    }

    public static long getElapsed(int tickID) {
        long time = TICKS[(tickID % TICKS.length)];
        return System.currentTimeMillis() - time;
    }

    @Override
    public void run() {
        TICKS[(TICK_COUNT % TICKS.length)] = System.currentTimeMillis();
        TICK_COUNT += 1;
    }

    private static Runtime instance = Runtime.getRuntime();
    private static int mb = 1024 * 1024;

    public static double getTotalMemory() {
        return totalMemory;
    }

    public static double totalMemory = instance.totalMemory() / mb;

    public static double getFreeMemory() {
        return freeMemory;
    }

    public static double freeMemory = instance.freeMemory() / mb;
}

