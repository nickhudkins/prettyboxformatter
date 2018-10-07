package com.bgpixel.prettyboxformatter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class PrettyBoxFormatter {

    private static final char TOP_LEFT_CORNER = '┌';
    private static final char BOTTOM_LEFT_CORNER = '└';
    private static final char MIDDLE_CORNER = '├';
    private static final char HORIZONTAL_LINE = '│';
    private static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
    private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER;

    private static final String NEWLINE = System.getProperty("line.separator");


    @NotNull
    private static final PrettyBoxConfiguration DEFAULT_CONFIGURATION =
            new PrettyBoxConfiguration.Builder()
                    .setPrefixEveryPrintWithNewline(false)
                    .build();

    @NotNull
    private static PrettyBoxConfiguration configuration = DEFAULT_CONFIGURATION;

    public static void setConfiguration(@NotNull PrettyBoxConfiguration configuration) {
        PrettyBoxFormatter.configuration =
                PrettyBoxConfiguration.Builder.createFromInstance(DEFAULT_CONFIGURATION)
                        .applyFromInstance(configuration)
                        .build();
    }

    @NotNull
    public static String format(@NotNull PrettyBoxable thingy) {
        return format(thingy.toStringLines());
    }

    @NotNull
    public static String format(@NotNull PrettyBoxable thingy,
                                @NotNull PrettyBoxConfiguration configuration) {
        return format(thingy.toStringLines(), configuration);
    }

    @NotNull
    public static String format(@NotNull List<String> lines) {
        return _format(lines, configuration);
    }

    @NotNull
    public static String format(@NotNull List<String> lines,
                                @NotNull PrettyBoxConfiguration configuration) {
        PrettyBoxConfiguration mergedConfig =
                PrettyBoxConfiguration.Builder.createFromInstance(PrettyBoxFormatter.configuration)
                        .applyFromInstance(configuration)
                        .build();
        return _format(lines, mergedConfig);
    }


    // ------------------------------------------------------------------------------------ INTERNAL

    @NotNull
    private static String _format(@NotNull List<String> lines,
                                  @NotNull PrettyBoxConfiguration configuration) {
        StringBuilder stringBuilder = new StringBuilder();

        if(configuration.isPrefixEveryPrintWithNewline()) stringBuilder.append(" \n");

        stringBuilder.append(TOP_BORDER).append(NEWLINE);

        for(String line : lines) {
            if(line.length() == 0) stringBuilder.append(MIDDLE_BORDER).append(NEWLINE);
            else stringBuilder.append(HORIZONTAL_LINE).append(" ").append(line).append(NEWLINE);
        }

        stringBuilder.append(BOTTOM_BORDER);

        return stringBuilder.toString();
    }

}
