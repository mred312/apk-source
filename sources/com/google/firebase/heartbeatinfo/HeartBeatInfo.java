package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: a */
        private final int f19570a;

        private HeartBeat(int i) {
            this.f19570a = i;
        }

        public int getCode() {
            return this.f19570a;
        }
    }

    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);
}
