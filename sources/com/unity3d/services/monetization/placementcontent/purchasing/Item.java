package com.unity3d.services.monetization.placementcontent.purchasing;

public class Item {
    private String itemId;
    private long quantity;
    private String type;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String itemId;
        /* access modifiers changed from: private */
        public long quantity;
        /* access modifiers changed from: private */
        public String type;

        public Item build() {
            return new Item(this);
        }

        public Builder withItemId(String str) {
            this.itemId = str;
            return this;
        }

        public Builder withQuantity(long j) {
            this.quantity = j;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getItemId() {
        return this.itemId;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public String getType() {
        return this.type;
    }

    private Item(Builder builder) {
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
        this.type = builder.type;
    }
}
