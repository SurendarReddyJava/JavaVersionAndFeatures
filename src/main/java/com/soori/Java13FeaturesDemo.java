package com.soori.java13;

public class Java13FeaturesDemo {

    /**
     * Demonstrates Text Blocks (Preview).
     */
    public void textBlocks() {
        String textBlock = """
            This is a text block.
            It spans multiple lines.
            """;
        System.out.println("Text Block: " + textBlock);
    }

    /**
     * Demonstrates Switch Expressions (Preview).
     */
    public void switchExpressions(String day) {
        int numLetters = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> 9;
            default -> throw new IllegalStateException("Unexpected value: " + day);
        };
        System.out.println("Number of letters: " + numLetters);
    }

    /**
     * Demonstrates Reimplement the Legacy Socket API.
     */
    public void reimplementLegacySocketAPI() {
        // This feature is internal and does not require any code changes.
        System.out.println("Reimplement the Legacy Socket API: Internal improvement.");
    }

    /**
     * Demonstrates Dynamic CDS Archives.
     */
    public void dynamicCDSArchives() {
        // This feature is enabled by default and does not require any code changes.
        System.out.println("Dynamic CDS Archives: Enabled by default.");
    }

    /**
     * Demonstrates ZGC: Uncommit Unused Memory.
     */
    public void zgcUncommitUnusedMemory() {
        // To enable this feature, use the JVM option: -XX:+UnlockExperimentalVMOptions -XX:+UseZGC
        System.out.println("ZGC: Uncommit Unused Memory: Enable with JVM option -XX:+UnlockExperimentalVMOptions -XX:+UseZGC.");
    }

    public static void main(String[] args) {
        Java13FeaturesDemo demo = new Java13FeaturesDemo();
        demo.textBlocks();
        demo.switchExpressions("MONDAY");
        demo.reimplementLegacySocketAPI();
        demo.dynamicCDSArchives();
        demo.zgcUncommitUnusedMemory();
    }
}
