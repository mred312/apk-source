package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

public final class RouteException extends RuntimeException {

    /* renamed from: a */
    private IOException f21115a;

    /* renamed from: b */
    private IOException f21116b;

    public RouteException(IOException iOException) {
        super(iOException);
        this.f21115a = iOException;
        this.f21116b = iOException;
    }

    public void addConnectException(IOException iOException) {
        Util.addSuppressedIfPossible(this.f21115a, iOException);
        this.f21116b = iOException;
    }

    public IOException getFirstConnectException() {
        return this.f21115a;
    }

    public IOException getLastConnectException() {
        return this.f21116b;
    }
}
