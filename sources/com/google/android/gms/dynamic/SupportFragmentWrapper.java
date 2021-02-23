package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: a */
    private Fragment f7760a;

    private SupportFragmentWrapper(Fragment fragment) {
        this.f7760a = fragment;
    }

    @KeepForSdk
    public static SupportFragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    public final IObjectWrapper zza() {
        return ObjectWrapper.wrap(this.f7760a.getActivity());
    }

    public final Bundle zzb() {
        return this.f7760a.getArguments();
    }

    public final int zzc() {
        return this.f7760a.getId();
    }

    public final IFragmentWrapper zzd() {
        return wrap(this.f7760a.getParentFragment());
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.f7760a.getResources());
    }

    public final boolean zzf() {
        return this.f7760a.getRetainInstance();
    }

    public final String zzg() {
        return this.f7760a.getTag();
    }

    public final IFragmentWrapper zzh() {
        return wrap(this.f7760a.getTargetFragment());
    }

    public final int zzi() {
        return this.f7760a.getTargetRequestCode();
    }

    public final boolean zzj() {
        return this.f7760a.getUserVisibleHint();
    }

    public final IObjectWrapper zzk() {
        return ObjectWrapper.wrap(this.f7760a.getView());
    }

    public final boolean zzl() {
        return this.f7760a.isAdded();
    }

    public final boolean zzm() {
        return this.f7760a.isDetached();
    }

    public final boolean zzn() {
        return this.f7760a.isHidden();
    }

    public final boolean zzo() {
        return this.f7760a.isInLayout();
    }

    public final boolean zzp() {
        return this.f7760a.isRemoving();
    }

    public final boolean zzq() {
        return this.f7760a.isResumed();
    }

    public final boolean zzr() {
        return this.f7760a.isVisible();
    }

    public final void zzb(boolean z) {
        this.f7760a.setMenuVisibility(z);
    }

    public final void zzc(boolean z) {
        this.f7760a.setRetainInstance(z);
    }

    public final void zzd(boolean z) {
        this.f7760a.setUserVisibleHint(z);
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.f7760a.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.f7760a.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(boolean z) {
        this.f7760a.setHasOptionsMenu(z);
    }

    public final void zza(Intent intent) {
        this.f7760a.startActivity(intent);
    }

    public final void zza(Intent intent, int i) {
        this.f7760a.startActivityForResult(intent, i);
    }
}
