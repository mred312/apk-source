package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a */
    long f2768a;

    /* renamed from: b */
    boolean f2769b;

    /* renamed from: c */
    boolean f2770c;

    /* renamed from: d */
    boolean f2771d;

    /* renamed from: e */
    private final Runnable f2772e;

    /* renamed from: f */
    private final Runnable f2773f;

    /* renamed from: androidx.core.widget.ContentLoadingProgressBar$a */
    class C0574a implements Runnable {
        C0574a() {
        }

        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f2769b = false;
            contentLoadingProgressBar.f2768a = -1;
            contentLoadingProgressBar.setVisibility(8);
        }
    }

    /* renamed from: androidx.core.widget.ContentLoadingProgressBar$b */
    class C0575b implements Runnable {
        C0575b() {
        }

        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f2770c = false;
            if (!contentLoadingProgressBar.f2771d) {
                contentLoadingProgressBar.f2768a = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    }

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m1943a() {
        removeCallbacks(this.f2772e);
        removeCallbacks(this.f2773f);
    }

    public synchronized void hide() {
        this.f2771d = true;
        removeCallbacks(this.f2773f);
        this.f2770c = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f2768a;
        long j2 = currentTimeMillis - j;
        if (j2 < 500) {
            if (j != -1) {
                if (!this.f2769b) {
                    postDelayed(this.f2772e, 500 - j2);
                    this.f2769b = true;
                }
            }
        }
        setVisibility(8);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m1943a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1943a();
    }

    public synchronized void show() {
        this.f2768a = -1;
        this.f2771d = false;
        removeCallbacks(this.f2772e);
        this.f2769b = false;
        if (!this.f2770c) {
            postDelayed(this.f2773f, 500);
            this.f2770c = true;
        }
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2768a = -1;
        this.f2769b = false;
        this.f2770c = false;
        this.f2771d = false;
        this.f2772e = new C0574a();
        this.f2773f = new C0575b();
    }
}
