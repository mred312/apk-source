package com.bumptech.glide;

public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    

    /* renamed from: a */
    private final float f5465a;

    private MemoryCategory(float f) {
        this.f5465a = f;
    }

    public float getMultiplier() {
        return this.f5465a;
    }
}
