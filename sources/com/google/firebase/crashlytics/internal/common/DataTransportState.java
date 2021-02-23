package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;

public enum DataTransportState {
    NONE,
    JAVA_ONLY,
    ALL;

    @NonNull
    /* renamed from: a */
    static DataTransportState m11271a(@NonNull AppSettingsData appSettingsData) {
        boolean z = true;
        boolean z2 = appSettingsData.reportUploadVariant == 2;
        if (appSettingsData.nativeReportUploadVariant != 2) {
            z = false;
        }
        return m11272b(z2, z);
    }

    @NonNull
    /* renamed from: b */
    static DataTransportState m11272b(boolean z, boolean z2) {
        if (!z) {
            return NONE;
        }
        if (!z2) {
            return JAVA_ONLY;
        }
        return ALL;
    }
}
