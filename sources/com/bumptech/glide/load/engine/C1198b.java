package com.bumptech.glide.load.engine;

/* renamed from: com.bumptech.glide.load.engine.b */
/* compiled from: CallbackException */
final class C1198b extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    C1198b(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
