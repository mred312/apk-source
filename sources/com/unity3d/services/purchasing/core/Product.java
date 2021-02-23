package com.unity3d.services.purchasing.core;

public class Product {
    private String isoCurrencyCode;
    private String localizedDescription;
    private double localizedPrice;
    private String localizedPriceString;
    private String localizedTitle;
    private String productId;
    private String productType;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String isoCurrencyCode;
        /* access modifiers changed from: private */
        public String localizedDescription;
        /* access modifiers changed from: private */
        public double localizedPrice;
        /* access modifiers changed from: private */
        public String localizedPriceString;
        /* access modifiers changed from: private */
        public String localizedTitle;
        /* access modifiers changed from: private */
        public String productId;
        /* access modifiers changed from: private */
        public String productType;

        public Product build() {
            return new Product(this);
        }

        public Builder withIsoCurrencyCode(String str) {
            this.isoCurrencyCode = str;
            return this;
        }

        public Builder withLocalizedDescription(String str) {
            this.localizedDescription = str;
            return this;
        }

        public Builder withLocalizedPrice(double d) {
            this.localizedPrice = d;
            return this;
        }

        public Builder withLocalizedPriceString(String str) {
            this.localizedPriceString = str;
            return this;
        }

        public Builder withLocalizedTitle(String str) {
            this.localizedTitle = str;
            return this;
        }

        public Builder withProductId(String str) {
            this.productId = str;
            return this;
        }

        public Builder withProductType(String str) {
            this.productType = str;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getIsoCurrencyCode() {
        return this.isoCurrencyCode;
    }

    public String getLocalizedDescription() {
        return this.localizedDescription;
    }

    public double getLocalizedPrice() {
        return this.localizedPrice;
    }

    public String getLocalizedPriceString() {
        return this.localizedPriceString;
    }

    public String getLocalizedTitle() {
        return this.localizedTitle;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductType() {
        return this.productType;
    }

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.localizedPriceString = builder.localizedPriceString;
        this.localizedTitle = builder.localizedTitle;
        this.isoCurrencyCode = builder.isoCurrencyCode;
        this.localizedPrice = builder.localizedPrice;
        this.localizedDescription = builder.localizedDescription;
        this.productType = builder.productType;
    }
}
