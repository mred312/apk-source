package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.C1484Ad;

public interface FullScreenAd extends C1484Ad {

    @Keep
    public interface ShowAdConfig {
    }

    @Keep
    public interface ShowConfigBuilder {
        ShowAdConfig build();
    }

    C1484Ad.LoadConfigBuilder buildLoadAdConfig();

    ShowConfigBuilder buildShowAdConfig();

    boolean show();
}
