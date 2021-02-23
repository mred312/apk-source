package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a */
    private final int f19532a;

    /* renamed from: b */
    private final StackTraceTrimmingStrategy[] f19533b;

    /* renamed from: c */
    private final MiddleOutStrategy f19534c;

    public MiddleOutFallbackStrategy(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f19532a = i;
        this.f19533b = stackTraceTrimmingStrategyArr;
        this.f19534c = new MiddleOutStrategy(i);
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f19532a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f19533b) {
            if (stackTraceElementArr2.length <= this.f19532a) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.getTrimmedStackTrace(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f19532a ? this.f19534c.getTrimmedStackTrace(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
