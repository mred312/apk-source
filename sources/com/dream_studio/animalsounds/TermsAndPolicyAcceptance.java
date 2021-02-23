package com.dream_studio.animalsounds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.medio.locale.LocaleManager;
import com.unity3d.ads.metadata.MetaData;

public class TermsAndPolicyAcceptance {
    public static final String ACCEPTANCE_KEY = "acceptedTermsVer";
    public static final int TERMS_AND_POLICY_ACTIVITY = 11223344;
    public static final int TERMS_AND_POLICY_VERSION = 2;

    public static boolean CheckTermsAccepted(@NonNull Activity activity) {
        String systemCountry = LocaleManager.getSystemCountry(activity);
        if (systemCountry == "" || !"AT BE BG HR BA CY CZ DK EE FI FR GR ES NL IE LT LU LV MT DE PL PT RO SK SI SE HU IT GB".contains(systemCountry) || activity.getApplicationContext().getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).getInt(ACCEPTANCE_KEY, 0) >= 2) {
            return true;
        }
        activity.startActivityForResult(new Intent(activity, TermsAcceptanceActivity.class), TERMS_AND_POLICY_ACTIVITY);
        return false;
    }

    public static void setGDPRConsentForUnity(@NonNull Context context, boolean z) {
        MetaData metaData = new MetaData(context);
        metaData.set("gdpr.consent", Boolean.valueOf(!z));
        metaData.commit();
    }

    public static void storeTermsAccepted(@NonNull Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).edit();
        edit.putInt(ACCEPTANCE_KEY, 2);
        edit.apply();
    }
}
