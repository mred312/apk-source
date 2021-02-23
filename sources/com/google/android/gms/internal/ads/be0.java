package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
class be0 extends X509Certificate {

    /* renamed from: a */
    private final X509Certificate f7912a;

    public be0(X509Certificate x509Certificate) {
        this.f7912a = x509Certificate;
    }

    public void checkValidity() {
        this.f7912a.checkValidity();
    }

    public int getBasicConstraints() {
        return this.f7912a.getBasicConstraints();
    }

    public Set<String> getCriticalExtensionOIDs() {
        return this.f7912a.getCriticalExtensionOIDs();
    }

    public byte[] getExtensionValue(String str) {
        return this.f7912a.getExtensionValue(str);
    }

    public Principal getIssuerDN() {
        return this.f7912a.getIssuerDN();
    }

    public boolean[] getIssuerUniqueID() {
        return this.f7912a.getIssuerUniqueID();
    }

    public boolean[] getKeyUsage() {
        return this.f7912a.getKeyUsage();
    }

    public Set<String> getNonCriticalExtensionOIDs() {
        return this.f7912a.getNonCriticalExtensionOIDs();
    }

    public Date getNotAfter() {
        return this.f7912a.getNotAfter();
    }

    public Date getNotBefore() {
        return this.f7912a.getNotBefore();
    }

    public PublicKey getPublicKey() {
        return this.f7912a.getPublicKey();
    }

    public BigInteger getSerialNumber() {
        return this.f7912a.getSerialNumber();
    }

    public String getSigAlgName() {
        return this.f7912a.getSigAlgName();
    }

    public String getSigAlgOID() {
        return this.f7912a.getSigAlgOID();
    }

    public byte[] getSigAlgParams() {
        return this.f7912a.getSigAlgParams();
    }

    public byte[] getSignature() {
        return this.f7912a.getSignature();
    }

    public Principal getSubjectDN() {
        return this.f7912a.getSubjectDN();
    }

    public boolean[] getSubjectUniqueID() {
        return this.f7912a.getSubjectUniqueID();
    }

    public byte[] getTBSCertificate() {
        return this.f7912a.getTBSCertificate();
    }

    public int getVersion() {
        return this.f7912a.getVersion();
    }

    public boolean hasUnsupportedCriticalExtension() {
        return this.f7912a.hasUnsupportedCriticalExtension();
    }

    public String toString() {
        return this.f7912a.toString();
    }

    public void verify(PublicKey publicKey) {
        this.f7912a.verify(publicKey);
    }

    public void checkValidity(Date date) {
        this.f7912a.checkValidity(date);
    }

    public void verify(PublicKey publicKey, String str) {
        this.f7912a.verify(publicKey, str);
    }
}
