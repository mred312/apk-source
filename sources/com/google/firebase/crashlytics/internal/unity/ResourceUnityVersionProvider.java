package com.google.firebase.crashlytics.internal.unity;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

public class ResourceUnityVersionProvider implements UnityVersionProvider {

    /* renamed from: a */
    private final Context f19537a;

    /* renamed from: b */
    private boolean f19538b = false;

    /* renamed from: c */
    private String f19539c;

    public ResourceUnityVersionProvider(Context context) {
        this.f19537a = context;
    }

    public String getUnityVersion() {
        if (!this.f19538b) {
            this.f19539c = CommonUtils.resolveUnityEditorVersion(this.f19537a);
            this.f19538b = true;
        }
        String str = this.f19539c;
        if (str != null) {
            return str;
        }
        return null;
    }
}
