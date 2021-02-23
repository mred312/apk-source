package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class AdActivity extends Activity {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    @KeepForSdk
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzarj zzack;

    private final void zzdp() {
        zzarj zzarj = this.zzack;
        if (zzarj != null) {
            try {
                zzarj.zzdp();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzack.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        boolean z = true;
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                z = zzarj.zzve();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
            try {
                this.zzack.onBackPressed();
            } catch (RemoteException e2) {
                zzaza.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzack.zzad(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzarj zzb = zzwq.zzqb().zzb(this);
        this.zzack = zzb;
        if (zzb == null) {
            zzaza.zze("#007 Could not call remote method.", (Throwable) null);
            finish();
            return;
        }
        try {
            zzb.onCreate(bundle);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                zzarj.onDestroy();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                zzarj.onPause();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                zzarj.onRestart();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                zzarj.onResume();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                zzarj.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                zzarj.onStart();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            zzarj zzarj = this.zzack;
            if (zzarj != null) {
                zzarj.onStop();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            this.zzack.onUserLeaveHint();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zzdp();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zzdp();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdp();
    }
}
