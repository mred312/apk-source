package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

@SuppressLint({"NewApi"})
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class FragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: a */
    private Fragment f7756a;

    private FragmentWrapper(Fragment fragment) {
        this.f7756a = fragment;
    }

    @KeepForSdk
    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    public final IObjectWrapper zza() {
        return ObjectWrapper.wrap(this.f7756a.getActivity());
    }

    public final Bundle zzb() {
        return this.f7756a.getArguments();
    }

    public final int zzc() {
        return this.f7756a.getId();
    }

    public final IFragmentWrapper zzd() {
        return wrap(this.f7756a.getParentFragment());
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.f7756a.getResources());
    }

    public final boolean zzf() {
        return this.f7756a.getRetainInstance();
    }

    public final String zzg() {
        return this.f7756a.getTag();
    }

    public final IFragmentWrapper zzh() {
        return wrap(this.f7756a.getTargetFragment());
    }

    public final int zzi() {
        return this.f7756a.getTargetRequestCode();
    }

    public final boolean zzj() {
        return this.f7756a.getUserVisibleHint();
    }

    public final IObjectWrapper zzk() {
        return ObjectWrapper.wrap(this.f7756a.getView());
    }

    public final boolean zzl() {
        return this.f7756a.isAdded();
    }

    public final boolean zzm() {
        return this.f7756a.isDetached();
    }

    public final boolean zzn() {
        return this.f7756a.isHidden();
    }

    public final boolean zzo() {
        return this.f7756a.isInLayout();
    }

    public final boolean zzp() {
        return this.f7756a.isRemoving();
    }

    public final boolean zzq() {
        return this.f7756a.isResumed();
    }

    public final boolean zzr() {
        return this.f7756a.isVisible();
    }

    public final void zzb(boolean z) {
        this.f7756a.setMenuVisibility(z);
    }

    public final void zzc(boolean z) {
        this.f7756a.setRetainInstance(z);
    }

    public final void zzd(boolean z) {
        this.f7756a.setUserVisibleHint(z);
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.f7756a.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.f7756a.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(boolean z) {
        this.f7756a.setHasOptionsMenu(z);
    }

    public final void zza(Intent intent) {
        this.f7756a.startActivity(intent);
    }

    public final void zza(Intent intent, int i) {
        this.f7756a.startActivityForResult(intent, i);
    }
}
