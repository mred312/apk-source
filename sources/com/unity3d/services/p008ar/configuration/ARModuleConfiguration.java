package com.unity3d.services.p008ar.configuration;

import com.unity3d.services.ads.configuration.IAdsModuleConfiguration;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.p008ar.ARCheck;
import com.unity3d.services.p008ar.ARUtils;
import com.unity3d.services.p008ar.api.C3855AR;
import com.unity3d.services.p008ar.view.ARViewHandler;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.unity3d.services.ar.configuration.ARModuleConfiguration */
public class ARModuleConfiguration implements IAdsModuleConfiguration {
    public Map<String, Class> getAdUnitViewHandlers() {
        HashMap hashMap = new HashMap();
        hashMap.put("arview", ARViewHandler.class);
        return hashMap;
    }

    public Class[] getWebAppApiClassList() {
        return new Class[]{C3855AR.class};
    }

    public boolean initCompleteState(Configuration configuration) {
        return true;
    }

    public boolean initErrorState(Configuration configuration, String str, String str2) {
        return true;
    }

    public boolean initModuleState(Configuration configuration) {
        if (!ARCheck.isFrameworkPresent()) {
            return true;
        }
        ARUtils.isSupported(ClientProperties.getApplicationContext());
        return true;
    }

    public boolean resetState(Configuration configuration) {
        return true;
    }
}
