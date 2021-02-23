package com.google.android.gms.internal.ads;

import android.util.JsonReader;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdmw {

    /* renamed from: a */
    private String f15788a;

    zzdmw(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("description")) {
                str = jsonReader.nextString();
            } else if (!nextName.equals("code")) {
                jsonReader.skipValue();
            } else {
                jsonReader.nextInt();
            }
        }
        jsonReader.endObject();
        this.f15788a = str;
    }

    public final String getDescription() {
        return this.f15788a;
    }
}
