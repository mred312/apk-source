package androidx.media;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.versionedparcelable.VersionedParcelable;

/* renamed from: androidx.media.a */
/* compiled from: AudioAttributesImpl */
interface C0840a extends VersionedParcelable {
    /* renamed from: a */
    int mo6551a();

    /* renamed from: b */
    Object mo6552b();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();

    @NonNull
    Bundle toBundle();
}
