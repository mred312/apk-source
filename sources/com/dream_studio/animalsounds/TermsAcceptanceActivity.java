package com.dream_studio.animalsounds;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.dream_studio.animalsounds.util.Utilities;
import com.medio.locale.LocaleManager;

public class TermsAcceptanceActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f6836a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f6837b = null;

    /* renamed from: c */
    private String f6838c = "";

    /* renamed from: d */
    private String f6839d = "";
    public final Languages mLanguages = new Languages();

    public class SpanHolder {
        public int endPos = 0;
        public int startPos = 0;
        public String string = null;

        public SpanHolder(TermsAcceptanceActivity termsAcceptanceActivity) {
        }
    }

    /* renamed from: com.dream_studio.animalsounds.TermsAcceptanceActivity$a */
    class C1449a implements View.OnClickListener {
        C1449a() {
        }

        public void onClick(View view) {
            Utilities.showTermsOfUseDialog(TermsAcceptanceActivity.this.f6837b);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.TermsAcceptanceActivity$b */
    class C1450b implements View.OnClickListener {
        C1450b() {
        }

        public void onClick(View view) {
            Utilities.showLanguageDialog(TermsAcceptanceActivity.this.f6836a, TermsAcceptanceActivity.this.mLanguages, true);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.TermsAcceptanceActivity$c */
    class C1451c implements View.OnClickListener {
        C1451c() {
        }

        public void onClick(View view) {
            TermsAndPolicyAcceptance.storeTermsAccepted(TermsAcceptanceActivity.this.f6837b);
            TermsAcceptanceActivity.this.finish();
        }
    }

    public static void applySpan(SpannableString spannableString, String str, ClickableSpan clickableSpan) {
        int indexOf = spannableString.toString().indexOf(str);
        spannableString.setSpan(clickableSpan, indexOf, str.length() + indexOf, 33);
    }

    /* renamed from: c */
    private SpanHolder m4921c(String str) {
        SpanHolder spanHolder = new SpanHolder(this);
        spanHolder.startPos = str.indexOf("{0}");
        String replace = str.replace("{0}", "");
        spanHolder.endPos = replace.indexOf("{1}");
        spanHolder.string = replace.replace("{1}", "");
        return spanHolder;
    }

    /* renamed from: d */
    private void m4922d() {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#FF0e5994"));
        }
    }

    public static Spanned fromHtml(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        this.f6838c = LocaleManager.getLanguage(context);
        this.f6839d = LocaleManager.getCountry(context);
        super.attachBaseContext(LocaleManager.updateConfig(context, this.f6838c));
    }

    public void onBackPressed() {
        ActivityCompat.finishAffinity(this.f6837b);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LocaleManager.updateConfig(this.f6836a, configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6837b = this;
        this.f6836a = this;
        com.medio.myutilities.Utilities.checkAndPrepareLanguage(this, this.mLanguages, this.f6838c, this.f6839d, true);
        setContentView(C1441R.layout.activity_terms_acceptance);
        m4922d();
        Typeface createFromAsset = Typeface.createFromAsset(this.f6837b.getAssets(), "fonts/Lato-Black.ttf");
        TextView textView = (TextView) findViewById(C1441R.C1443id.license_info);
        textView.setTypeface(createFromAsset);
        SpanHolder c = m4921c(getString(C1441R.string.license_info));
        SpannableString spannableString = new SpannableString(c.string);
        spannableString.setSpan(new UnderlineSpan(), c.startPos, c.endPos, 33);
        textView.setText(spannableString);
        textView.setOnClickListener(new C1449a());
        TextView textView2 = (TextView) findViewById(C1441R.C1443id.text_welcome);
        textView2.setTypeface(createFromAsset);
        textView2.setText(C1441R.string.welcome);
        Button button = (Button) findViewById(C1441R.C1443id.languageBtn);
        button.setTypeface(createFromAsset);
        Languages languages = this.mLanguages;
        button.setText(languages.langList.get(languages.selectedItem).langListLocale.getDisplayLanguage());
        button.setOnClickListener(new C1450b());
        Button button2 = (Button) findViewById(C1441R.C1443id.acceptBtn);
        button2.setTypeface(createFromAsset);
        button2.setOnClickListener(new C1451c());
    }
}
