package com.dream_studio.animalsounds;

import android.content.res.Configuration;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.medio.timer.MyTimer;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.util.ArrayList;
import java.util.Arrays;

public class WikiWebView extends BaseActivity {

    /* renamed from: n */
    private ArrayList<String> f6861n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f6862o = "";

    /* renamed from: p */
    private WebView f6863p;

    /* renamed from: q */
    private MyTimer f6864q = null;

    /* renamed from: r */
    private boolean f6865r = false;
    protected boolean showWikiWebView = false;

    /* renamed from: com.dream_studio.animalsounds.WikiWebView$a */
    class C1454a implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f6866a;

        C1454a(RelativeLayout relativeLayout) {
            this.f6866a = relativeLayout;
        }

        public void onAnimationEnd(Animation animation) {
            this.f6866a.setVisibility(8);
            SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) WikiWebView.this.findViewById(C1441R.C1443id.sliding_layout);
            if (slidingUpPanelLayout != null) {
                slidingUpPanelLayout.setPanelHeight((int) WikiWebView.this.getResources().getDimension(C1441R.dimen.gallery_arrow_top_and_button_arrows_sum));
            }
            DrawerLayoutEdgeToggle drawerLayoutEdgeToggle = WikiWebView.this.mDrawerToggle;
            if (drawerLayoutEdgeToggle != null) {
                drawerLayoutEdgeToggle.getDrawerLayoutHandle().setVisibility(0);
            }
            WikiWebView.this.releaseWikiWebView();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.dream_studio.animalsounds.WikiWebView$b */
    class C1455b implements View.OnClickListener {
        C1455b() {
        }

