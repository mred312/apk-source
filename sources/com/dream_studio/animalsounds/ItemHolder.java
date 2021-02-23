package com.dream_studio.animalsounds;

public class ItemHolder {
    public int itemPosition;
    public int itemResId;
    public String itemText;
    public int switchedPosition;

    ItemHolder() {
        this.itemResId = 0;
        this.itemPosition = 0;
        this.itemText = "";
        this.switchedPosition = 0;
    }

    ItemHolder(int i, int i2, String str, int i3) {
        this.itemResId = i;
        this.itemPosition = i2;
        this.itemText = str;
        this.switchedPosition = i3;
    }
}
