package com.google.android.datatransport.cct.p006a;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@AutoValue
@Encodable
/* renamed from: com.google.android.datatransport.cct.a.zzo */
public abstract class zzo {
    @NonNull
    public static zzo zza(@NonNull List<zzr> list) {
        return new C1553b(list);
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public abstract List<zzr> zza();
}
