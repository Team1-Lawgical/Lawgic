package com.asiana.lawgic.lawgic.entity;

public enum Category {
    CAR_TO_CAR, CAT_TO_PERSON, CAR_ONLY,RAILROAD_CROSSING;
    public static Category getCategory(int category){
        switch(category){
            case 0:
                return Category.CAR_TO_CAR;
            case 1:
                return Category.CAT_TO_PERSON;
            case 2:
                return Category.CAR_ONLY;
            case 3:
                return Category.RAILROAD_CROSSING;
            default:
                return null;
        }
    }
}
