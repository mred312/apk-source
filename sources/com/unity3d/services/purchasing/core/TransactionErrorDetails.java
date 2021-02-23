package com.unity3d.services.purchasing.core;

import java.util.HashMap;
import java.util.Map;

public class TransactionErrorDetails {
    private String exceptionMessage;
    private Map<String, Object> extras;
    private Store store;
    private String storeSpecificErrorCode;
    private TransactionError transactionError;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String exceptionMessage;
        /* access modifiers changed from: private */
        public Map<String, Object> extras;
        /* access modifiers changed from: private */
        public Store store;
        /* access modifiers changed from: private */
        public String storeSpecificErrorCode;
        /* access modifiers changed from: private */
        public TransactionError transactionError;

        public TransactionErrorDetails build() {
            return new TransactionErrorDetails(this);
        }

        public Builder putExtra(String str, Object obj) {
            this.extras.put(str, obj);
            return this;
        }

        public Builder putExtras(Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                this.extras.put(next.getKey(), next.getValue());
            }
            return this;
        }

        public Builder withExceptionMessage(String str) {
            this.exceptionMessage = str;
            return this;
        }

        public Builder withStore(Store store2) {
            this.store = store2;
            return this;
        }

        public Builder withStoreSpecificErrorCode(String str) {
            this.storeSpecificErrorCode = str;
            return this;
        }

        public Builder withTransactionError(TransactionError transactionError2) {
            this.transactionError = transactionError2;
            return this;
        }

        private Builder() {
            this.extras = new HashMap();
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public Store getStore() {
        return this.store;
    }

    public String getStoreSpecificErrorCode() {
        return this.storeSpecificErrorCode;
    }

    public TransactionError getTransactionError() {
        return this.transactionError;
    }

    private TransactionErrorDetails(Builder builder) {
        this.transactionError = builder.transactionError;
        this.exceptionMessage = builder.exceptionMessage;
        this.store = builder.store;
        this.storeSpecificErrorCode = builder.storeSpecificErrorCode;
        this.extras = builder.extras;
    }
}