        public void onClick(View view) {
            WikiWebView wikiWebView = WikiWebView.this;
            if (wikiWebView.lock) {
                wikiWebView.toastTop((int) C1441R.string.locked_info);
                return;
            }
            wikiWebView.showWikiWebView = true;
            wikiWebView.openWikiWebView();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.WikiWebView$c */
    class C1456c implements View.OnClickListener {
        C1456c() {
        }

        public void onClick(View view) {
            WikiWebView.this.hideWikiWebView();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.WikiWebView$d */
    private class C1457d extends WebViewClient {

        /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a */
        class C1458a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ WebView f6871a;

            /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a$a */
            class C1459a implements ValueCallback<String> {
                C1459a(C1458a aVar) {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            }

            /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a$b */
            class C1460b implements ValueCallback<String> {
                C1460b(C1458a aVar) {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            }

            /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a$c */
            class C1461c implements ValueCallback<String> {
                C1461c(C1458a aVar) {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            }

            /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a$d */
            class C1462d implements ValueCallback<String> {
                C1462d(C1458a aVar) {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            }

            /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a$e */
            class C1463e implements ValueCallback<String> {
                C1463e(C1458a aVar) {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            }

            /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a$f */
            class C1464f implements ValueCallback<String> {
                C1464f(C1458a aVar) {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            }

            /* renamed from: com.dream_studio.animalsounds.WikiWebView$d$a$g */
            class C1465g implements ValueCallback<String> {
                C1465g(C1458a aVar) {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            }

            C1458a(C1457d dVar, WebView webView) {
                this.f6871a = webView;
            }

            public void run() {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f6871a.evaluateJavascript("javascript:var aa = window.document.getElementsByClassName('header')[0]; if(aa != null) aa.style.display='none'; ", new C1459a(this));
                    this.f6871a.evaluateJavascript("javascript:var ab = window.document.getElementsByClassName('pre-content')[0]; if(ab != null) ab.style.display='none';", new C1460b(this));
                    this.f6871a.evaluateJavascript("javascript:var ac = window.document.getElementsByClassName('last-modified-bar')[0]; if(ac != null) ac.style.display='none';", new C1461c(this));
                    this.f6871a.evaluateJavascript("javascript:var ad = window.document.getElementsByClassName('read-more-container')[0]; if(ad != null) ad.style.display='none';", new C1462d(this));
                    this.f6871a.evaluateJavascript("javascript:var ae = window.document.getElementsByClassName('banner-container')[0]; if(ae != null) ae.style.display='none';", new C1463e(this));
                    this.f6871a.evaluateJavascript("javascript: var anchors = document.getElementsByTagName(\"a\");\n    var len = anchors.length;\n    var x = 0;\n    for (var i = 0; i < len; i++) {\n       if(hasClass(anchors[x], 'edit-page') || hasClass(anchors[x], 'noprint')) {\n           anchors[x].innerHTML = '';\n       }\n       if(hasClass(anchors[x], 'image')) {anchors[x].removeAttribute(\"href\"); x++;} else anchors[x].outerHTML = anchors[x].innerHTML;\n    }\nfunction hasClass(element, cls) {\n    return (' ' + element.className + ' ').indexOf(' ' + cls + ' ') > -1;\n}", new C1464f(this));
                    this.f6871a.evaluateJavascript("javascript:function hidewiki() {var a = window.document.getElementById('frb');if(a != null) a.style.display='none';var b = window.document.getElementById('frb-inline');if(b != null) b.style.display='none';var c = window.document.getElementById('frb-nag');if(c != null) c.style.display='none';}var intervalID = setInterval('hidewiki();', 500);", new C1465g(this));
                    return;
                }
                this.f6871a.loadUrl("javascript:window.document.getElementsByClassName('header')[0].style.display='none'; ");
                this.f6871a.loadUrl("javascript:window.document.getElementsByClassName('pre-content')[0].style.display='none';");
                this.f6871a.loadUrl("javascript:window.document.getElementsByClassName('last-modified-bar')[0].style.display='none';");
                this.f6871a.loadUrl("javascript:window.document.getElementsByClassName('read-more-container')[0].style.display='none';");
                this.f6871a.loadUrl("javascript:window.document.getElementsByClassName('banner-container')[0].style.display='none';");
                this.f6871a.loadUrl("javascript: var anchors = document.getElementsByTagName(\"a\");    var len = anchors.length;\n    var x = 0;\n    for (var i = 0; i < len; i++) {\n       if(hasClass(anchors[x], 'edit-page') || hasClass(anchors[x], 'noprint')) {\n           anchors[x].innerHTML = '';\n       }\n       if(hasClass(anchors[x], 'image')) {anchors[x].removeAttribute(\"href\"); x++;} else anchors[x].outerHTML = anchors[x].innerHTML;\n    }\nfunction hasClass(element, cls) {\n    return (' ' + element.className + ' ').indexOf(' ' + cls + ' ') > -1;\n}");
                this.f6871a.loadUrl("javascript:function hidewiki() {var a = window.document.getElementById('frb');if(a != null) a.style.display='none';var b = window.document.getElementById('frb-inline');if(b != null) b.style.display='none';var c = window.document.getElementById('frb-nag');if(c != null) c.style.display='none';}var intervalID = setInterval('hidewiki();', 500);");
            }
        }

        private C1457d() {
        }

        /* renamed from: a */
        public void mo10569a(WebView webView) {
            if (webView != null) {
                webView.post(new C1458a(this, webView));
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (WikiWebView.this.showWikiWebView) {
                mo10569a(webView);
                ((SlidingUpPanelLayout) WikiWebView.this.findViewById(C1441R.C1443id.sliding_layout)).setPanelHeight(0);
                WikiWebView.this.findViewById(C1441R.C1443id.waitWebView).setVisibility(8);
                WikiWebView.this.findViewById(C1441R.C1443id.webview_layout).startAnimation(AnimationUtils.loadAnimation(WikiWebView.this.getApplicationContext(), C1441R.anim.web_show));
                WikiWebView.this.findViewById(C1441R.C1443id.webview_layout).setVisibility(0);
                DrawerLayoutEdgeToggle drawerLayoutEdgeToggle = WikiWebView.this.mDrawerToggle;
                if (drawerLayoutEdgeToggle != null) {
                    drawerLayoutEdgeToggle.getDrawerLayoutHandle().setVisibility(4);
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (WikiWebView.this.f6862o != str) {
                return false;
            }
            webView.loadUrl(str);
            return false;
        }

        /* synthetic */ C1457d(WikiWebView wikiWebView, C1454a aVar) {
            this();
        }
    }

    public void destroyWikiWebView() {
        WebView webView = this.f6863p;
        if (webView != null) {
            webView.stopLoading();
            this.f6863p.clearHistory();
            this.f6863p.clearCache(true);
            this.f6863p.destroy();
            this.f6863p = null;
        }
    }

    /* access modifiers changed from: protected */
    public void hideWikiWebView() {
        if (this.showWikiWebView) {
            this.showWikiWebView = false;
            findViewById(C1441R.C1443id.waitWebView).setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1441R.C1443id.webview_layout);
            Animation loadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), C1441R.anim.web_hide);
            loadAnimation.setAnimationListener(new C1454a(relativeLayout));
            relativeLayout.startAnimation(loadAnimation);
        }
    }

    /* access modifiers changed from: protected */
    public void initUI() {
        ImageButton imageButton = (ImageButton) findViewById(C1441R.C1443id.info);
        if (this.f6865r) {
            imageButton.setOnClickListener(new C1455b());
            imageButton.setVisibility(0);
        } else {
            imageButton.setVisibility(8);
        }
        findViewById(C1441R.C1443id.close_webview).setOnClickListener(new C1456c());
        findViewById(C1441R.C1443id.waitWebView).setVisibility(8);
        if (this.showWikiWebView) {
            openWikiWebView();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        destroyWikiWebView();
        restartWikiButtonAnimTimer();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6861n = new ArrayList<>(Arrays.asList(getResources().getStringArray(C1441R.array.wiki_links)));
        String str = this.mLang;
        this.f6865r = str != null && "en pl ru ar de es fr ko pt".contains(str) && Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        destroyWikiWebView();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        WebView webView = this.f6863p;
        if (webView != null) {
            webView.pauseTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.f6863p.onPause();
            }
        }
        stopWikiButtonAnimTimer();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = this.f6863p;
        if (webView != null) {
            webView.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.f6863p.onResume();
            }
        }
        startWikiButtonAnimTimer();
    }

    /* access modifiers changed from: protected */
    public void openWikiWebView() {
        findViewById(C1441R.C1443id.waitWebView).setVisibility(0);
        this.f6862o = Uri.decode(this.f6861n.get(this.mSwitchedPosition));
        WebView webView = (WebView) findViewById(C1441R.C1443id.webview);
        this.f6863p = webView;
        webView.setWebViewClient(new C1457d(this, (C1454a) null));
        this.f6863p.getSettings().setLoadsImagesAutomatically(true);
        this.f6863p.getSettings().setJavaScriptEnabled(true);
        this.f6863p.setScrollBarStyle(0);
        int i = Build.VERSION.SDK_INT;
        if (i < 18) {
            this.f6863p.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        if (i >= 19) {
            this.f6863p.setLayerType(2, (Paint) null);
        } else if (i >= 11) {
            this.f6863p.setLayerType(1, (Paint) null);
        }
        this.f6863p.loadUrl(this.f6862o);
    }

    public void releaseWikiWebView() {
        WebView webView = this.f6863p;
        if (webView != null) {
            webView.stopLoading();
            this.f6863p.clearHistory();
            this.f6863p.clearCache(true);
            this.f6863p = null;
        }
    }

    /* access modifiers changed from: protected */
    public void restartWikiButtonAnimTimer() {
        MyTimer myTimer = this.f6864q;
        if (myTimer != null) {
            myTimer.stop();
            this.f6864q.start();
        }
    }

    /* access modifiers changed from: protected */
    public void startWikiButtonAnimTimer() {
        MyTimer myTimer = this.f6864q;
        if (myTimer != null) {
            myTimer.start();
        }
    }

    /* access modifiers changed from: protected */
    public void stopWikiButtonAnimTimer() {
        MyTimer myTimer = this.f6864q;
        if (myTimer != null) {
            myTimer.stop();
        }
    }
}
