package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e */
    static final Class<?>[] f748e;

    /* renamed from: f */
    static final Class<?>[] f749f;

    /* renamed from: a */
    final Object[] f750a;

    /* renamed from: b */
    final Object[] f751b;

    /* renamed from: c */
    Context f752c;

    /* renamed from: d */
    private Object f753d;

    /* renamed from: androidx.appcompat.view.SupportMenuInflater$a */
    private static class C0209a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c */
        private static final Class<?>[] f754c = {MenuItem.class};

        /* renamed from: a */
        private Object f755a;

        /* renamed from: b */
        private Method f756b;

        public C0209a(Object obj, String str) {
            this.f755a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f756b = cls.getMethod(str, f754c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f756b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f756b.invoke(this.f755a, new Object[]{menuItem})).booleanValue();
                }
                this.f756b.invoke(this.f755a, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: androidx.appcompat.view.SupportMenuInflater$b */
    private class C0210b {

        /* renamed from: A */
        ActionProvider f757A;

        /* renamed from: B */
        private CharSequence f758B;

        /* renamed from: C */
        private CharSequence f759C;

        /* renamed from: D */
        private ColorStateList f760D = null;

        /* renamed from: E */
        private PorterDuff.Mode f761E = null;

        /* renamed from: a */
        private Menu f763a;

        /* renamed from: b */
        private int f764b;

        /* renamed from: c */
        private int f765c;

        /* renamed from: d */
        private int f766d;

        /* renamed from: e */
        private int f767e;

        /* renamed from: f */
        private boolean f768f;

        /* renamed from: g */
        private boolean f769g;

        /* renamed from: h */
        private boolean f770h;

        /* renamed from: i */
        private int f771i;

        /* renamed from: j */
        private int f772j;

        /* renamed from: k */
        private CharSequence f773k;

        /* renamed from: l */
        private CharSequence f774l;

        /* renamed from: m */
        private int f775m;

        /* renamed from: n */
        private char f776n;

        /* renamed from: o */
        private int f777o;

        /* renamed from: p */
        private char f778p;

        /* renamed from: q */
        private int f779q;

        /* renamed from: r */
        private int f780r;

        /* renamed from: s */
        private boolean f781s;

        /* renamed from: t */
        private boolean f782t;

        /* renamed from: u */
        private boolean f783u;

        /* renamed from: v */
        private int f784v;

        /* renamed from: w */
        private int f785w;

        /* renamed from: x */
        private String f786x;

        /* renamed from: y */
        private String f787y;

        /* renamed from: z */
        private String f788z;

        public C0210b(Menu menu) {
            this.f763a = menu;
            mo1450h();
        }

        /* renamed from: c */
        private char m628c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: e */
        private <T> T m629e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f752c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* renamed from: i */
        private void m630i(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f781s).setVisible(this.f782t).setEnabled(this.f783u).setCheckable(this.f780r >= 1).setTitleCondensed(this.f774l).setIcon(this.f775m);
            int i = this.f784v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f788z != null) {
                if (!SupportMenuInflater.this.f752c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new C0209a(SupportMenuInflater.this.mo1442b(), this.f788z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f780r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.f786x;
            if (str != null) {
                menuItem.setActionView((View) m629e(str, SupportMenuInflater.f748e, SupportMenuInflater.this.f750a));
                z = true;
            }
            int i2 = this.f785w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.f757A;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.f758B);
            MenuItemCompat.setTooltipText(menuItem, this.f759C);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.f776n, this.f777o);
            MenuItemCompat.setNumericShortcut(menuItem, this.f778p, this.f779q);
            PorterDuff.Mode mode = this.f761E;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.f760D;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        /* renamed from: a */
        public void mo1445a() {
            this.f770h = true;
            m630i(this.f763a.add(this.f764b, this.f771i, this.f772j, this.f773k));
        }

        /* renamed from: b */
        public SubMenu mo1446b() {
            this.f770h = true;
            SubMenu addSubMenu = this.f763a.addSubMenu(this.f764b, this.f771i, this.f772j, this.f773k);
            m630i(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: d */
        public boolean mo1447d() {
            return this.f770h;
        }

        /* renamed from: f */
        public void mo1448f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f752c.obtainStyledAttributes(attributeSet, C0131R.styleable.MenuGroup);
            this.f764b = obtainStyledAttributes.getResourceId(C0131R.styleable.MenuGroup_android_id, 0);
            this.f765c = obtainStyledAttributes.getInt(C0131R.styleable.MenuGroup_android_menuCategory, 0);
            this.f766d = obtainStyledAttributes.getInt(C0131R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f767e = obtainStyledAttributes.getInt(C0131R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f768f = obtainStyledAttributes.getBoolean(C0131R.styleable.MenuGroup_android_visible, true);
            this.f769g = obtainStyledAttributes.getBoolean(C0131R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: g */
        public void mo1449g(AttributeSet attributeSet) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.f752c, attributeSet, C0131R.styleable.MenuItem);
            this.f771i = obtainStyledAttributes.getResourceId(C0131R.styleable.MenuItem_android_id, 0);
            this.f772j = (obtainStyledAttributes.getInt(C0131R.styleable.MenuItem_android_menuCategory, this.f765c) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(C0131R.styleable.MenuItem_android_orderInCategory, this.f766d) & SupportMenu.USER_MASK);
            this.f773k = obtainStyledAttributes.getText(C0131R.styleable.MenuItem_android_title);
            this.f774l = obtainStyledAttributes.getText(C0131R.styleable.MenuItem_android_titleCondensed);
            this.f775m = obtainStyledAttributes.getResourceId(C0131R.styleable.MenuItem_android_icon, 0);
            this.f776n = m628c(obtainStyledAttributes.getString(C0131R.styleable.MenuItem_android_alphabeticShortcut));
            this.f777o = obtainStyledAttributes.getInt(C0131R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f778p = m628c(obtainStyledAttributes.getString(C0131R.styleable.MenuItem_android_numericShortcut));
            this.f779q = obtainStyledAttributes.getInt(C0131R.styleable.MenuItem_numericModifiers, 4096);
            int i = C0131R.styleable.MenuItem_android_checkable;
            if (obtainStyledAttributes.hasValue(i)) {
                this.f780r = obtainStyledAttributes.getBoolean(i, false) ? 1 : 0;
            } else {
                this.f780r = this.f767e;
            }
            this.f781s = obtainStyledAttributes.getBoolean(C0131R.styleable.MenuItem_android_checked, false);
            this.f782t = obtainStyledAttributes.getBoolean(C0131R.styleable.MenuItem_android_visible, this.f768f);
            this.f783u = obtainStyledAttributes.getBoolean(C0131R.styleable.MenuItem_android_enabled, this.f769g);
            this.f784v = obtainStyledAttributes.getInt(C0131R.styleable.MenuItem_showAsAction, -1);
            this.f788z = obtainStyledAttributes.getString(C0131R.styleable.MenuItem_android_onClick);
            this.f785w = obtainStyledAttributes.getResourceId(C0131R.styleable.MenuItem_actionLayout, 0);
            this.f786x = obtainStyledAttributes.getString(C0131R.styleable.MenuItem_actionViewClass);
            String string = obtainStyledAttributes.getString(C0131R.styleable.MenuItem_actionProviderClass);
            this.f787y = string;
            boolean z = string != null;
            if (z && this.f785w == 0 && this.f786x == null) {
                this.f757A = (ActionProvider) m629e(string, SupportMenuInflater.f749f, SupportMenuInflater.this.f751b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f757A = null;
            }
            this.f758B = obtainStyledAttributes.getText(C0131R.styleable.MenuItem_contentDescription);
            this.f759C = obtainStyledAttributes.getText(C0131R.styleable.MenuItem_tooltipText);
            int i2 = C0131R.styleable.MenuItem_iconTintMode;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f761E = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i2, -1), this.f761E);
            } else {
                this.f761E = null;
            }
            int i3 = C0131R.styleable.MenuItem_iconTint;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.f760D = obtainStyledAttributes.getColorStateList(i3);
            } else {
                this.f760D = null;
            }
            obtainStyledAttributes.recycle();
            this.f770h = false;
        }

        /* renamed from: h */
        public void mo1450h() {
            this.f764b = 0;
            this.f765c = 0;
            this.f766d = 0;
            this.f767e = 0;
            this.f768f = true;
            this.f769g = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f748e = r0
            f749f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.<clinit>():void");
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f752c = context;
        Object[] objArr = {context};
        this.f750a = objArr;
        this.f751b = objArr;
    }

    /* renamed from: a */
    private Object m625a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m625a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* renamed from: c */
    private void m626c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        C0210b bVar = new C0210b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.mo1450h();
                        } else if (name2.equals("item")) {
                            if (!bVar.mo1447d()) {
                                ActionProvider actionProvider = bVar.f757A;
                                if (actionProvider == null || !actionProvider.hasSubMenu()) {
                                    bVar.mo1445a();
                                } else {
                                    bVar.mo1446b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.mo1448f(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.mo1449g(attributeSet);
                    } else if (name3.equals("menu")) {
                        m626c(xmlPullParser, attributeSet, bVar.mo1446b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo1442b() {
        if (this.f753d == null) {
            this.f753d = m625a(this.f752c);
        }
        return this.f753d;
    }

    public void inflate(@LayoutRes int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f752c.getResources().getLayout(i);
            m626c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
