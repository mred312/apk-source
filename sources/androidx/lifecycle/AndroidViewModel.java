package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;

public class AndroidViewModel extends ViewModel {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c */
    private Application f3459c;

    public AndroidViewModel(@NonNull Application application) {
        this.f3459c = application;
    }

    @NonNull
    public <T extends Application> T getApplication() {
        return this.f3459c;
    }
}
