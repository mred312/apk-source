package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    /* renamed from: A */
    void mo23759A(int i, List<Integer> list, boolean z);

    /* renamed from: B */
    void mo23760B(int i, List<Boolean> list, boolean z);

    /* renamed from: C */
    <K, V> void mo23761C(int i, MapEntryLite.C3657b<K, V> bVar, Map<K, V> map);

    /* renamed from: D */
    void mo23762D(int i, List<Integer> list, boolean z);

    /* renamed from: E */
    void mo23763E(int i, List<Long> list, boolean z);

    /* renamed from: F */
    void mo23764F(int i, long j);

    /* renamed from: G */
    void mo23765G(int i, float f);

    @Deprecated
    /* renamed from: H */
    void mo23766H(int i);

    /* renamed from: I */
    void mo23767I(int i, List<Integer> list, boolean z);

    /* renamed from: J */
    void mo23768J(int i, int i2);

    /* renamed from: K */
    void mo23769K(int i, List<Long> list, boolean z);

    /* renamed from: L */
    void mo23770L(int i, List<Integer> list, boolean z);

    /* renamed from: M */
    void mo23771M(int i, List<Double> list, boolean z);

    /* renamed from: N */
    void mo23772N(int i, int i2);

    /* renamed from: O */
    void mo23773O(int i, List<ByteString> list);

    /* renamed from: a */
    void mo23774a(int i, List<?> list, C3722m0 m0Var);

    @Deprecated
    /* renamed from: b */
    void mo23775b(int i, List<?> list, C3722m0 m0Var);

    /* renamed from: c */
    void mo23776c(int i, List<Float> list, boolean z);

    /* renamed from: d */
    void mo23777d(int i, int i2);

    /* renamed from: e */
    void mo23778e(int i, Object obj);

    /* renamed from: f */
    void mo23779f(int i, int i2);

    /* renamed from: g */
    void mo23780g(int i, double d);

    /* renamed from: h */
    void mo23781h(int i, List<Long> list, boolean z);

    /* renamed from: i */
    void mo23782i(int i, List<Long> list, boolean z);

    /* renamed from: j */
    void mo23783j(int i, Object obj, C3722m0 m0Var);

    /* renamed from: k */
    void mo23784k(int i, long j);

    /* renamed from: l */
    FieldOrder mo23785l();

    /* renamed from: m */
    void mo23786m(int i, List<String> list);

    /* renamed from: n */
    void mo23787n(int i, String str);

    /* renamed from: o */
    void mo23788o(int i, long j);

    /* renamed from: p */
    void mo23789p(int i, List<Integer> list, boolean z);

    /* renamed from: q */
    void mo23790q(int i, long j);

    /* renamed from: r */
    void mo23791r(int i, boolean z);

    @Deprecated
    /* renamed from: s */
    void mo23792s(int i, Object obj, C3722m0 m0Var);

    /* renamed from: t */
    void mo23793t(int i, int i2);

    @Deprecated
    /* renamed from: u */
    void mo23794u(int i);

    /* renamed from: v */
    void mo23795v(int i, ByteString byteString);

    /* renamed from: w */
    void mo23796w(int i, int i2);

    /* renamed from: x */
    void mo23797x(int i, List<Long> list, boolean z);

    /* renamed from: y */
    void mo23798y(int i, List<Integer> list, boolean z);

    /* renamed from: z */
    void mo23799z(int i, long j);
}
