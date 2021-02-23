package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdmu {

    /* renamed from: id */
    public final String f15787id;
    public final boolean zzbpc;
    @Nullable
    public final String zzche;
    public final String zzdkx;
    public final String zzdli;
    public final String zzdlj;
    public final List<String> zzdls;
    public final List<String> zzdlt;
    public final String zzdly;
    public final boolean zzdmf;
    public final boolean zzdmg;
    public final boolean zzdmh;
    public final String zzdnt;
    public final List<String> zzdup;
    public final String zzdus;
    public final String zzduv;
    @Nullable
    public final zzava zzdvb;
    public final List<String> zzdvc;
    public final List<String> zzdvd;
    public final boolean zzdvl;
    public final boolean zzdvo;
    public final boolean zzdvp;
    public final boolean zzdxi;
    public final boolean zzerh;
    public final String zzetp;
    public final int zzfsa;
    public final boolean zzfsb;
    public final boolean zzfsc;
    public final String zzfxo;
    public final List<String> zzhgo;
    public final int zzhgp;
    public final int zzhgq;
    public final List<String> zzhgr;
    public final List<String> zzhgs;
    public final List<String> zzhgt;
    public final List<String> zzhgu;
    public final int zzhgv;
    public final List<zzdmx> zzhgw;
    @Nullable
    public final zzdnb zzhgx;
    public final List<String> zzhgy;
    public final List<zzdmx> zzhgz;
    public final JSONObject zzhha;
    public final zzawp zzhhb;
    public final JSONObject zzhhc;
    public final JSONObject zzhhd;
    public final String zzhhe;
    public final boolean zzhhf;
    public final int zzhhg;
    public final int zzhhh;
    public final OmidSettings zzhhi;
    public final int zzhhj;
    public final boolean zzhhk;
    public final zzaro zzhhl;
    @Nullable
    public final zzvp zzhhm;
    public final String zzhhn;
    public final boolean zzhho;
    public final JSONObject zzhhp;
    public final boolean zzhhq;
    public final JSONObject zzhhr;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzdmu(android.util.JsonReader r74) {
        /*
            r73 = this;
            r0 = r73
            r73.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            r74.beginObject()
            r20 = r1
            r21 = -1
            r22 = 0
            java.lang.String r1 = ""
            r23 = r2
            r32 = r1
            r33 = r32
            r37 = r33
            r38 = r37
            r39 = r38
            r40 = r39
            r42 = r40
            r53 = r42
            r58 = r53
            r60 = r58
            r65 = r60
            r67 = r65
            r24 = r14
            r25 = r15
            r26 = r16
            r27 = r17
            r28 = r18
            r29 = r19
            r34 = r22
            r36 = r34
            r41 = r36
            r62 = r41
            r64 = r62
            r69 = r64
            r30 = 0
            r31 = 0
            r35 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = -1
            r51 = 0
            r52 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = -1
            r61 = 0
            r63 = 1
            r66 = 0
            r68 = 0
            r14 = r12
            r15 = r13
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r23
            r5 = r3
            r3 = r20
        L_0x00d2:
            boolean r16 = r74.hasNext()
            if (r16 == 0) goto L_0x0759
            java.lang.String r16 = r74.nextName()
            if (r16 != 0) goto L_0x00e1
            r17 = r1
            goto L_0x00e3
        L_0x00e1:
            r17 = r16
        L_0x00e3:
            r17.hashCode()
            int r16 = r17.hashCode()
            r18 = 7
            r19 = 5
            r20 = 4
            r23 = 3
            r70 = 2
            r71 = 6
            switch(r16) {
                case -1980587809: goto L_0x0513;
                case -1965512151: goto L_0x0504;
                case -1812055556: goto L_0x04f5;
                case -1662989631: goto L_0x04e6;
                case -1620470467: goto L_0x04d7;
                case -1440104884: goto L_0x04c8;
                case -1439500848: goto L_0x04b7;
                case -1428969291: goto L_0x04a6;
                case -1403779768: goto L_0x0494;
                case -1375413093: goto L_0x0482;
                case -1360811658: goto L_0x0470;
                case -1306015996: goto L_0x045e;
                case -1303332046: goto L_0x044c;
                case -1289032093: goto L_0x043a;
                case -1240082064: goto L_0x0428;
                case -1234181075: goto L_0x0416;
                case -1181000426: goto L_0x0404;
                case -1168140544: goto L_0x03f2;
                case -1152230954: goto L_0x03e0;
                case -1146534047: goto L_0x03ce;
                case -1115838944: goto L_0x03bc;
                case -1081936678: goto L_0x03aa;
                case -1078050970: goto L_0x0398;
                case -1051269058: goto L_0x0386;
                case -982608540: goto L_0x0374;
                case -776859333: goto L_0x0362;
                case -544216775: goto L_0x0350;
                case -437057161: goto L_0x033e;
                case -404433734: goto L_0x032c;
                case -404326515: goto L_0x031a;
                case -397704715: goto L_0x0308;
                case -388807511: goto L_0x02f6;
                case -369773488: goto L_0x02e4;
                case -213424028: goto L_0x02d2;
                case -154616268: goto L_0x02c0;
                case -29338502: goto L_0x02ae;
                case 3107: goto L_0x029c;
                case 3355: goto L_0x028a;
                case 3076010: goto L_0x0278;
                case 63195984: goto L_0x0266;
                case 107433883: goto L_0x0254;
                case 230323073: goto L_0x0242;
                case 418392395: goto L_0x0230;
                case 549176928: goto L_0x021e;
                case 597473788: goto L_0x020c;
                case 673261304: goto L_0x01fa;
                case 754887508: goto L_0x01e8;
                case 791122864: goto L_0x01d6;
                case 1010584092: goto L_0x01c4;
                case 1100650276: goto L_0x01b2;
                case 1321720943: goto L_0x01a0;
                case 1637553475: goto L_0x018e;
                case 1638957285: goto L_0x017c;
                case 1686319423: goto L_0x016a;
                case 1688341040: goto L_0x0158;
                case 1799285870: goto L_0x0146;
                case 1839650832: goto L_0x0134;
                case 1875425491: goto L_0x0122;
                case 2068142375: goto L_0x0110;
                case 2072888499: goto L_0x00fe;
                default: goto L_0x00f9;
            }
        L_0x00f9:
            r72 = r15
        L_0x00fb:
            r2 = -1
            goto L_0x0522
        L_0x00fe:
            java.lang.String r2 = "manual_tracking_urls"
            r72 = r15
            r15 = r17
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x010c
            goto L_0x051f
        L_0x010c:
            r2 = 59
            goto L_0x0522
        L_0x0110:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "rule_line_external_id"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x011e
            goto L_0x051f
        L_0x011e:
            r2 = 58
            goto L_0x0522
        L_0x0122:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_analytics_logging_enabled"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0130
            goto L_0x051f
        L_0x0130:
            r2 = 57
            goto L_0x0522
        L_0x0134:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "renderers"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0142
            goto L_0x051f
        L_0x0142:
            r2 = 56
            goto L_0x0522
        L_0x0146:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "use_third_party_container_height"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0154
            goto L_0x051f
        L_0x0154:
            r2 = 55
            goto L_0x0522
        L_0x0158:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "video_reward_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0166
            goto L_0x051f
        L_0x0166:
            r2 = 54
            goto L_0x0522
        L_0x016a:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad_network_class_name"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0178
            goto L_0x051f
        L_0x0178:
            r2 = 53
            goto L_0x0522
        L_0x017c:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "video_start_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x018a
            goto L_0x051f
        L_0x018a:
            r2 = 52
            goto L_0x0522
        L_0x018e:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "bid_response"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x019c
            goto L_0x051f
        L_0x019c:
            r2 = 51
            goto L_0x0522
        L_0x01a0:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "allow_pub_owned_ad_view"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x01ae
            goto L_0x051f
        L_0x01ae:
            r2 = 50
            goto L_0x0522
        L_0x01b2:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "rewards"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x01c0
            goto L_0x051f
        L_0x01c0:
            r2 = 49
            goto L_0x0522
        L_0x01c4:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "transaction_id"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x01d2
            goto L_0x051f
        L_0x01d2:
            r2 = 48
            goto L_0x0522
        L_0x01d6:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "impression_type"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x01e4
            goto L_0x051f
        L_0x01e4:
            r2 = 47
            goto L_0x0522
        L_0x01e8:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "container_sizes"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x01f6
            goto L_0x051f
        L_0x01f6:
            r2 = 46
            goto L_0x0522
        L_0x01fa:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "reward_granted_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0208
            goto L_0x051f
        L_0x0208:
            r2 = 45
            goto L_0x0522
        L_0x020c:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "debug_dialog_string"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x021a
            goto L_0x051f
        L_0x021a:
            r2 = 44
            goto L_0x0522
        L_0x021e:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "presentation_error_timeout_ms"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x022c
            goto L_0x051f
        L_0x022c:
            r2 = 43
            goto L_0x0522
        L_0x0230:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_closable_area_disabled"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x023e
            goto L_0x051f
        L_0x023e:
            r2 = 42
            goto L_0x0522
        L_0x0242:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad_load_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0250
            goto L_0x051f
        L_0x0250:
            r2 = 41
            goto L_0x0522
        L_0x0254:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "qdata"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0262
            goto L_0x051f
        L_0x0262:
            r2 = 40
            goto L_0x0522
        L_0x0266:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "render_test_label"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0274
            goto L_0x051f
        L_0x0274:
            r2 = 39
            goto L_0x0522
        L_0x0278:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "data"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0286
            goto L_0x051f
        L_0x0286:
            r2 = 38
            goto L_0x0522
        L_0x028a:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "id"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0298
            goto L_0x051f
        L_0x0298:
            r2 = 37
            goto L_0x0522
        L_0x029c:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02aa
            goto L_0x051f
        L_0x02aa:
            r2 = 36
            goto L_0x0522
        L_0x02ae:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "allow_custom_click_gesture"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02bc
            goto L_0x051f
        L_0x02bc:
            r2 = 35
            goto L_0x0522
        L_0x02c0:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_offline_ad"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02ce
            goto L_0x051f
        L_0x02ce:
            r2 = 34
            goto L_0x0522
        L_0x02d2:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "watermark"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02e0
            goto L_0x051f
        L_0x02e0:
            r2 = 33
            goto L_0x0522
        L_0x02e4:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_close_button_enabled"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x02f2
            goto L_0x051f
        L_0x02f2:
            r2 = 32
            goto L_0x0522
        L_0x02f6:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "content_url"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0304
            goto L_0x051f
        L_0x0304:
            r2 = 31
            goto L_0x0522
        L_0x0308:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad_close_time_ms"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0316
            goto L_0x051f
        L_0x0316:
            r2 = 30
            goto L_0x0522
        L_0x031a:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "render_timeout_ms"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0328
            goto L_0x051f
        L_0x0328:
            r2 = 29
            goto L_0x0522
        L_0x032c:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "rtb_native_required_assets"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x033a
            goto L_0x051f
        L_0x033a:
            r2 = 28
            goto L_0x0522
        L_0x033e:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "imp_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x034c
            goto L_0x051f
        L_0x034c:
            r2 = 27
            goto L_0x0522
        L_0x0350:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "safe_browsing"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x035e
            goto L_0x051f
        L_0x035e:
            r2 = 26
            goto L_0x0522
        L_0x0362:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "click_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0370
            goto L_0x051f
        L_0x0370:
            r2 = 25
            goto L_0x0522
        L_0x0374:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "valid_from_timestamp"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0382
            goto L_0x051f
        L_0x0382:
            r2 = 24
            goto L_0x0522
        L_0x0386:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "active_view"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0394
            goto L_0x051f
        L_0x0394:
            r2 = 23
            goto L_0x0522
        L_0x0398:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "video_complete_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x03a6
            goto L_0x051f
        L_0x03a6:
            r2 = 22
            goto L_0x0522
        L_0x03aa:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "allocation_id"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x03b8
            goto L_0x051f
        L_0x03b8:
            r2 = 21
            goto L_0x0522
        L_0x03bc:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "fill_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x03ca
            goto L_0x051f
        L_0x03ca:
            r2 = 20
            goto L_0x0522
        L_0x03ce:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_scroll_aware"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x03dc
            goto L_0x051f
        L_0x03dc:
            r2 = 19
            goto L_0x0522
        L_0x03e0:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad_type"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x03ee
            goto L_0x051f
        L_0x03ee:
            r2 = 18
            goto L_0x0522
        L_0x03f2:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "presentation_error_urls"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0400
            goto L_0x051f
        L_0x0400:
            r2 = 17
            goto L_0x0522
        L_0x0404:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_augmented_reality_ad"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0412
            goto L_0x051f
        L_0x0412:
            r2 = 16
            goto L_0x0522
        L_0x0416:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "allow_pub_rendered_attribution"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0424
            goto L_0x051f
        L_0x0424:
            r2 = 15
            goto L_0x0522
        L_0x0428:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad_event_value"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0436
            goto L_0x051f
        L_0x0436:
            r2 = 14
            goto L_0x0522
        L_0x043a:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "extras"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0448
            goto L_0x051f
        L_0x0448:
            r2 = 13
            goto L_0x0522
        L_0x044c:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "test_mode_enabled"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x045a
            goto L_0x051f
        L_0x045a:
            r2 = 12
            goto L_0x0522
        L_0x045e:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "adapters"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x046c
            goto L_0x051f
        L_0x046c:
            r2 = 11
            goto L_0x0522
        L_0x0470:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad_sizes"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x047e
            goto L_0x051f
        L_0x047e:
            r2 = 10
            goto L_0x0522
        L_0x0482:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "ad_cover"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0490
            goto L_0x051f
        L_0x0490:
            r2 = 9
            goto L_0x0522
        L_0x0494:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "showable_impression_type"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x04a2
            goto L_0x051f
        L_0x04a2:
            r2 = 8
            goto L_0x0522
        L_0x04a6:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "enable_omid"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x04b4
            goto L_0x051f
        L_0x04b4:
            r2 = 7
            goto L_0x0522
        L_0x04b7:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "orientation"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x04c5
            goto L_0x051f
        L_0x04c5:
            r2 = 6
            goto L_0x0522
        L_0x04c8:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_custom_close_blocked"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x04d5
            goto L_0x051f
        L_0x04d5:
            r2 = 5
            goto L_0x0522
        L_0x04d7:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "backend_query_id"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x04e4
            goto L_0x051f
        L_0x04e4:
            r2 = 4
            goto L_0x0522
        L_0x04e6:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "is_interscroller"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x04f3
            goto L_0x051f
        L_0x04f3:
            r2 = 3
            goto L_0x0522
        L_0x04f5:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "play_prewarm_options"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0502
            goto L_0x051f
        L_0x0502:
            r2 = 2
            goto L_0x0522
        L_0x0504:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "omid_settings"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0511
            goto L_0x051f
        L_0x0511:
            r2 = 1
            goto L_0x0522
        L_0x0513:
            r72 = r15
            r15 = r17
            java.lang.String r2 = "debug_signals"
            boolean r2 = r15.equals(r2)
            if (r2 != 0) goto L_0x0521
        L_0x051f:
            goto L_0x00fb
        L_0x0521:
            r2 = 0
        L_0x0522:
            switch(r2) {
                case 0: goto L_0x0751;
                case 1: goto L_0x0749;
                case 2: goto L_0x0724;
                case 3: goto L_0x071e;
                case 4: goto L_0x0718;
                case 5: goto L_0x0712;
                case 6: goto L_0x06ec;
                case 7: goto L_0x06e6;
                case 8: goto L_0x06e0;
                case 9: goto L_0x06da;
                case 10: goto L_0x06d4;
                case 11: goto L_0x06ce;
                case 12: goto L_0x06c8;
                case 13: goto L_0x06c2;
                case 14: goto L_0x06b8;
                case 15: goto L_0x06b2;
                case 16: goto L_0x06ac;
                case 17: goto L_0x06a6;
                case 18: goto L_0x0654;
                case 19: goto L_0x064c;
                case 20: goto L_0x0644;
                case 21: goto L_0x063c;
                case 22: goto L_0x0634;
                case 23: goto L_0x0628;
                case 24: goto L_0x0620;
                case 25: goto L_0x0618;
                case 26: goto L_0x060c;
                case 27: goto L_0x0604;
                case 28: goto L_0x05fc;
                case 29: goto L_0x05f4;
                case 30: goto L_0x05ec;
                case 31: goto L_0x05e4;
                case 32: goto L_0x05dc;
                case 33: goto L_0x05d4;
                case 34: goto L_0x05cc;
                case 35: goto L_0x05c4;
                case 36: goto L_0x05b8;
                case 37: goto L_0x05b2;
                case 38: goto L_0x05ac;
                case 39: goto L_0x05a6;
                case 40: goto L_0x05a0;
                case 41: goto L_0x059a;
                case 42: goto L_0x0594;
                case 43: goto L_0x058e;
                case 44: goto L_0x0588;
                case 45: goto L_0x0583;
                case 46: goto L_0x057d;
                case 47: goto L_0x056d;
                case 48: goto L_0x0568;
                case 49: goto L_0x055f;
                case 50: goto L_0x055a;
                case 51: goto L_0x0555;
                case 52: goto L_0x0550;
                case 53: goto L_0x054b;
                case 54: goto L_0x0546;
                case 55: goto L_0x0541;
                case 56: goto L_0x0539;
                case 57: goto L_0x0534;
                case 58: goto L_0x052f;
                case 59: goto L_0x052a;
                default: goto L_0x0525;
            }
        L_0x0525:
            r74.skipValue()
            r15 = 1
            goto L_0x053d
        L_0x052a:
            java.util.List r12 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x052f:
            java.lang.String r65 = r74.nextString()
            goto L_0x053d
        L_0x0534:
            boolean r54 = r74.nextBoolean()
            goto L_0x053d
        L_0x0539:
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
        L_0x053d:
            r15 = r72
            goto L_0x00d2
        L_0x0541:
            boolean r61 = r74.nextBoolean()
            goto L_0x053d
        L_0x0546:
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x054b:
            java.lang.String r67 = r74.nextString()
            goto L_0x053d
        L_0x0550:
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x0555:
            java.lang.String r53 = r74.nextString()
            goto L_0x053d
        L_0x055a:
            boolean r44 = r74.nextBoolean()
            goto L_0x053d
        L_0x055f:
            org.json.JSONArray r2 = com.google.android.gms.ads.internal.util.zzbk.zzd(r74)
            com.google.android.gms.internal.ads.zzava r34 = com.google.android.gms.internal.ads.zzava.zza(r2)
            goto L_0x053d
        L_0x0568:
            java.lang.String r32 = r74.nextString()
            goto L_0x053d
        L_0x056d:
            int r2 = r74.nextInt()
            r15 = 1
            if (r2 == 0) goto L_0x057a
            if (r2 != r15) goto L_0x0577
            goto L_0x057a
        L_0x0577:
            r31 = 0
            goto L_0x053d
        L_0x057a:
            r31 = r2
            goto L_0x053d
        L_0x057d:
            r15 = 1
            java.util.List r13 = com.google.android.gms.internal.ads.zzdmx.m8424a(r74)
            goto L_0x053d
        L_0x0583:
            r15 = 1
            com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x0588:
            r15 = 1
            java.lang.String r42 = r74.nextString()
            goto L_0x053d
        L_0x058e:
            r15 = 1
            int r35 = r74.nextInt()
            goto L_0x053d
        L_0x0594:
            r15 = 1
            boolean r49 = r74.nextBoolean()
            goto L_0x053d
        L_0x059a:
            r15 = 1
            java.util.List r6 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x05a0:
            r15 = 1
            java.lang.String r39 = r74.nextString()
            goto L_0x053d
        L_0x05a6:
            r15 = 1
            boolean r46 = r74.nextBoolean()
            goto L_0x053d
        L_0x05ac:
            r15 = 1
            org.json.JSONObject r24 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            goto L_0x053d
        L_0x05b2:
            r15 = 1
            java.lang.String r38 = r74.nextString()
            goto L_0x053d
        L_0x05b8:
            r15 = 1
            com.google.android.gms.internal.ads.zzdnb r2 = new com.google.android.gms.internal.ads.zzdnb
            r15 = r74
            r2.<init>(r15)
            r36 = r2
            goto L_0x053d
        L_0x05c4:
            r15 = r74
            boolean r45 = r74.nextBoolean()
            goto L_0x053d
        L_0x05cc:
            r15 = r74
            boolean r68 = r74.nextBoolean()
            goto L_0x053d
        L_0x05d4:
            r15 = r74
            java.lang.String r58 = r74.nextString()
            goto L_0x053d
        L_0x05dc:
            r15 = r74
            boolean r63 = r74.nextBoolean()
            goto L_0x053d
        L_0x05e4:
            r15 = r74
            java.lang.String r69 = r74.nextString()
            goto L_0x053d
        L_0x05ec:
            r15 = r74
            int r59 = r74.nextInt()
            goto L_0x053d
        L_0x05f4:
            r15 = r74
            int r51 = r74.nextInt()
            goto L_0x053d
        L_0x05fc:
            r15 = r74
            org.json.JSONObject r29 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            goto L_0x053d
        L_0x0604:
            r15 = r74
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x060c:
            r15 = r74
            org.json.JSONObject r2 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            com.google.android.gms.internal.ads.zzawp r41 = com.google.android.gms.internal.ads.zzawp.zzg(r2)
            goto L_0x053d
        L_0x0618:
            r15 = r74
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x0620:
            r15 = r74
            java.lang.String r33 = r74.nextString()
            goto L_0x053d
        L_0x0628:
            r15 = r74
            org.json.JSONObject r2 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            java.lang.String r40 = r2.toString()
            goto L_0x053d
        L_0x0634:
            r15 = r74
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x063c:
            r15 = r74
            java.lang.String r37 = r74.nextString()
            goto L_0x053d
        L_0x0644:
            r15 = r74
            java.util.List r10 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x064c:
            r15 = r74
            boolean r55 = r74.nextBoolean()
            goto L_0x053d
        L_0x0654:
            r15 = r74
            java.lang.String r2 = r74.nextString()
            java.lang.String r15 = "banner"
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto L_0x0666
            r30 = 1
            goto L_0x053d
        L_0x0666:
            java.lang.String r15 = "interstitial"
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto L_0x0672
            r30 = 2
            goto L_0x053d
        L_0x0672:
            java.lang.String r15 = "native_express"
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto L_0x067e
            r30 = 3
            goto L_0x053d
        L_0x067e:
            java.lang.String r15 = "native"
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto L_0x068a
            r30 = 4
            goto L_0x053d
        L_0x068a:
            java.lang.String r15 = "rewarded"
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto L_0x0696
            r30 = 5
            goto L_0x053d
        L_0x0696:
            java.lang.String r15 = "app_open_ad"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x06a2
            r30 = 6
            goto L_0x053d
        L_0x06a2:
            r30 = 0
            goto L_0x053d
        L_0x06a6:
            java.util.List r11 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x06ac:
            boolean r57 = r74.nextBoolean()
            goto L_0x053d
        L_0x06b2:
            boolean r43 = r74.nextBoolean()
            goto L_0x053d
        L_0x06b8:
            org.json.JSONObject r2 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            com.google.android.gms.internal.ads.zzvp r64 = com.google.android.gms.internal.ads.zzvp.zza(r2)
            goto L_0x053d
        L_0x06c2:
            org.json.JSONObject r26 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            goto L_0x053d
        L_0x06c8:
            boolean r47 = r74.nextBoolean()
            goto L_0x053d
        L_0x06ce:
            java.util.List r14 = com.google.android.gms.ads.internal.util.zzbk.zza((android.util.JsonReader) r74)
            goto L_0x053d
        L_0x06d4:
            java.util.List r15 = com.google.android.gms.internal.ads.zzdmx.m8424a(r74)
            goto L_0x00d2
        L_0x06da:
            org.json.JSONObject r28 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            goto L_0x053d
        L_0x06e0:
            int r56 = r74.nextInt()
            goto L_0x053d
        L_0x06e6:
            boolean r52 = r74.nextBoolean()
            goto L_0x053d
        L_0x06ec:
            java.lang.String r2 = r74.nextString()
            java.lang.String r15 = "landscape"
            boolean r15 = r15.equalsIgnoreCase(r2)
            if (r15 == 0) goto L_0x06ff
            com.google.android.gms.ads.internal.zzp.zzks()
            r50 = 6
            goto L_0x053d
        L_0x06ff:
            java.lang.String r15 = "portrait"
            boolean r2 = r15.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x070e
            com.google.android.gms.ads.internal.zzp.zzks()
            r50 = 7
            goto L_0x053d
        L_0x070e:
            r50 = -1
            goto L_0x053d
        L_0x0712:
            boolean r48 = r74.nextBoolean()
            goto L_0x053d
        L_0x0718:
            java.lang.String r60 = r74.nextString()
            goto L_0x053d
        L_0x071e:
            boolean r66 = r74.nextBoolean()
            goto L_0x053d
        L_0x0724:
            org.json.JSONObject r2 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            if (r2 != 0) goto L_0x072f
            r17 = r14
            r62 = r22
            goto L_0x0745
        L_0x072f:
            java.lang.String r15 = "enable_prewarming"
            r17 = r14
            r14 = 0
            boolean r15 = r2.optBoolean(r15, r14)
            java.lang.String r14 = "prefetch_url"
            java.lang.String r2 = r2.optString(r14, r1)
            com.google.android.gms.internal.ads.zzaro r14 = new com.google.android.gms.internal.ads.zzaro
            r14.<init>(r15, r2)
            r62 = r14
        L_0x0745:
            r14 = r17
            goto L_0x053d
        L_0x0749:
            r17 = r14
            org.json.JSONObject r27 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            goto L_0x053d
        L_0x0751:
            r17 = r14
            org.json.JSONObject r25 = com.google.android.gms.ads.internal.util.zzbk.zzc(r74)
            goto L_0x053d
        L_0x0759:
            r17 = r14
            r72 = r15
            r74.endObject()
            r0.zzhgo = r3
            r2 = r30
            r0.zzhgp = r2
            r0.zzdls = r4
            r0.zzdlt = r5
            r0.zzhgr = r6
            r2 = r31
            r0.zzhgq = r2
            r0.zzdvc = r7
            r0.zzdvd = r8
            r0.zzhgs = r9
            r1 = r32
            r0.zzdli = r1
            r1 = r33
            r0.zzdlj = r1
            r1 = r34
            r0.zzdvb = r1
            r0.zzhgt = r10
            r0.zzhgu = r11
            r0.zzdup = r12
            r2 = r35
            r0.zzhgv = r2
            r0.zzhgw = r13
            r2 = r36
            r0.zzhgx = r2
            r0.zzhgy = r14
            r0.zzhgz = r15
            r1 = r37
            r0.zzdkx = r1
            r14 = r24
            r0.zzhha = r14
            r1 = r38
            r0.f15787id = r1
            r1 = r39
            r0.zzdly = r1
            r1 = r40
            r0.zzduv = r1
            r1 = r41
            r0.zzhhb = r1
            r1 = r42
            r0.zzdus = r1
            r15 = r25
            r0.zzhhc = r15
            r1 = r26
            r0.zzhhd = r1
            r2 = r43
            r0.zzdmf = r2
            r2 = r44
            r0.zzdmg = r2
            r2 = r45
            r0.zzdmh = r2
            r2 = r46
            r0.zzdxi = r2
            r2 = r47
            r0.zzhhf = r2
            r2 = r48
            r0.zzfsc = r2
            r2 = r49
            r0.zzbpc = r2
            r1 = r50
            r0.zzhhg = r1
            r2 = r51
            r0.zzhhh = r2
            r2 = r52
            r0.zzdvl = r2
            r1 = r53
            r0.zzetp = r1
            com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings r1 = new com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings
            r2 = r27
            r1.<init>(r2)
            r0.zzhhi = r1
            r2 = r54
            r0.zzdvo = r2
            r2 = r55
            r0.zzdvp = r2
            r2 = r56
            r0.zzhhj = r2
            r2 = r57
            r0.zzerh = r2
            r1 = r58
            r0.zzdnt = r1
            r1 = r59
            r0.zzfsa = r1
            r1 = r60
            r0.zzfxo = r1
            r2 = r61
            r0.zzhhk = r2
            r1 = r62
            r0.zzhhl = r1
            r1 = r63
            r0.zzfsb = r1
            r1 = r64
            r0.zzhhm = r1
            r1 = r65
            r0.zzhhn = r1
            r2 = r66
            r0.zzhho = r2
            r1 = r28
            r0.zzhhp = r1
            r1 = r67
            r0.zzhhe = r1
            r2 = r68
            r0.zzhhq = r2
            r1 = r29
            r0.zzhhr = r1
            r1 = r69
            r0.zzche = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmu.<init>(android.util.JsonReader):void");
    }
}
