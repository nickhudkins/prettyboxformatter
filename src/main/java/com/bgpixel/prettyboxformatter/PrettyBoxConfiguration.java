package com.bgpixel.prettyboxformatter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PrettyBoxConfiguration {

    @Nullable private final Boolean prefixEveryPrintWithNewline;
    @Nullable private final Integer charsPerLine;
    @Nullable private final Boolean wrapContent;
    @Nullable private final Boolean borderLeft;
    @Nullable private final Boolean borderRight;
    @Nullable private final Boolean borderTop;
    @Nullable private final Boolean borderBottom;
    @Nullable private final Integer paddingLeft;
    @Nullable private final Integer paddingRight;
    @Nullable private final Integer paddingTop;
    @Nullable private final Integer paddingBottom;
    @Nullable private final Integer marginLeft;
    @Nullable private final Integer marginRight;
    @Nullable private final Integer marginTop;
    @Nullable private final Integer marginBottom;

    private PrettyBoxConfiguration(@Nullable Boolean prefixEveryPrintWithNewline,
                                   @Nullable Integer charsPerLine,
                                   @Nullable Boolean wrapContent,
                                   @Nullable Boolean borderLeft,
                                   @Nullable Boolean borderRight,
                                   @Nullable Boolean borderTop,
                                   @Nullable Boolean borderBottom,
                                   @Nullable Integer paddingLeft,
                                   @Nullable Integer paddingRight,
                                   @Nullable Integer paddingTop,
                                   @Nullable Integer paddingBottom,
                                   @Nullable Integer marginLeft,
                                   @Nullable Integer marginRight,
                                   @Nullable Integer marginTop,
                                   @Nullable Integer marginBottom) {
        this.prefixEveryPrintWithNewline = prefixEveryPrintWithNewline;
        this.charsPerLine = charsPerLine;
        this.wrapContent = wrapContent;
        this.borderLeft = borderLeft;
        this.borderRight = borderRight;
        this.borderTop = borderTop;
        this.borderBottom = borderBottom;
        this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
        this.paddingTop = paddingTop;
        this.paddingBottom = paddingBottom;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
    }

    @Nullable public Boolean getPrefixEveryPrintWithNewline() { return prefixEveryPrintWithNewline; }
    @Nullable public Integer getCharsPerLine() { return charsPerLine; }
    @Nullable public Boolean getWrapContent() { return wrapContent; }
    @Nullable public Boolean getBorderLeft() { return borderLeft; }
    @Nullable public Boolean getBorderRight() { return borderRight; }
    @Nullable public Boolean getBorderTop() { return borderTop; }
    @Nullable public Boolean getBorderBottom() { return borderBottom; }
    @Nullable public Integer getPaddingLeft() { return paddingLeft; }
    @Nullable public Integer getPaddingRight() { return paddingRight; }
    @Nullable public Integer getPaddingTop() { return paddingTop; }
    @Nullable public Integer getPaddingBottom() { return paddingBottom; }
    @Nullable public Integer getMarginLeft() { return marginLeft; }
    @Nullable public Integer getMarginRight() { return marginRight; }
    @Nullable public Integer getMarginTop() { return marginTop; }
    @Nullable public Integer getMarginBottom() { return marginBottom; }

    public static class Builder {

        @Nullable private Boolean prefixEveryPrintWithNewline = false;
        @Nullable private Integer charsPerLine;
        @Nullable private Boolean wrapContent;
        @Nullable private Boolean borderLeft;
        @Nullable private Boolean borderRight;
        @Nullable private Boolean borderTop;
        @Nullable private Boolean borderBottom;
        @Nullable private Integer paddingLeft;
        @Nullable private Integer paddingRight;
        @Nullable private Integer paddingTop;
        @Nullable private Integer paddingBottom;
        @Nullable private Integer marginLeft;
        @Nullable private Integer marginRight;
        @Nullable private Integer marginTop;
        @Nullable private Integer marginBottom;

        /** Creates a Builder by copying all values from the PrettyBoxConfiguration instance */
        @NotNull
        public static Builder createFromInstance(@NotNull PrettyBoxConfiguration configuration) {
            Builder builder = new Builder();
            builder.setPrefixEveryPrintWithNewline(configuration.getPrefixEveryPrintWithNewline());
            builder.setCharsPerLine(configuration.getCharsPerLine());
            builder.setWrapContent(configuration.getWrapContent());
            builder.setBorderLeft(configuration.getBorderLeft());
            builder.setBorderRight(configuration.getBorderRight());
            builder.setBorderTop(configuration.getBorderTop());
            builder.setBorderBottom(configuration.getBorderBottom());
            builder.setPaddingLeft(configuration.getPaddingLeft());
            builder.setPaddingRight(configuration.getPaddingRight());
            builder.setPaddingTop(configuration.getPaddingTop());
            builder.setPaddingBottom(configuration.getPaddingBottom());
            builder.setMarginLeft(configuration.getMarginLeft());
            builder.setMarginRight(configuration.getMarginRight());
            builder.setMarginTop(configuration.getMarginTop());
            builder.setMarginBottom(configuration.getMarginBottom());
            return builder;
        }

        /** Copies non-null values from the PrettyBoxConfiguration instance */
        @NotNull
        public Builder applyFromInstance(@NotNull PrettyBoxConfiguration configuration) {
            if(configuration.getPrefixEveryPrintWithNewline() != null)
                this.prefixEveryPrintWithNewline = configuration.getPrefixEveryPrintWithNewline();
            if(configuration.getCharsPerLine() != null)
                this.charsPerLine = configuration.getCharsPerLine();
            if(configuration.getWrapContent() != null)
                this.wrapContent = configuration.getWrapContent();
            if(configuration.getBorderLeft() != null)
                this.borderLeft = configuration.getBorderLeft();
            if(configuration.getBorderRight() != null)
                this.borderRight = configuration.getBorderRight();
            if(configuration.getBorderTop() != null)
                this.borderTop = configuration.getBorderTop();
            if(configuration.getBorderBottom() != null)
                this.borderBottom = configuration.getBorderBottom();
            if(configuration.getPaddingLeft() != null)
                this.paddingLeft = configuration.getPaddingLeft();
            if(configuration.getPaddingRight() != null)
                this.paddingRight = configuration.getPaddingRight();
            if(configuration.getPaddingTop() != null)
                this.paddingTop = configuration.getPaddingTop();
            if(configuration.getPaddingBottom() != null)
                this.paddingBottom = configuration.getPaddingBottom();
            if(configuration.getMarginLeft() != null)
                this.marginLeft = configuration.getMarginLeft();
            if(configuration.getMarginRight() != null)
                this.marginRight = configuration.getMarginRight();
            if(configuration.getMarginTop() != null)
                this.marginTop = configuration.getMarginTop();
            if(configuration.getMarginBottom() != null)
                this.marginBottom = configuration.getMarginBottom();
            return this;
        }

        /** Add a newline before every box. This helps with loggers that add tags and other stuff
         *  before every printout which splits the first line of the box (example: Logcat in
         *  Android). */
        @NotNull
        public Builder setPrefixEveryPrintWithNewline(@Nullable Boolean shouldPrefix) {
            this.prefixEveryPrintWithNewline = shouldPrefix;
            return this;
        }

        /** Number of characters to show per line. If wrapContent is set to true, this represents
         *  only the maximum possible width of the box. If wrapContent is set to false, this
         *  represents the fixed width of the box.<br/>
         *  Note: both the horizontal padding and margin are included in the charsPerLine value. */
        @NotNull
        public Builder setCharsPerLine(@Nullable Integer charsPerLine) {
            this.charsPerLine = charsPerLine;
            return this;
        }

        /** If set to true, the box will take the minimum width needed to show all content without
         *  splitting lines, if possible. The box will not be wider than charsPerLine.<br/>
         *  If set to false, the box will have a fixed width of charsPerLine */
        @NotNull
        public Builder setWrapContent(@Nullable Boolean wrapContent) {
            this.wrapContent = wrapContent;
            return this;
        }

        /** If set to true, the box will be closed on the left side.<br/>
         *  If set to false, the left side of the box will be left open. */
        @NotNull
        public Builder setBorderLeft(@Nullable Boolean borderLeft) {
            this.borderLeft = borderLeft;
            return this;
        }

        /** If set to true, the box will be closed on the right side.<br/>
         *  If set to false, the right side of the box will be left open.<br/>
         *  Note: many "monospaced" fonts are not fully monospaced so closed boxes might not work
         *  properly (i.e. the lengths of the lines won't be the same). In that case you should set
         *  this value to false. */
        @NotNull
        public Builder setBorderRight(@Nullable Boolean borderRight) {
            this.borderRight = borderRight;
            return this;
        }

        @NotNull
        public Builder setBorderTop(@Nullable Boolean borderTop) {
            this.borderTop = borderTop;
            return this;
        }
        // TODO doc, readme
        @NotNull
        public Builder setBorderBottom(@Nullable Boolean borderBottom) {
            this.borderBottom = borderBottom;
            return this;
        }
        @NotNull
        public Builder setVerticalBorders(@Nullable Boolean verticalBorders) {
            setBorderLeft(verticalBorders);
            setBorderRight(verticalBorders);
            return this;
        }
        @NotNull
        public Builder setHorizontalBorders(@Nullable Boolean horizontalBorders) {
            setBorderTop(horizontalBorders);
            setBorderBottom(horizontalBorders);
            return this;
        }
        @NotNull
        public Builder setBorders(@Nullable Boolean borders) {
            setVerticalBorders(borders);
            setHorizontalBorders(borders);
            return this;
        }

        /** Sets the number of spaces between the text and the left/right sides of the box. Is part
         *  of the box width, e.g. a closed box with edges 1 space wide, horizontal padding of 10,
         *  and width of 40 would have 18 spaces left for content. */ // TODO
        @NotNull
        public Builder setPaddingLeft(@Nullable Integer paddingLeft) {
            this.paddingLeft = paddingLeft;
            return this;
        }
        @NotNull
        public Builder setPaddingRight(@Nullable Integer paddingRight) {
            this.paddingRight = paddingRight;
            return this;
        }
        @NotNull
        public Builder setPaddingTop(@Nullable Integer paddingTop) {
            this.paddingTop = paddingTop;
            return this;
        }
        @NotNull
        public Builder setPaddingBottom(@Nullable Integer paddingBottom) {
            this.paddingBottom = paddingBottom;
            return this;
        }
        /** Sets the number of spaces between the text and the left/right sides of the box. Is part
         *  of the box width, e.g. a closed box with edges 1 space wide, horizontal padding of 10,
         *  and width of 40 would have 18 spaces left for content. */
        @NotNull
        public Builder setHorizontalPadding(@Nullable Integer horizontalPadding) {
            setPaddingLeft(horizontalPadding);
            setPaddingRight(horizontalPadding);
            return this;
        }
        /** Sets the number of newlines between the text and the top/bottom sides of the box. */
        @NotNull
        public Builder setVerticalPadding(@Nullable Integer verticalPadding) {
            setPaddingTop(verticalPadding);
            setPaddingBottom(verticalPadding);
            return this;
        }
        @NotNull
        public Builder setPadding(@Nullable Integer padding) {
            setVerticalPadding(padding);
            setHorizontalPadding(padding);
            return this;
        }

        /** Sets the number of spaces between the box left/right sides and the surrounding elements
         *  (e.g. line start, other boxes). Is part of the box width, e.g. a closed box with edges 1
         *  space wide, horizontal margin of 10, and width of 40 would have 18 spaces left for
         *  content. */ // TODO
        @NotNull
        public Builder setMarginLeft(@Nullable Integer marginLeft) {
            this.marginLeft = marginLeft;
            return this;
        }
        @NotNull
        public Builder setMarginRight(@Nullable Integer marginRight) {
            this.marginRight = marginRight;
            return this;
        }
        @NotNull
        public Builder setMarginTop(@Nullable Integer marginTop) {
            this.marginTop = marginTop;
            return this;
        }
        @NotNull
        public Builder setMarginBottom(@Nullable Integer marginBottom) {
            this.marginBottom = marginBottom;
            return this;
        }
        /** Sets the number of spaces between the box left/right sides and the surrounding elements
         *  (e.g. line start, other boxes). Is part of the box width, e.g. a closed box with edges 1
         *  space wide, horizontal margin of 10, and width of 40 would have 18 spaces left for
         *  content. */
        @NotNull
        public Builder setHorizontalMargin(@Nullable Integer horizontalMargin) {
            setMarginLeft(horizontalMargin);
            setMarginRight(horizontalMargin);
            return this;
        }
        /** Sets the number of newlines before and after the box is drawn. */
        @NotNull
        public Builder setVerticalMargin(@Nullable Integer verticalMargin) {
            setMarginTop(verticalMargin);
            setMarginBottom(verticalMargin);
            return this;
        }
        @NotNull
        public Builder setMargin(@Nullable Integer margin) {
            setVerticalMargin(margin);
            setHorizontalMargin(margin);
            return this;
        }

        @NotNull
        public PrettyBoxConfiguration build() {
            return new PrettyBoxConfiguration(
                    prefixEveryPrintWithNewline,
                    charsPerLine,
                    wrapContent,
                    borderLeft, borderRight, borderTop, borderBottom,
                    paddingLeft, paddingRight, paddingTop, paddingBottom,
                    marginLeft, marginRight, marginTop, marginBottom);
        }

    }

}
