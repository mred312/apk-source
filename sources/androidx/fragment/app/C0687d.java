package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.C0610R;

/* renamed from: androidx.fragment.app.d */
/* compiled from: FragmentLayoutInflaterFactory */
class C0687d implements LayoutInflater.Factory2 {

    /* renamed from: a */
    private final FragmentManager f3314a;

    C0687d(FragmentManager fragmentManager) {
        this.f3314a = fragmentManager;
    }

    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        C0693h hVar;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f3314a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0610R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(C0610R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(C0610R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(C0610R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.m2190a(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f3314a.findFragmentById(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f3314a.findFragmentByTag(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f3314a.findFragmentById(id);
        }
        if (FragmentManager.m2230w0(2)) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragment);
        }
        if (fragment == null) {
            fragment = this.f3314a.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
            fragment.f3021n = true;
            fragment.f3030w = resourceId != 0 ? resourceId : id;
            fragment.f3031x = id;
            fragment.f3032y = string;
            fragment.f3022o = true;
            FragmentManager fragmentManager = this.f3314a;
            fragment.f3026s = fragmentManager;
            fragment.f3027t = fragmentManager.mo5777n0();
            fragment.onInflate(this.f3314a.mo5777n0().mo5697b(), attributeSet, fragment.f3009b);
            hVar = this.f3314a.mo5798t(fragment);
            this.f3314a.mo5759g(fragment);
        } else if (!fragment.f3022o) {
            fragment.f3022o = true;
            FragmentManager fragmentManager2 = this.f3314a;
            fragment.f3026s = fragmentManager2;
            fragment.f3027t = fragmentManager2.mo5777n0();
            fragment.onInflate(this.f3314a.mo5777n0().mo5697b(), attributeSet, fragment.f3009b);
            hVar = this.f3314a.mo5798t(fragment);
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        hVar.mo6073k();
        hVar.mo6071i();
        View view2 = fragment.f2989H;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.f2989H.getTag() == null) {
                fragment.f2989H.setTag(string);
            }
            return fragment.f2989H;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
