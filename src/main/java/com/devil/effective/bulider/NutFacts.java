package com.devil.effective.bulider;

public class NutFacts {
    private final int serSize;
    private final int fat;
    private final int car;
    private final int so;

    public static class Builder {

        // 必填字段
        private final int serSize;

        // 非必填字段
        private int fat = 0;
        private int car = 0;
        private int so = 0;

        public Builder(int serSize) {
            this.serSize = serSize;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder car(int val) {
            car = val;
            return this;
        }

        public Builder so(int val) {
            so = val;
            return this;
        }

        public NutFacts build() {
            return new NutFacts(this);
        }
    }

    private NutFacts(Builder builder) {
        serSize = builder.serSize;
        fat = builder.fat;
        car = builder.car;
        so = builder.so;
    }
}
