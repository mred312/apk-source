package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzen extends C3130v3 {

    /* renamed from: b */
    private final C2944b3 f18531b = new C2944b3(this, zzm(), "google_app_measurement_local.db");

    /* renamed from: c */
    private boolean f18532c;

    zzen(zzfv zzfv) {
        super(zzfv);
    }

    /* renamed from: b */
    private static long m10765b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, (String) null, (String) null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c1 A[SYNTHETIC, Splitter:B:47:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0117 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0117 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0117 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m10766c(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzc()
            boolean r0 = r1.f18532c
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0023:
            if (r5 >= r4) goto L_0x0129
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.m10767d()     // Catch:{ SQLiteFullException -> 0x00fb, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00bd, all -> 0x00ba }
            if (r9 != 0) goto L_0x0035
            r1.f18532c = r8     // Catch:{ SQLiteFullException -> 0x00b8, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b4 }
            if (r9 == 0) goto L_0x0034
            r9.close()
        L_0x0034:
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00b8, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b4 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00b8, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b4 }
            if (r12 == 0) goto L_0x0056
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r0 == 0) goto L_0x0056
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            goto L_0x0056
        L_0x004d:
            r0 = move-exception
            goto L_0x00e7
        L_0x0050:
            r0 = move-exception
            goto L_0x00b6
        L_0x0052:
            r0 = move-exception
            r7 = r12
            goto L_0x00fd
        L_0x0056:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x009d
            com.google.android.gms.measurement.internal.zzer r15 = r16.zzq()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzet r15 = r15.zze()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "Data loss, local db full"
            r15.zza(r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r4 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r10[r2] = r11     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r4 = r9.delete(r0, r4, r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r10 = (long) r4     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x009d
            com.google.android.gms.measurement.internal.zzer r4 = r16.zzq()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zze()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r4.zza(r15, r2, r8, r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
        L_0x009d:
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r12 == 0) goto L_0x00ab
            r12.close()
        L_0x00ab:
            if (r9 == 0) goto L_0x00b0
            r9.close()
        L_0x00b0:
            r2 = 1
            return r2
        L_0x00b2:
            r7 = r12
            goto L_0x00ea
        L_0x00b4:
            r0 = move-exception
            r12 = r7
        L_0x00b6:
            r7 = r9
            goto L_0x00bf
        L_0x00b8:
            r0 = move-exception
            goto L_0x00fd
        L_0x00ba:
            r0 = move-exception
            r9 = r7
            goto L_0x011e
        L_0x00bd:
            r0 = move-exception
            r12 = r7
        L_0x00bf:
            if (r7 == 0) goto L_0x00ca
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00e5 }
            if (r2 == 0) goto L_0x00ca
            r7.endTransaction()     // Catch:{ all -> 0x00e5 }
        L_0x00ca:
            com.google.android.gms.measurement.internal.zzer r2 = r16.zzq()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zze()     // Catch:{ all -> 0x00e5 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00e5 }
            r2 = 1
            r1.f18532c = r2     // Catch:{ all -> 0x00e5 }
            if (r12 == 0) goto L_0x00df
            r12.close()
        L_0x00df:
            if (r7 == 0) goto L_0x0117
            r7.close()
            goto L_0x0117
        L_0x00e5:
            r0 = move-exception
            r9 = r7
        L_0x00e7:
            r7 = r12
            goto L_0x011e
        L_0x00e9:
            r9 = r7
        L_0x00ea:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x011d }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f5
            r7.close()
        L_0x00f5:
            if (r9 == 0) goto L_0x0117
            r9.close()
            goto L_0x0117
        L_0x00fb:
            r0 = move-exception
            r9 = r7
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzer r2 = r16.zzq()     // Catch:{ all -> 0x011d }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zze()     // Catch:{ all -> 0x011d }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x011d }
            r2 = 1
            r1.f18532c = r2     // Catch:{ all -> 0x011d }
            if (r7 == 0) goto L_0x0112
            r7.close()
        L_0x0112:
            if (r9 == 0) goto L_0x0117
            r9.close()
        L_0x0117:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0023
        L_0x011d:
            r0 = move-exception
        L_0x011e:
            if (r7 == 0) goto L_0x0123
            r7.close()
        L_0x0123:
            if (r9 == 0) goto L_0x0128
            r9.close()
        L_0x0128:
            throw r0
        L_0x0129:
            com.google.android.gms.measurement.internal.zzer r0 = r16.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzw()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzen.m10766c(int, byte[]):boolean");
    }

    @WorkerThread
    @VisibleForTesting
    /* renamed from: d */
    private final SQLiteDatabase m10767d() {
        if (this.f18532c) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f18531b.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f18532c = true;
        return null;
    }

    @VisibleForTesting
    /* renamed from: e */
    private final boolean m10768e() {
        return zzm().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean zza(zzar zzar) {
        Parcel obtain = Parcel.obtain();
        zzar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m10766c(0, marshall);
        }
        zzq().zzf().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    @WorkerThread
    public final void zzaa() {
        zzc();
        try {
            int delete = m10767d().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzq().zzw().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error resetting local analytics data. error", e);
        }
    }

    @WorkerThread
    public final boolean zzab() {
        return m10766c(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0086, code lost:
        r3 = r3 + 1;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzac() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzc()
            boolean r1 = r11.f18532c
            r2 = 0
            if (r1 == 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = r11.m10768e()
            if (r1 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0015:
            if (r3 >= r1) goto L_0x008f
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.m10767d()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r5 != 0) goto L_0x0027
            r11.f18532c = r6     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r5 == 0) goto L_0x0026
            r5.close()
        L_0x0026:
            return r2
        L_0x0027:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r5 == 0) goto L_0x0045
            r5.close()
        L_0x0045:
            return r6
        L_0x0046:
            r0 = move-exception
            goto L_0x0089
        L_0x0048:
            r7 = move-exception
            if (r5 == 0) goto L_0x0054
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x0046 }
            if (r8 == 0) goto L_0x0054
            r5.endTransaction()     // Catch:{ all -> 0x0046 }
        L_0x0054:
            com.google.android.gms.measurement.internal.zzer r8 = r11.zzq()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zze()     // Catch:{ all -> 0x0046 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0046 }
            r11.f18532c = r6     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0086
            r5.close()
            goto L_0x0086
        L_0x0067:
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x0046 }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x0086
            r5.close()
            goto L_0x0086
        L_0x0073:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzer r8 = r11.zzq()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zze()     // Catch:{ all -> 0x0046 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0046 }
            r11.f18532c = r6     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0086
            r5.close()
        L_0x0086:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0089:
            if (r5 == 0) goto L_0x008e
            r5.close()
        L_0x008e:
            throw r0
        L_0x008f:
            com.google.android.gms.measurement.internal.zzer r0 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzh()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zza(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzen.zzac():boolean");
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzgy zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzek zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzio zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzij zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzen zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzju zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzep zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkw zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfo zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzer zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ C3049m3 zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return false;
    }

    public final boolean zza(zzkr zzkr) {
        Parcel obtain = Parcel.obtain();
        zzkr.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m10766c(1, marshall);
        }
        zzq().zzf().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzw zzw) {
        zzo();
        byte[] H = zzkw.m10989H(zzw);
        if (H.length <= 131072) {
            return m10766c(2, H);
        }
        zzq().zzf().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:63|64|65|66) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:78|79|80|81) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:50|51|52|53|179) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x019f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01a0, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01a5, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01a8, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01ad, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01bd, code lost:
        if (r15.inTransaction() != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01bf, code lost:
        r15.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01d1, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01d6, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01e4, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x01e9, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x01ff, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0204, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x020d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0211, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0216, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        zzq().zze().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        zzq().zze().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r11.recycle();
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        zzq().zze().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r11.recycle();
        r12 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00b3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x0119 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b9 A[SYNTHETIC, Splitter:B:130:0x01b9] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0207 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0207 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0207 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "Error reading entries from local database"
            r22.zzc()
            boolean r0 = r1.f18532c
            r3 = 0
            if (r0 == 0) goto L_0x000d
            return r3
        L_0x000d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r22.m10768e()
            if (r0 != 0) goto L_0x0019
            return r4
        L_0x0019:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x001d:
            if (r7 >= r5) goto L_0x021a
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r22.m10767d()     // Catch:{ SQLiteFullException -> 0x01ed, SQLiteDatabaseLockedException -> 0x01da, SQLiteException -> 0x01b4, all -> 0x01b0 }
            if (r15 != 0) goto L_0x0039
            r1.f18532c = r9     // Catch:{ SQLiteFullException -> 0x0035, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x0031, all -> 0x002e }
            if (r15 == 0) goto L_0x002d
            r15.close()
        L_0x002d:
            return r3
        L_0x002e:
            r0 = move-exception
            goto L_0x020f
        L_0x0031:
            r0 = move-exception
            r10 = r3
            goto L_0x01b7
        L_0x0035:
            r0 = move-exception
            r10 = r3
            goto L_0x01f0
        L_0x0039:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01ac, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x01a4, all -> 0x019f }
            long r10 = m10765b(r15)     // Catch:{ SQLiteFullException -> 0x01ac, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x01a4, all -> 0x019f }
            r19 = -1
            int r0 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0053
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0035, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x0031, all -> 0x002e }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0035, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x0031, all -> 0x002e }
            r12[r6] = r10     // Catch:{ SQLiteFullException -> 0x0035, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x0031, all -> 0x002e }
            r13 = r0
            r14 = r12
            goto L_0x0055
        L_0x0053:
            r13 = r3
            r14 = r13
        L_0x0055:
            java.lang.String r11 = "messages"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x01ac, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x01a4, all -> 0x019f }
            java.lang.String r10 = "rowid"
            r12[r6] = r10     // Catch:{ SQLiteFullException -> 0x01ac, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x01a4, all -> 0x019f }
            java.lang.String r10 = "type"
            r12[r9] = r10     // Catch:{ SQLiteFullException -> 0x01ac, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x01a4, all -> 0x019f }
            java.lang.String r10 = "entry"
            r5 = 2
            r12[r5] = r10     // Catch:{ SQLiteFullException -> 0x01ac, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x01a4, all -> 0x019f }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid asc"
            r10 = 100
            java.lang.String r21 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x01ac, SQLiteDatabaseLockedException -> 0x01a8, SQLiteException -> 0x01a4, all -> 0x019f }
            r10 = r15
            r3 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r21
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x019c, SQLiteDatabaseLockedException -> 0x01a9, SQLiteException -> 0x0199, all -> 0x0196 }
        L_0x0081:
            boolean r11 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            if (r11 == 0) goto L_0x0155
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            int r11 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            byte[] r12 = r10.getBlob(r5)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            if (r11 != 0) goto L_0x00c8
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            int r13 = r12.length     // Catch:{ ParseException -> 0x00b3 }
            r11.unmarshall(r12, r6, r13)     // Catch:{ ParseException -> 0x00b3 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00b3 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r12 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ ParseException -> 0x00b3 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x00b3 }
            com.google.android.gms.measurement.internal.zzar r12 = (com.google.android.gms.measurement.internal.zzar) r12     // Catch:{ ParseException -> 0x00b3 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            if (r12 == 0) goto L_0x0081
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x0081
        L_0x00b1:
            r0 = move-exception
            goto L_0x00c4
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzer r12 = r22.zzq()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zze()     // Catch:{ all -> 0x00b1 }
            java.lang.String r13 = "Failed to load event from local database"
            r12.zza(r13)     // Catch:{ all -> 0x00b1 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x0081
        L_0x00c4:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
        L_0x00c8:
            if (r11 != r9) goto L_0x00fe
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            int r13 = r12.length     // Catch:{ ParseException -> 0x00e3 }
            r11.unmarshall(r12, r6, r13)     // Catch:{ ParseException -> 0x00e3 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00e3 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkr> r12 = com.google.android.gms.measurement.internal.zzkr.CREATOR     // Catch:{ ParseException -> 0x00e3 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzkr r12 = (com.google.android.gms.measurement.internal.zzkr) r12     // Catch:{ ParseException -> 0x00e3 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x00f4
        L_0x00e1:
            r0 = move-exception
            goto L_0x00fa
        L_0x00e3:
            com.google.android.gms.measurement.internal.zzer r12 = r22.zzq()     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zze()     // Catch:{ all -> 0x00e1 }
            java.lang.String r13 = "Failed to load user property from local database"
            r12.zza(r13)     // Catch:{ all -> 0x00e1 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            r12 = 0
        L_0x00f4:
            if (r12 == 0) goto L_0x0081
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x0081
        L_0x00fa:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
        L_0x00fe:
            if (r11 != r5) goto L_0x0135
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            int r13 = r12.length     // Catch:{ ParseException -> 0x0119 }
            r11.unmarshall(r12, r6, r13)     // Catch:{ ParseException -> 0x0119 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0119 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r12 = com.google.android.gms.measurement.internal.zzw.CREATOR     // Catch:{ ParseException -> 0x0119 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x0119 }
            com.google.android.gms.measurement.internal.zzw r12 = (com.google.android.gms.measurement.internal.zzw) r12     // Catch:{ ParseException -> 0x0119 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x012a
        L_0x0117:
            r0 = move-exception
            goto L_0x0131
        L_0x0119:
            com.google.android.gms.measurement.internal.zzer r12 = r22.zzq()     // Catch:{ all -> 0x0117 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zze()     // Catch:{ all -> 0x0117 }
            java.lang.String r13 = "Failed to load conditional user property from local database"
            r12.zza(r13)     // Catch:{ all -> 0x0117 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            r12 = 0
        L_0x012a:
            if (r12 == 0) goto L_0x0081
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x0081
        L_0x0131:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
        L_0x0135:
            if (r11 != r0) goto L_0x0146
            com.google.android.gms.measurement.internal.zzer r11 = r22.zzq()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzh()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            java.lang.String r12 = "Skipping app launch break"
            r11.zza(r12)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x0081
        L_0x0146:
            com.google.android.gms.measurement.internal.zzer r11 = r22.zzq()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            com.google.android.gms.measurement.internal.zzet r11 = r11.zze()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            java.lang.String r12 = "Unknown record type in local database"
            r11.zza(r12)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            goto L_0x0081
        L_0x0155:
            java.lang.String r0 = "messages"
            java.lang.String r5 = "rowid <= ?"
            java.lang.String[] r11 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            java.lang.String r12 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            r11[r6] = r12     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            int r0 = r3.delete(r0, r5, r11)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            int r5 = r4.size()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            if (r0 >= r5) goto L_0x0178
            com.google.android.gms.measurement.internal.zzer r0 = r22.zzq()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zze()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            java.lang.String r5 = "Fewer entries removed from local database than expected"
            r0.zza(r5)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
        L_0x0178:
            r3.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            r3.endTransaction()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x0190, SQLiteException -> 0x018d, all -> 0x0189 }
            if (r10 == 0) goto L_0x0183
            r10.close()
        L_0x0183:
            if (r3 == 0) goto L_0x0188
            r3.close()
        L_0x0188:
            return r4
        L_0x0189:
            r0 = move-exception
            r15 = r3
            goto L_0x020e
        L_0x018d:
            r0 = move-exception
            r15 = r3
            goto L_0x01b7
        L_0x0190:
            r15 = r3
            goto L_0x01dc
        L_0x0192:
            r0 = move-exception
            r15 = r3
            goto L_0x01f0
        L_0x0196:
            r0 = move-exception
            r15 = r3
            goto L_0x01a1
        L_0x0199:
            r0 = move-exception
            r15 = r3
            goto L_0x01a6
        L_0x019c:
            r0 = move-exception
            r15 = r3
            goto L_0x01ae
        L_0x019f:
            r0 = move-exception
            r3 = r15
        L_0x01a1:
            r3 = 0
            goto L_0x020f
        L_0x01a4:
            r0 = move-exception
            r3 = r15
        L_0x01a6:
            r10 = 0
            goto L_0x01b7
        L_0x01a8:
            r3 = r15
        L_0x01a9:
            r15 = r3
            r10 = 0
            goto L_0x01dc
        L_0x01ac:
            r0 = move-exception
            r3 = r15
        L_0x01ae:
            r10 = 0
            goto L_0x01f0
        L_0x01b0:
            r0 = move-exception
            r3 = 0
            r15 = 0
            goto L_0x020f
        L_0x01b4:
            r0 = move-exception
            r10 = 0
            r15 = 0
        L_0x01b7:
            if (r15 == 0) goto L_0x01c2
            boolean r3 = r15.inTransaction()     // Catch:{ all -> 0x020d }
            if (r3 == 0) goto L_0x01c2
            r15.endTransaction()     // Catch:{ all -> 0x020d }
        L_0x01c2:
            com.google.android.gms.measurement.internal.zzer r3 = r22.zzq()     // Catch:{ all -> 0x020d }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()     // Catch:{ all -> 0x020d }
            r3.zza(r2, r0)     // Catch:{ all -> 0x020d }
            r1.f18532c = r9     // Catch:{ all -> 0x020d }
            if (r10 == 0) goto L_0x01d4
            r10.close()
        L_0x01d4:
            if (r15 == 0) goto L_0x0207
            r15.close()
            goto L_0x0207
        L_0x01da:
            r10 = 0
            r15 = 0
        L_0x01dc:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x020d }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x01e7
            r10.close()
        L_0x01e7:
            if (r15 == 0) goto L_0x0207
            r15.close()
            goto L_0x0207
        L_0x01ed:
            r0 = move-exception
            r10 = 0
            r15 = 0
        L_0x01f0:
            com.google.android.gms.measurement.internal.zzer r3 = r22.zzq()     // Catch:{ all -> 0x020d }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()     // Catch:{ all -> 0x020d }
            r3.zza(r2, r0)     // Catch:{ all -> 0x020d }
            r1.f18532c = r9     // Catch:{ all -> 0x020d }
            if (r10 == 0) goto L_0x0202
            r10.close()
        L_0x0202:
            if (r15 == 0) goto L_0x0207
            r15.close()
        L_0x0207:
            int r7 = r7 + 1
            r3 = 0
            r5 = 5
            goto L_0x001d
        L_0x020d:
            r0 = move-exception
        L_0x020e:
            r3 = r10
        L_0x020f:
            if (r3 == 0) goto L_0x0214
            r3.close()
        L_0x0214:
            if (r15 == 0) goto L_0x0219
            r15.close()
        L_0x0219:
            throw r0
        L_0x021a:
            com.google.android.gms.measurement.internal.zzer r0 = r22.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzh()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzen.zza(int):java.util.List");
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
