package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Preferences {

    /* renamed from: a */
    private Context f5333a;

    /* renamed from: b */
    private SharedPreferences f5334b;

    /* renamed from: androidx.work.impl.utils.Preferences$a */
    private static class C1131a extends MutableLiveData<Long> implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* renamed from: l */
        private SharedPreferences f5335l;

        /* renamed from: m */
        private long f5336m;

        C1131a(SharedPreferences sharedPreferences) {
            this.f5335l = sharedPreferences;
            long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
            this.f5336m = j;
            postValue(Long.valueOf(j));
        }

        /* access modifiers changed from: protected */
        public void onActive() {
            super.onActive();
            this.f5335l.registerOnSharedPreferenceChangeListener(this);
        }

        /* access modifiers changed from: protected */
        public void onInactive() {
            super.onInactive();
            this.f5335l.unregisterOnSharedPreferenceChangeListener(this);
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if ("last_cancel_all_time_ms".equals(str)) {
                long j = sharedPreferences.getLong(str, 0);
                if (this.f5336m != j) {
                    this.f5336m = j;
                    setValue(Long.valueOf(j));
                }
            }
        }
    }

    public Preferences(@NonNull Context context) {
        this.f5333a = context;
    }

    /* renamed from: a */
    private SharedPreferences m4028a() {
        SharedPreferences sharedPreferences;
        synchronized (Preferences.class) {
            if (this.f5334b == null) {
                this.f5334b = this.f5333a.getSharedPreferences("androidx.work.util.preferences", 0);
            }
            sharedPreferences = this.f5334b;
        }
        return sharedPreferences;
    }

    public long getLastCancelAllTimeMillis() {
        return m4028a().getLong("last_cancel_all_time_ms", 0);
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return new C1131a(m4028a());
    }

    public boolean needsReschedule() {
        return m4028a().getBoolean("reschedule_needed", false);
    }

    public void setLastCancelAllTimeMillis(long j) {
        m4028a().edit().putLong("last_cancel_all_time_ms", j).apply();
    }

    public void setNeedsReschedule(boolean z) {
        m4028a().edit().putBoolean("reschedule_needed", z).apply();
    }

    @VisibleForTesting
    public Preferences(@NonNull SharedPreferences sharedPreferences) {
        this.f5334b = sharedPreferences;
    }
}
