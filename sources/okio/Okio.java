package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {

    /* renamed from: a */
    static final Logger f21369a = Logger.getLogger(Okio.class.getName());

    /* renamed from: okio.Okio$d */
    class C3574d extends AsyncTimeout {

        /* renamed from: j */
        final /* synthetic */ Socket f20205j;

        C3574d(Socket socket) {
            this.f20205j = socket;
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            try {
                this.f20205j.close();
            } catch (Exception e) {
                Logger logger = Okio.f21369a;
                Level level = Level.WARNING;
                logger.log(level, "Failed to close timed out socket " + this.f20205j, e);
            } catch (AssertionError e2) {
                if (Okio.m14429a(e2)) {
                    Logger logger2 = Okio.f21369a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + this.f20205j, e2);
                    return;
                }
                throw e2;
            }
        }
    }

    /* renamed from: okio.Okio$a */
    class C3963a implements Sink {

        /* renamed from: a */
        final /* synthetic */ Timeout f21370a;

        /* renamed from: b */
        final /* synthetic */ OutputStream f21371b;

        C3963a(Timeout timeout, OutputStream outputStream) {
            this.f21370a = timeout;
            this.f21371b = outputStream;
        }

        public void close() {
            this.f21371b.close();
        }

        public void flush() {
            this.f21371b.flush();
        }

        public Timeout timeout() {
            return this.f21370a;
        }

        public String toString() {
            return "sink(" + this.f21371b + ")";
        }

        public void write(Buffer buffer, long j) {
            C3972g.m14445b(buffer.f20194b, 0, j);
            while (j > 0) {
                this.f21370a.throwIfReached();
                C3578d dVar = buffer.f20193a;
                int min = (int) Math.min(j, (long) (dVar.f20215c - dVar.f20214b));
                this.f21371b.write(dVar.f20213a, dVar.f20214b, min);
                int i = dVar.f20214b + min;
                dVar.f20214b = i;
                long j2 = (long) min;
                j -= j2;
                buffer.f20194b -= j2;
                if (i == dVar.f20215c) {
                    buffer.f20193a = dVar.mo22596b();
                    C3579e.m12094a(dVar);
                }
            }
        }
    }

    /* renamed from: okio.Okio$b */
    class C3964b implements Source {

        /* renamed from: a */
        final /* synthetic */ Timeout f21372a;

        /* renamed from: b */
        final /* synthetic */ InputStream f21373b;

        C3964b(Timeout timeout, InputStream inputStream) {
            this.f21372a = timeout;
            this.f21373b = inputStream;
        }

        public void close() {
            this.f21373b.close();
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (j == 0) {
                return 0;
            } else {
                try {
                    this.f21372a.throwIfReached();
                    C3578d g = buffer.mo22432g(1);
                    int read = this.f21373b.read(g.f20213a, g.f20215c, (int) Math.min(j, (long) (8192 - g.f20215c)));
                    if (read == -1) {
                        return -1;
                    }
                    g.f20215c += read;
                    long j2 = (long) read;
                    buffer.f20194b += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (Okio.m14429a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        public Timeout timeout() {
            return this.f21372a;
        }

        public String toString() {
            return "source(" + this.f21373b + ")";
        }
    }

    /* renamed from: okio.Okio$c */
    class C3965c implements Sink {
        C3965c() {
        }

        public void close() {
        }

        public void flush() {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer buffer, long j) {
            buffer.skip(j);
        }
    }

    private Okio() {
    }

    /* renamed from: a */
    static boolean m14429a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink appendingSink(File file) {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: b */
    private static Sink m14430b(OutputStream outputStream, Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new C3963a(timeout, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink blackhole() {
        return new C3965c();
    }

    public static BufferedSource buffer(Source source) {
        return new C3576c(source);
    }

    /* renamed from: c */
    private static Source m14431c(InputStream inputStream, Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new C3964b(timeout, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: d */
    private static AsyncTimeout m14432d(Socket socket) {
        return new C3574d(socket);
    }

    public static Sink sink(OutputStream outputStream) {
        return m14430b(outputStream, new Timeout());
    }

    public static Source source(InputStream inputStream) {
        return m14431c(inputStream, new Timeout());
    }

    public static BufferedSink buffer(Sink sink) {
        return new C3969b(sink);
    }

    public static Sink sink(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            AsyncTimeout d = m14432d(socket);
            return d.sink(m14430b(socket.getOutputStream(), d));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static Source source(File file) {
        if (file != null) {
            return source((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static Source source(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            AsyncTimeout d = m14432d(socket);
            return d.source(m14431c(socket.getInputStream(), d));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    public static Sink sink(File file) {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static Sink sink(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }
}
