package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {

    /* renamed from: a */
    private final Set<Request> f6270a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private final List<Request> f6271b = new ArrayList();

    /* renamed from: c */
    private boolean f6272c;

    public boolean clearAndRemove(@Nullable Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f6270a.remove(request);
        if (!this.f6271b.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public void clearRequests() {
        for (T clearAndRemove : Util.getSnapshot(this.f6270a)) {
            clearAndRemove(clearAndRemove);
        }
        this.f6271b.clear();
    }

    public boolean isPaused() {
        return this.f6272c;
    }

    public void pauseAllRequests() {
        this.f6272c = true;
        for (T t : Util.getSnapshot(this.f6270a)) {
            if (t.isRunning() || t.isComplete()) {
                t.clear();
                this.f6271b.add(t);
            }
        }
    }

    public void pauseRequests() {
        this.f6272c = true;
        for (T t : Util.getSnapshot(this.f6270a)) {
            if (t.isRunning()) {
                t.pause();
                this.f6271b.add(t);
            }
        }
    }

    public void restartRequests() {
        for (T t : Util.getSnapshot(this.f6270a)) {
            if (!t.isComplete() && !t.isCleared()) {
                t.clear();
                if (!this.f6272c) {
                    t.begin();
                } else {
                    this.f6271b.add(t);
                }
            }
        }
    }

    public void resumeRequests() {
        this.f6272c = false;
        for (T t : Util.getSnapshot(this.f6270a)) {
            if (!t.isComplete() && !t.isRunning()) {
                t.begin();
            }
        }
        this.f6271b.clear();
    }

    public void runRequest(@NonNull Request request) {
        this.f6270a.add(request);
        if (!this.f6272c) {
            request.begin();
            return;
        }
        request.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f6271b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f6270a.size() + ", isPaused=" + this.f6272c + "}";
    }
}
