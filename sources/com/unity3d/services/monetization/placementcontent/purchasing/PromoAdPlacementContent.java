package com.unity3d.services.monetization.placementcontent.purchasing;

import com.unity3d.services.monetization.placementcontent.ads.ShowAdPlacementContent;
import java.util.Map;

public class PromoAdPlacementContent extends ShowAdPlacementContent {
    private final PromoMetadata promoMetadata;

    public PromoAdPlacementContent(String str, Map<String, Object> map) {
        super(str, map);
        this.promoMetadata = PromoMetadataUtilities.createPromoMetadataFromParamsMap(map);
    }

    /* access modifiers changed from: protected */
    public String getDefaultEventCategory() {
        return "PROMO";
    }

    public PromoMetadata getMetadata() {
        return this.promoMetadata;
    }
}
