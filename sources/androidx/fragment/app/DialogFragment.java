package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;

    /* renamed from: b0 */
    private Handler f2959b0;

    /* renamed from: c0 */
    private Runnable f2960c0 = new C0614a();

    /* renamed from: d0 */
    private DialogInterface.OnCancelListener f2961d0 = new C0615b();
    /* access modifiers changed from: private */

    /* renamed from: e0 */
    public DialogInterface.OnDismissListener f2962e0 = new C0616c();

    /* renamed from: f0 */
    private int f2963f0 = 0;

    /* renamed from: g0 */
    private int f2964g0 = 0;

    /* renamed from: h0 */
    private boolean f2965h0 = true;
    /* access modifiers changed from: private */

    /* renamed from: i0 */
    public boolean f2966i0 = true;

    /* renamed from: j0 */
    private int f2967j0 = -1;

    /* renamed from: k0 */
    private boolean f2968k0;

    /* renamed from: l0 */
    private Observer<LifecycleOwner> f2969l0 = new C0617d();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: m0 */
    public Dialog f2970m0;

    /* renamed from: n0 */
    private boolean f2971n0;

    /* renamed from: o0 */
    private boolean f2972o0;

    /* renamed from: p0 */
    private boolean f2973p0;

    /* renamed from: q0 */
    private boolean f2974q0 = false;

    /* renamed from: androidx.fragment.app.DialogFragment$a */
    class C0614a implements Runnable {
        C0614a() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            DialogFragment.this.f2962e0.onDismiss(DialogFragment.this.f2970m0);
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$b */
    class C0615b implements DialogInterface.OnCancelListener {
        C0615b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.f2970m0 != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onCancel(dialogFragment.f2970m0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$c */
    class C0616c implements DialogInterface.OnDismissListener {
        C0616c() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.f2970m0 != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onDismiss(dialogFragment.f2970m0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$d */
    class C0617d implements Observer<LifecycleOwner> {
        C0617d() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a */
        public void onChanged(LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner != null && DialogFragment.this.f2966i0) {
                View requireView = DialogFragment.this.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (DialogFragment.this.f2970m0 != null) {
                    if (FragmentManager.m2230w0(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogFragment.this.f2970m0);
                    }
                    DialogFragment.this.f2970m0.setContentView(requireView);
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$e */
    class C0618e extends FragmentContainer {

        /* renamed from: a */
        final /* synthetic */ FragmentContainer f2979a;

        C0618e(FragmentContainer fragmentContainer) {
            this.f2979a = fragmentContainer;
        }

        @Nullable
        public View onFindViewById(int i) {
            View m0 = DialogFragment.this.mo5395m0(i);
            if (m0 != null) {
                return m0;
            }
            if (this.f2979a.onHasView()) {
                return this.f2979a.onFindViewById(i);
            }
            return null;
        }

        public boolean onHasView() {
            return DialogFragment.this.mo5396n0() || this.f2979a.onHasView();
        }
    }

    public DialogFragment() {
    }

    /* renamed from: l0 */
    private void m2108l0(boolean z, boolean z2) {
        if (!this.f2972o0) {
            this.f2972o0 = true;
            this.f2973p0 = false;
            Dialog dialog = this.f2970m0;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.f2970m0.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.f2959b0.getLooper()) {
                        onDismiss(this.f2970m0);
                    } else {
                        this.f2959b0.post(this.f2960c0);
                    }
                }
            }
            this.f2971n0 = true;
            if (this.f2967j0 >= 0) {
                getParentFragmentManager().popBackStack(this.f2967j0, 1);
                this.f2967j0 = -1;
                return;
            }
            FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            if (z) {
                beginTransaction.commitAllowingStateLoss();
            } else {
                beginTransaction.commit();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: o0 */
    private void m2109o0(@Nullable Bundle bundle) {
        if (this.f2966i0 && !this.f2974q0) {
            try {
                this.f2968k0 = true;
                Dialog onCreateDialog = onCreateDialog(bundle);
                this.f2970m0 = onCreateDialog;
                if (this.f2966i0) {
                    setupDialog(onCreateDialog, this.f2963f0);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.f2970m0.setOwnerActivity((Activity) context);
                    }
                    this.f2970m0.setCancelable(this.f2965h0);
                    this.f2970m0.setOnCancelListener(this.f2961d0);
                    this.f2970m0.setOnDismissListener(this.f2962e0);
                    this.f2974q0 = true;
                } else {
                    this.f2970m0 = null;
                }
                this.f2968k0 = false;
            } catch (Throwable th) {
                this.f2968k0 = false;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public void mo5387C(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle bundle2;
        super.mo5387C(layoutInflater, viewGroup, bundle);
        if (this.f2989H == null && this.f2970m0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f2970m0.onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public FragmentContainer mo5388b() {
        return new C0618e(super.mo5388b());
    }

    public void dismiss() {
        m2108l0(false, false);
    }

    public void dismissAllowingStateLoss() {
        m2108l0(true, false);
    }

    @Nullable
    public Dialog getDialog() {
        return this.f2970m0;
    }

    public boolean getShowsDialog() {
        return this.f2966i0;
    }

    @StyleRes
    public int getTheme() {
        return this.f2964g0;
    }

    public boolean isCancelable() {
        return this.f2965h0;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: m0 */
    public View mo5395m0(int i) {
        Dialog dialog = this.f2970m0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n0 */
    public boolean mo5396n0() {
        return this.f2974q0;
    }

    @MainThread
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.f2969l0);
        if (!this.f2973p0) {
            this.f2972o0 = false;
        }
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f2959b0 = new Handler();
        this.f2966i0 = this.f3031x == 0;
        if (bundle != null) {
            this.f2963f0 = bundle.getInt("android:style", 0);
            this.f2964g0 = bundle.getInt("android:theme", 0);
            this.f2965h0 = bundle.getBoolean("android:cancelable", true);
            this.f2966i0 = bundle.getBoolean("android:showsDialog", this.f2966i0);
            this.f2967j0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @MainThread
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), getTheme());
    }

    @MainThread
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f2970m0;
        if (dialog != null) {
            this.f2971n0 = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.f2970m0.dismiss();
            if (!this.f2972o0) {
                onDismiss(this.f2970m0);
            }
            this.f2970m0 = null;
            this.f2974q0 = false;
        }
    }

    @MainThread
    public void onDetach() {
        super.onDetach();
        if (!this.f2973p0 && !this.f2972o0) {
            this.f2972o0 = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.f2969l0);
    }

    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (!this.f2971n0) {
            if (FragmentManager.m2230w0(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            m2108l0(true, true);
        }
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.f2966i0 || this.f2968k0) {
            if (FragmentManager.m2230w0(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (!this.f2966i0) {
                    Log.d("FragmentManager", "mShowsDialog = false: " + str);
                } else {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + str);
                }
            }
            return onGetLayoutInflater;
        }
        m2109o0(bundle);
        if (FragmentManager.m2230w0(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.f2970m0;
        return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f2970m0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
        }
        int i = this.f2963f0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.f2964g0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.f2965h0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f2966i0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.f2967j0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @MainThread
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f2970m0;
        if (dialog != null) {
            this.f2971n0 = false;
            dialog.show();
        }
    }

    @MainThread
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f2970m0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f2970m0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f2970m0.onRestoreInstanceState(bundle2);
        }
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.f2965h0 = z;
        Dialog dialog = this.f2970m0;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.f2966i0 = z;
    }

    public void setStyle(int i, @StyleRes int i2) {
        if (FragmentManager.m2230w0(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i + ", " + i2);
        }
        this.f2963f0 = i;
        if (i == 2 || i == 3) {
            this.f2964g0 = 16973913;
        }
        if (i2 != 0) {
            this.f2964g0 = i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.f2972o0 = false;
        this.f2973p0 = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commit();
    }

    public void showNow(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.f2972o0 = false;
        this.f2973p0 = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commitNow();
    }

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        this.f2972o0 = false;
        this.f2973p0 = true;
        fragmentTransaction.add((Fragment) this, str);
        this.f2971n0 = false;
        int commit = fragmentTransaction.commit();
        this.f2967j0 = commit;
        return commit;
    }

    public DialogFragment(@LayoutRes int i) {
        super(i);
    }
}
