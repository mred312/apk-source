package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {

    /* renamed from: g */
    private static final StackTraceElement[] f5685g = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final List<Throwable> f5686a;

    /* renamed from: b */
    private Key f5687b;

    /* renamed from: c */
    private DataSource f5688c;

    /* renamed from: d */
    private Class<?> f5689d;

    /* renamed from: e */
    private String f5690e;
    @Nullable

    /* renamed from: f */
    private Exception f5691f;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    /* renamed from: a */
    private void m4230a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable a : ((GlideException) th).getCauses()) {
                m4230a(a, list);
            }
            return;
        }
        list.add(th);
    }

    /* renamed from: b */
    private static void m4231b(List<Throwable> list, Appendable appendable) {
        try {
            m4232c(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private static void m4232c(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).m4234e(appendable);
            } else {
                m4233d(th, appendable);
            }
            i = i2;
        }
    }

    /* renamed from: d */
    private static void m4233d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    /* renamed from: e */
    private void m4234e(Appendable appendable) {
        m4233d(this, appendable);
        m4231b(getCauses(), new C1191a(appendable));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo9464f(Key key, DataSource dataSource) {
        mo9466g(key, dataSource, (Class<?>) null);
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo9466g(Key key, DataSource dataSource, Class<?> cls) {
        this.f5687b = key;
        this.f5688c = dataSource;
        this.f5689d = cls;
    }

    public List<Throwable> getCauses() {
        return this.f5686a;
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f5690e);
        String str3 = "";
        if (this.f5689d != null) {
            str = ", " + this.f5689d;
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.f5688c != null) {
            str2 = ", " + this.f5688c;
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (this.f5687b != null) {
            str3 = ", " + this.f5687b;
        }
        sb.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" causes:");
        }
        for (Throwable next : rootCauses) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append('(');
            sb.append(next.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.f5691f;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        m4230a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), rootCauses.get(i));
            i = i2;
        }
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setOrigin(@Nullable Exception exc) {
        this.f5691f = exc;
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public void printStackTrace(PrintStream printStream) {
        m4234e(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.f5690e = str;
        setStackTrace(f5685g);
        this.f5686a = list;
    }

    public void printStackTrace(PrintWriter printWriter) {
        m4234e(printWriter);
    }

    /* renamed from: com.bumptech.glide.load.engine.GlideException$a */
    private static final class C1191a implements Appendable {

        /* renamed from: a */
        private final Appendable f5692a;

        /* renamed from: b */
        private boolean f5693b = true;

        C1191a(Appendable appendable) {
            this.f5692a = appendable;
        }

        @NonNull
        /* renamed from: a */
        private CharSequence m4237a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c) {
            boolean z = false;
            if (this.f5693b) {
                this.f5693b = false;
                this.f5692a.append("  ");
            }
            if (c == 10) {
                z = true;
            }
            this.f5693b = z;
            this.f5692a.append(c);
            return this;
        }

        public Appendable append(@Nullable CharSequence charSequence) {
            CharSequence a = m4237a(charSequence);
            append(a, 0, a.length());
            return this;
        }

        public Appendable append(@Nullable CharSequence charSequence, int i, int i2) {
            CharSequence a = m4237a(charSequence);
            boolean z = false;
            if (this.f5693b) {
                this.f5693b = false;
                this.f5692a.append("  ");
            }
            if (a.length() > 0 && a.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.f5693b = z;
            this.f5692a.append(a, i, i2);
            return this;
        }
    }
}
