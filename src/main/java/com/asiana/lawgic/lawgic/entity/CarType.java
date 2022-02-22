package com.asiana.lawgic.lawgic.entity;

public enum CarType {
    CITY_CAR, SUBCOMPACT_CAR, COMPACT_CAR, MID_SIZE_CAR, FULL_SIZE_LUXURY_CAR, LARGE_SIZE_CAR, SPORTS_CAR;

    public static CarType convertToCarType(int num) {
        CarType ct = null;
        switch(num) {
            case 1:
                ct = CarType.CITY_CAR;
                break;
            case 2:
                ct = CarType.SUBCOMPACT_CAR;
                break;
            case 3:
                ct = CarType.COMPACT_CAR;
                break;
            case 4:
                ct = CarType.MID_SIZE_CAR;
                break;
            case 5:
                ct = CarType.FULL_SIZE_LUXURY_CAR;
                break;
            case 6:
                ct = CarType.LARGE_SIZE_CAR;
                break;
            case 7:
                ct = CarType.SPORTS_CAR;
                break;
        }
        return ct;
    }
}
