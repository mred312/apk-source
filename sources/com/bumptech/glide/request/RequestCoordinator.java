package com.bumptech.glide.request;

public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        

        /* renamed from: a */
        private final boolean f6341a;

        private RequestState(boolean z) {
            this.f6341a = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo10132a() {
            return this.f6341a;
        }
    }

    boolean canNotifyCleared(Request request);

    boolean canNotifyStatusChanged(Request request);

    boolean canSetImage(Request request);

    boolean isAnyResourceSet();

    void onRequestFailed(Request request);

    void onRequestSuccess(Request request);
}
