package xyz.patzj.ccdemo.action;

/**
 * @author patzj
 */
public class Encryptor extends Cryptor {

    public Encryptor() { }

    public Encryptor(String raw, int key) {
        super(raw, key);
    }

    @Override
    public void setKey(int key) {
        if(key < 0)
            key *= -1;

        super.setKey(key);
    }

    @Override
    protected void doFormat() {
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
            rawBytes[i] += getKey();

            int rem = rawBytes[i] % LIMIT;
            if(rem > 0)
                rawBytes[i] = (byte) rem;

            rawBytes[i] += Cryptor.BUFFER;
            temp.append((char) rawBytes[i]);
        }

        setProcessed(temp.toString().toUpperCase());
    }
}
