package xyz.patzj.ccdemo.action;

/**
 * Super class for Caesar Cipher algorithm.
 * @author patzj
 */
public abstract class Cryptor {

    private String raw;
    private String processed;
    private int key;

    public abstract void doProcess();
    public static final byte BUFFER = 96;
    public static final byte LIMIT = 26;

    public Cryptor() { }

    public Cryptor(String raw, int key) {
        setRaw(raw);
        setKey(key);
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = Math.abs(key);
    }

    protected void doFormat() {
        setRaw(getRaw().replaceAll("[\\W\\s\\d]", "").toLowerCase());
    }
}
