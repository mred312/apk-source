package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.k */
/* compiled from: ExtensionSchemaLite */
final class C3712k extends C3710j<GeneratedMessageLite.C3643b> {

    /* renamed from: com.google.protobuf.k$a */
    /* compiled from: ExtensionSchemaLite */
    static /* synthetic */ class C3713a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20792a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20792a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f20792a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3712k.C3713a.<clinit>():void");
        }
    }

    C3712k() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo23891a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.C3643b) entry.getKey()).getNumber();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo23892b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        return extensionRegistryLite.findLiteExtensionByNumber(messageLite, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public FieldSet<GeneratedMessageLite.C3643b> mo23893c(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public FieldSet<GeneratedMessageLite.C3643b> mo23894d(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).mo23362r();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo23895e(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo23896f(Object obj) {
        mo23893c(obj).mo23297x();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public <UT, UB> UB mo23897g(C3714k0 k0Var, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.C3643b> fieldSet, UB ub, C3746r0<UT, UB> r0Var) {
        Object j;
        ArrayList arrayList;
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        int number = generatedExtension.getNumber();
        if (!generatedExtension.f20572d.isRepeated() || !generatedExtension.f20572d.isPacked()) {
            Object obj2 = null;
            if (generatedExtension.getLiteType() != WireFormat.FieldType.ENUM) {
                switch (C3713a.f20792a[generatedExtension.getLiteType().ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(k0Var.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(k0Var.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(k0Var.mo23825M());
                        break;
                    case 4:
                        obj2 = Long.valueOf(k0Var.mo23831b());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(k0Var.mo23820H());
                        break;
                    case 6:
                        obj2 = Long.valueOf(k0Var.mo23832c());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(k0Var.mo23842k());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(k0Var.mo23843l());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(k0Var.mo23848q());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(k0Var.mo23822J());
                        break;
                    case 11:
                        obj2 = Long.valueOf(k0Var.mo23845n());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(k0Var.mo23857x());
                        break;
                    case 13:
                        obj2 = Long.valueOf(k0Var.mo23858y());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = k0Var.mo23818F();
                        break;
                    case 16:
                        obj2 = k0Var.mo23835e();
                        break;
                    case 17:
                        obj2 = k0Var.mo23813A(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite);
                        break;
                    case 18:
                        obj2 = k0Var.mo23841j(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite);
                        break;
                }
            } else {
                int H = k0Var.mo23820H();
                if (generatedExtension.f20572d.getEnumType().findValueByNumber(H) == null) {
                    return C3726o0.m13535L(number, H, ub, r0Var);
                }
                obj2 = Integer.valueOf(H);
            }
            if (generatedExtension.isRepeated()) {
                fieldSet.mo23280a(generatedExtension.f20572d, obj2);
            } else {
                int i = C3713a.f20792a[generatedExtension.getLiteType().ordinal()];
                if ((i == 17 || i == 18) && (j = fieldSet.mo23287j(generatedExtension.f20572d)) != null) {
                    obj2 = Internal.m12793d(j, obj2);
                }
                fieldSet.mo23278C(generatedExtension.f20572d, obj2);
            }
        } else {
            switch (C3713a.f20792a[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    k0Var.mo23824L(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    k0Var.mo23819G(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    k0Var.mo23849r(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    k0Var.mo23846o(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    k0Var.mo23853t(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    k0Var.mo23827O(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    k0Var.mo23856w(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    k0Var.mo23859z(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    k0Var.mo23840i(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    k0Var.mo23834d(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    k0Var.mo23852s(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    k0Var.mo23829a(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    k0Var.mo23837g(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    k0Var.mo23854u(arrayList);
                    ub = C3726o0.m13580z(number, arrayList, generatedExtension.f20572d.getEnumType(), ub, r0Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f20572d.getLiteType());
            }
            fieldSet.mo23278C(generatedExtension.f20572d, arrayList);
        }
        return ub;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo23898h(C3714k0 k0Var, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.C3643b> fieldSet) {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.mo23278C(generatedExtension.f20572d, k0Var.mo23841j(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo23899i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.C3643b> fieldSet) {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        MessageLite buildPartial = generatedExtension.getMessageDefaultInstance().newBuilderForType().buildPartial();
        C3693d P = C3693d.m13199P(ByteBuffer.wrap(byteString.toByteArray()), true);
        C3707h0.m13389a().mo23884b(buildPartial, P, extensionRegistryLite);
        fieldSet.mo23278C(generatedExtension.f20572d, buildPartial);
        if (P.mo23814B() != Integer.MAX_VALUE) {
            throw InvalidProtocolBufferException.m12799a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo23900j(Writer writer, Map.Entry<?, ?> entry) {
        GeneratedMessageLite.C3643b bVar = (GeneratedMessageLite.C3643b) entry.getKey();
        if (bVar.isRepeated()) {
            switch (C3713a.f20792a[bVar.getLiteType().ordinal()]) {
                case 1:
                    C3726o0.m13539P(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 2:
                    C3726o0.m13543T(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 3:
                    C3726o0.m13546W(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 4:
                    C3726o0.m13559e0(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 5:
                    C3726o0.m13545V(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 6:
                    C3726o0.m13542S(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 7:
                    C3726o0.m13541R(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 8:
                    C3726o0.m13537N(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 9:
                    C3726o0.m13557d0(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 10:
                    C3726o0.m13548Y(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 11:
                    C3726o0.m13549Z(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 12:
                    C3726o0.m13551a0(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 13:
                    C3726o0.m13553b0(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 14:
                    C3726o0.m13545V(bVar.getNumber(), (List) entry.getValue(), writer, bVar.isPacked());
                    return;
                case 15:
                    C3726o0.m13538O(bVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    C3726o0.m13555c0(bVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        C3726o0.m13544U(bVar.getNumber(), (List) entry.getValue(), writer, C3707h0.m13389a().mo23886d(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        C3726o0.m13547X(bVar.getNumber(), (List) entry.getValue(), writer, C3707h0.m13389a().mo23886d(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (C3713a.f20792a[bVar.getLiteType().ordinal()]) {
                case 1:
                    writer.mo23780g(bVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.mo23765G(bVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.mo23790q(bVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.mo23788o(bVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    writer.mo23796w(bVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.mo23784k(bVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.mo23779f(bVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    writer.mo23791r(bVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.mo23777d(bVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.mo23793t(bVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.mo23799z(bVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    writer.mo23772N(bVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.mo23764F(bVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    writer.mo23796w(bVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    writer.mo23795v(bVar.getNumber(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.mo23787n(bVar.getNumber(), (String) entry.getValue());
                    return;
                case 17:
                    writer.mo23792s(bVar.getNumber(), entry.getValue(), C3707h0.m13389a().mo23886d(entry.getValue().getClass()));
                    return;
                case 18:
                    writer.mo23783j(bVar.getNumber(), entry.getValue(), C3707h0.m13389a().mo23886d(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }
}
