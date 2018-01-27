package com.entity;

import java.sql.Date;

public class CheckStatus {

    private int notUniqueCnt;
    private int rowCount;
    private int intValNullCnt;
    private int floatValNullCnt;
    private int charValNullCnt;
    private int dateValNullCnt;
    private int intValZeroCnt;
    private int floatValZeroCnt;
    private int charValZeroCnt;
    private int dateValZeroCnt;
    private int intValAvg;
    private int floatValAvg;
    private int charValAvg;
    private int dateValAvg;

    private CheckStatus() {}

    public int getNotUniqueCnt() {
        return notUniqueCnt;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getIntValNullCnt() {
        return intValNullCnt;
    }

    public int getFloatValNullCnt() {
        return floatValNullCnt;
    }

    public int getCharValNullCnt() {
        return charValNullCnt;
    }

    public int getDateValNullCnt() {
        return dateValNullCnt;
    }

    public int getIntValZeroCnt() {
        return intValZeroCnt;
    }

    public int getFloatValZeroCnt() {
        return floatValZeroCnt;
    }

    public int getCharValZeroCnt() {
        return charValZeroCnt;
    }

    public int getDateValZeroCnt() {
        return dateValZeroCnt;
    }

    public int getIntValAvg() {
        return intValAvg;
    }

    public int getFloatValAvg() {
        return floatValAvg;
    }

    public int getCharValAvg() {
        return charValAvg;
    }

    public int getDateValAvg() {
        return dateValAvg;
    }

    @Override
    public String toString() {
        return String.format(
                "CheckStatus[notUniqueCnt='%d', rowCount='%d'" +
                        ", intValNullCnt='%d', floatValNullCnt='%d', charValNullCnt='%d', dateValNullCnt='%d'" +
                        ", intValZeroCnt='%d', floatValZeroCnt='%d', charValZeroCnt='%d', dateValZeroCnt='%d'" +
                        ", intValAvg='%d', floatValAvg='%d', charValAvg='%d', dateValAvg='%d']",
                notUniqueCnt, rowCount,
                intValNullCnt, floatValNullCnt, charValNullCnt, dateValNullCnt,
                intValZeroCnt, floatValZeroCnt, charValZeroCnt, dateValZeroCnt,
                intValAvg, floatValAvg, charValAvg, dateValAvg);
    }

    public static Builder newBuilder() {
        return new CheckStatus().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setNotUniqueCnt(int notUniqueCnt) {
            CheckStatus.this.notUniqueCnt = notUniqueCnt;

            return this;
        }

        public Builder setRowCount(int rowCount) {
            CheckStatus.this.rowCount = rowCount;

            return this;
        }

        public Builder setIntValNullCnt(int intValNullCnt) {
            CheckStatus.this.intValNullCnt = intValNullCnt;

            return this;
        }

        public Builder setFloatValNullCnt(int floatValNullCnt) {
            CheckStatus.this.floatValNullCnt = floatValNullCnt;

            return this;
        }

        public Builder setCharValNullCnt(int charValNullCnt) {
            CheckStatus.this.charValNullCnt = charValNullCnt;

            return this;
        }

        public Builder setDateValNullCnt(int dateValNullCnt) {
            CheckStatus.this.dateValNullCnt = dateValNullCnt;

            return this;
        }

        public Builder setIntValZeroCnt(int intValZeroCnt) {
            CheckStatus.this.intValZeroCnt = intValZeroCnt;

            return this;
        }

        public Builder setFloatValZeroCnt(int floatValZeroCnt) {
            CheckStatus.this.floatValZeroCnt = floatValZeroCnt;

            return this;
        }

        public Builder setCharValZeroCnt(int charValZeroCnt) {
            CheckStatus.this.charValZeroCnt = charValZeroCnt;

            return this;
        }

        public Builder setDateValZeroCnt(int dateValZeroCnt) {
            CheckStatus.this.dateValZeroCnt = dateValZeroCnt;

            return this;
        }

        public Builder setIntValAvg(int intValAvg) {
            CheckStatus.this.intValAvg = intValAvg;

            return this;
        }

        public Builder setFloatValAvg(int floatValAvg) {
            CheckStatus.this.floatValAvg = floatValAvg;

            return this;
        }

        public Builder setCharValAvg(int charValAvg) {
            CheckStatus.this.charValAvg = charValAvg;

            return this;
        }

        public Builder setDateValAvg(int dateValAvg) {
            CheckStatus.this.dateValAvg = dateValAvg;

            return this;
        }

        public CheckStatus build() {
            return CheckStatus.this;
        }
    }

}
