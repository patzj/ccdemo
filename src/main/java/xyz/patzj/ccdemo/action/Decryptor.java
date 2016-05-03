package xyz.patzj.ccdemo.action;

/**
 * @author patzj
 */
public class Decryptor extends Cryptor {

    public Decryptor() { }

    public Decryptor(String raw, int key) {
        super(raw, key);
    }

    @Override
    public void setKey(int key) {
        if(key > 0)
            key *= -1;

        super.setKey(key);
    }

    @Override
    public void doFormat() {
        setRaw(getRaw().replaceAll("\\s", "").toLowerCase());
    }

    @Override
    public void doProcess() {
        doFormat();
        StringBuilder temp = new StringBuilder();
        byte[] rawBytes = getRaw().getBytes();

        int len = rawBytes.length;
        for(int i = 0; i < len; i++) {
            rawBytes[i] -= Cryptor.BUFFER;
            rawBytes[i] -= getKey();

            if(rawBytes[i] < 1)
                rawBytes[i] += Cryptor.LIMIT;

            rawBytes[i] += Cryptor.BUFFER;
            temp.append((char) rawBytes[i]);
        }

        setProcessed(temp.toString().toUpperCase());
    }
}
