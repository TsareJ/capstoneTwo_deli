package com.ps;

public enum BreadType {
    WHITE,
    WHEAT,
    RYE,
    WRAP;


    @Override
    public String toString() {
        return switch (this) {
            case WHITE -> "White";
            case WHEAT -> "Wheat";
            case RYE -> "Rye";
            case WRAP -> "Wrap";
        };
    }
}
