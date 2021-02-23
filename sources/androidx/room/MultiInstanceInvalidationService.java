package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.room.IMultiInstanceInvalidationService;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a */
    int f4509a = 0;

    /* renamed from: b */
    final SparseArrayCompat<String> f4510b = new SparseArrayCompat<>();

    /* renamed from: c */
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> f4511c = new C0967a();

    /* renamed from: d */
    private final IMultiInstanceInvalidationService.Stub f4512d = new C0968b();

    /* renamed from: androidx.room.MultiInstanceInvalidationService$a */
    class C0967a extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
        C0967a() {
        }

        /* renamed from: a */
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.f4510b.remove(((Integer) obj).intValue());
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationService$b */
    class C0968b extends IMultiInstanceInvalidationService.Stub {
        C0968b() {
        }

        public void broadcastInvalidation(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f4511c) {
                String str = MultiInstanceInvalidationService.this.f4510b.get(i);
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f4511c.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f4511c.getBroadcastCookie(i2)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f4510b.get(intValue);
                        if (i != intValue && str.equals(str2)) {
                            MultiInstanceInvalidationService.this.f4511c.getBroadcastItem(i2).onInvalidation(strArr);
                        }
                    } catch (RemoteException e) {
                        Log.w("ROOM", "Error invoking a remote callback", e);
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.f4511c.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.f4511c.finishBroadcast();
            }
        }

        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f4511c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.f4509a + 1;
                multiInstanceInvalidationService.f4509a = i;
                if (multiInstanceInvalidationService.f4511c.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.f4510b.append(i, str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f4509a--;
                return 0;
            }
        }

        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
            synchronized (MultiInstanceInvalidationService.this.f4511c) {
                MultiInstanceInvalidationService.this.f4511c.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.f4510b.remove(i);
            }
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return this.f4512d;
    }
}
