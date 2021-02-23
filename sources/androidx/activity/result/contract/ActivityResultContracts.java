package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public final class ActivityResultContracts {

    @TargetApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.CREATE_DOCUMENT").setType("*/*").putExtra("android.intent.extra.TITLE", str);
        }

        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
        }

        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        @NonNull
        /* renamed from: a */
        static List<Uri> m373a(@NonNull Intent intent) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (intent.getData() != null) {
                linkedHashSet.add(intent.getData());
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return Collections.emptyList();
            }
            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    Uri uri = clipData.getItemAt(i).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }

        @Nullable
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }

        @NonNull
        public final List<Uri> parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return Collections.emptyList();
            }
            return m373a(intent);
        }
    }

    @TargetApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
        }

        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @Nullable Uri uri) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @Nullable Uri uri) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
        }

        @NonNull
        public final List<Uri> parseResult(int i, @Nullable Intent intent) {
            if (i != -1 || intent == null) {
                return Collections.emptyList();
            }
            return GetMultipleContents.m373a(intent);
        }
    }

    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @NonNull
        public Intent createIntent(@NonNull Context context, @Nullable Void voidR) {
            return new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
        }

        @Nullable
        public Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @NonNull
        /* renamed from: a */
        static Intent m374a(@NonNull String[] strArr) {
            return new Intent(ACTION_REQUEST_PERMISSIONS).putExtra(EXTRA_PERMISSIONS, strArr);
        }

        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return m374a(strArr);
        }

        @Nullable
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@NonNull Context context, @Nullable String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(Collections.emptyMap());
            }
            ArrayMap arrayMap = new ArrayMap();
            boolean z = true;
            for (String str : strArr) {
                boolean z2 = ContextCompat.checkSelfPermission(context, str) == 0;
                arrayMap.put(str, Boolean.valueOf(z2));
                if (!z2) {
                    z = false;
                }
            }
            if (z) {
                return new ActivityResultContract.SynchronousResult<>(arrayMap);
            }
            return null;
        }

        @NonNull
        public Map<String, Boolean> parseResult(int i, @Nullable Intent intent) {
            if (i != -1) {
                return Collections.emptyMap();
            }
            if (intent == null) {
                return Collections.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
            }
            return hashMap;
        }
    }

    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return RequestMultiplePermissions.m374a(new String[]{str});
        }

        @Nullable
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context context, @Nullable String str) {
            if (str == null) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.FALSE);
            }
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        @NonNull
        public Boolean parseResult(int i, @Nullable Intent intent) {
            int[] intArrayExtra;
            Boolean bool = Boolean.FALSE;
            if (intent == null || i != -1 || (intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS)) == null || intArrayExtra.length == 0) {
                return bool;
            }
            boolean z = false;
            if (intArrayExtra[0] == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull Intent intent) {
            return intent;
        }

        @NonNull
        public ActivityResult parseResult(int i, @Nullable Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull IntentSenderRequest intentSenderRequest) {
            return new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
        }

        @NonNull
        public ActivityResult parseResult(int i, @Nullable Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context context, @NonNull Uri uri) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull Uri uri) {
            return new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
        }

        @NonNull
        public final Boolean parseResult(int i, @Nullable Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context context, @Nullable Void voidR) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @Nullable Void voidR) {
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Nullable
        public final Bitmap parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return (Bitmap) intent.getParcelableExtra("data");
        }
    }

    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Nullable
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context context, @NonNull Uri uri) {
            return null;
        }

        @CallSuper
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull Uri uri) {
            return new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
        }

        @Nullable
        public final Bitmap parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return (Bitmap) intent.getParcelableExtra("data");
        }
    }

    private ActivityResultContracts() {
    }
}
