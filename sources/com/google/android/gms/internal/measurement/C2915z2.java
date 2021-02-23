package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.z2 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2915z2 extends C2894w2 {

    /* renamed from: a */
    private final C2908y2 f17551a = new C2908y2();

    C2915z2() {
    }

    /* renamed from: a */
    public final void mo18540a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f17551a.mo18981a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
