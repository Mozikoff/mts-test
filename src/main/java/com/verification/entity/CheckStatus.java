package com.verification.entity;

public class CheckStatus {

    private int notUniqueCnt;
    private int rowCount;
    private int intValNullCnt;
    private int floatValNullCnt;
    private int charValNullCnt;
    private int dateValNullCnt;
    private int intValZeroCnt;
    private int floatValZeroCnt;
    private float intValAvg;
    private float floatValAvg;

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

    public float getIntValAvg() {
        return intValAvg;
    }

    public float getFloatValAvg() {
        return floatValAvg;
    }

    public static Builder newBuilder() {
        return new CheckStatus().new Builder();
    }

    @Override
    public String toString() {
        return String.format(
                "CheckStatus[notUniqueCnt='%d', rowCount='%d'" +
                        ", intValNullCnt='%d', floatValNullCnt='%d', charValNullCnt='%d', dateValNullCnt='%d'" +
                        ", intValZeroCnt='%d', floatValZeroCnt='%d'" +
                        ", intValAvg='%f', floatValAvg='%f']",
                notUniqueCnt, rowCount,
                intValNullCnt, floatValNullCnt, charValNullCnt, dateValNullCnt,
                intValZeroCnt, floatValZeroCnt,
                intValAvg, floatValAvg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckStatus that = (CheckStatus) o;

        if (notUniqueCnt != that.notUniqueCnt) return false;
        if (rowCount != that.rowCount) return false;
        if (intValNullCnt != that.intValNullCnt) return false;
        if (floatValNullCnt != that.floatValNullCnt) return false;
        if (charValNullCnt != that.charValNullCnt) return false;
        if (dateValNullCnt != that.dateValNullCnt) return false;
        if (intValZeroCnt != that.intValZeroCnt) return false;
        if (floatValZeroCnt != that.floatValZeroCnt) return false;
        if (Float.compare(intValAvg, that.intValAvg) != 0) return false;
        return Float.compare(floatValAvg, that.floatValAvg) == 0;
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

        public Builder setIntValAvg(float intValAvg) {
            CheckStatus.this.intValAvg = intValAvg;

            return this;
        }

        public Builder setFloatValAvg(float floatValAvg) {
            CheckStatus.this.floatValAvg = floatValAvg;

            return this;
        }

        public CheckStatus build() {
            return CheckStatus.this;
        }
    }

}
