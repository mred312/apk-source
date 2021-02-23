package com.dream_studio.animalsounds.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Build;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.dream_studio.animalsounds.BaseActivity;
import com.dream_studio.animalsounds.C1441R;
import com.dream_studio.animalsounds.LangListAdapter;
import com.dream_studio.animalsounds.Languages;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.medio.locale.LocaleManager;
import java.util.Locale;

public class Utilities {

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$a */
    static class C1476a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Languages f6895a;

        /* renamed from: b */
        final /* synthetic */ LangListAdapter f6896b;

        C1476a(Languages languages, LangListAdapter langListAdapter) {
            this.f6895a = languages;
            this.f6896b = langListAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6895a.selectedItem = i;
            this.f6896b.notifyDataSetChanged();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$b */
    static class C1477b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Languages f6897a;

        /* renamed from: b */
        final /* synthetic */ Languages f6898b;

        /* renamed from: c */
        final /* synthetic */ Context f6899c;

        /* renamed from: d */
        final /* synthetic */ Activity f6900d;

        /* renamed from: e */
        final /* synthetic */ boolean f6901e;

        C1477b(Languages languages, Languages languages2, Context context, Activity activity, boolean z) {
            this.f6897a = languages;
            this.f6898b = languages2;
            this.f6899c = context;
            this.f6900d = activity;
            this.f6901e = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Languages languages = this.f6897a;
            Languages languages2 = this.f6898b;
            languages.selectedItem = languages2.selectedItem;
            Locale locale = languages2.langList.get(languages2.selectedItem).langListLocale;
            LocaleManager.setCountry(this.f6899c, locale.getCountry());
            LocaleManager.setNewLocale(this.f6899c, locale.getLanguage());
            dialogInterface.dismiss();
            com.medio.myutilities.Utilities.restart(this.f6900d, this.f6901e);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$c */
    static class C1478c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Context f6902a;

        /* renamed from: b */
        final /* synthetic */ Activity f6903b;

        /* renamed from: c */
        final /* synthetic */ boolean f6904c;

        C1478c(Context context, Activity activity, boolean z) {
            this.f6902a = context;
            this.f6903b = activity;
            this.f6904c = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            LocaleManager.setSystemLanguage(this.f6902a);
            dialogInterface.cancel();
            com.medio.myutilities.Utilities.restart(this.f6903b, this.f6904c);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$d */
    static class C1479d implements DialogInterface.OnClickListener {
        C1479d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$e */
    static class C1480e implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ Activity f6905a;

        C1480e(Activity activity) {
            this.f6905a = activity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f6905a.getClass().getSuperclass().getSimpleName().equals(BaseActivity.class.getSimpleName())) {
                ((BaseActivity) this.f6905a).setMuteButton();
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$f */
    static class C1481f implements DialogInterface.OnClickListener {
        C1481f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$g */
    static class C1482g implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Activity f6906a;

        C1482g(Activity activity) {
            this.f6906a = activity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            BaseActivity.storeNonPersonalizationAdsStatus(this.f6906a, z);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.util.Utilities$h */
    static class C1483h implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ Activity f6907a;

        /* renamed from: b */
        final /* synthetic */ WebView f6908b;

        C1483h(Activity activity, WebView webView) {
            this.f6907a = activity;
            this.f6908b = webView;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f6907a.getClass().getSuperclass().getSimpleName().equals(BaseActivity.class.getSimpleName())) {
                ((BaseActivity) this.f6907a).setMuteButton();
                ((BaseActivity) this.f6907a).switchAdsPersonalization();
            }
            this.f6908b.stopLoading();
            this.f6908b.clearHistory();
            this.f6908b.clearCache(true);
            this.f6908b.destroy();
        }
    }

    /* renamed from: a */
    private static boolean m4956a(Activity activity, int i) {
        if (activity.getResources().getDisplayMetrics().widthPixels >= ((int) TypedValue.applyDimension(1, (float) i, activity.getResources().getDisplayMetrics()))) {
            return true;
        }
        return false;
    }

    public static void fitBannerAds(Activity activity, AdView adView) {
        if (m4956a(activity, 728)) {
            adView.setAdSize(AdSize.LEADERBOARD);
        } else if (m4956a(activity, 468)) {
            adView.setAdSize(AdSize.FULL_BANNER);
        } else {
            adView.setAdSize(AdSize.BANNER);
        }
    }

    public static ContextThemeWrapper getContextThemeWrapper(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return new ContextThemeWrapper(context, C1441R.style.MyAlertDialogStyle);
        }
        return new ContextThemeWrapper(context, 16973837);
    }

    public static void showLanguageDialog(@NonNull Context context, @NonNull Languages languages) {
        showLanguageDialog(context, languages, false);
    }

    public static void showTermsOfUseDialog(@NonNull Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContextThemeWrapper(activity));
        try {
            View inflate = activity.getLayoutInflater().inflate(C1441R.layout.terms_of_use_dlg, (ViewGroup) null);
            builder.setView(inflate);
            WebView webView = (WebView) inflate.findViewById(C1441R.C1443id.webview);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setScrollBarStyle(0);
            int i = Build.VERSION.SDK_INT;
            if (i < 18) {
                webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            }
            if (i >= 19) {
                webView.setLayerType(2, (Paint) null);
            } else if (i >= 11) {
                webView.setLayerType(1, (Paint) null);
            }
            webView.loadUrl("file:///android_res/raw/terms_of_use.html");
            builder.setPositiveButton(activity.getResources().getString(C1441R.string.buttonOK), new C1481f());
            Switch switchR = (Switch) inflate.findViewById(C1441R.C1443id.personalized_ads_switch);
            switchR.setChecked(BaseActivity.getNonPersonalizationAdsStatus(activity));
            switchR.setOnCheckedChangeListener(new C1482g(activity));
            AlertDialog create = builder.create();
            create.setOnDismissListener(new C1483h(activity, webView));
            create.setCancelable(false);
            create.setOwnerActivity(activity);
            create.show();
        } catch (Exception unused) {
        }
    }

    public static void showLanguageDialog(@NonNull Context context, @NonNull Languages languages, boolean z) {
        Activity activity = (Activity) context;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContextThemeWrapper(context));
        builder.setTitle(context.getResources().getString(C1441R.string.changeLangTitle));
        if (Build.VERSION.SDK_INT == 17) {
            TextView textView = new TextView(getContextThemeWrapper(context));
            textView.setText(context.getResources().getString(C1441R.string.changeLangTitle));
            textView.setGravity(3);
            textView.setPadding(15, 15, 15, 15);
            textView.setTextSize(20.0f);
            textView.setTextColor(ContextCompat.getColor(context, 17170450));
            builder.setCustomTitle(textView);
        }
        Languages languages2 = new Languages();
        languages2.selectedItem = languages.selectedItem;
        LangListAdapter langListAdapter = new LangListAdapter(context, C1441R.layout.lang_list_item, languages2);
        builder.setSingleChoiceItems(langListAdapter, languages.selectedItem, new C1476a(languages2, langListAdapter));
        builder.setPositiveButton(context.getResources().getString(C1441R.string.buttonOK), new C1477b(languages, languages2, context, activity, z));
        builder.setNeutralButton(activity.getResources().getString(C1441R.string.buttonSystem), new C1478c(context, activity, z));
        builder.setNegativeButton(activity.getResources().getString(C1441R.string.buttonCancel), new C1479d());
        AlertDialog create = builder.create();
        create.setOnDismissListener(new C1480e(activity));
        create.setOwnerActivity(activity);
        create.show();
    }
}
