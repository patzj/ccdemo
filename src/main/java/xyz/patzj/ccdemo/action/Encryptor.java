package xyz.patzj.ccdemo.action;

/**
 * Caesar Cipher encryption algorithm class.
 * @author patzj
 */
public class Encryptor extends Cryptor {

    public Encryptor() { }

    public Encryptor(String raw, int key) {
        super(raw, key);
    }

    @Override
    public void doProcess() {
        doFormat();
        StringBuilder temp = new StringBuilder();
        byte[] rawBytes = getRaw().getBytes();

        int len = rawBytes.length;
        for(int i = 0; i < len; i++) {
            setKey(getKey() % Cryptor.LIMIT);
            rawBytes[i] -= Cryptor.BUFFER;
            rawBytes[i] += getKey();

            if(rawBytes[i] > Cryptor.LIMIT)
                rawBytes[i] -= Cryptor.LIMIT;

            rawBytes[i] += Cryptor.BUFFER;
            temp.append((char) rawBytes[i]);
        }

        setProcessed(temp.toString().toUpperCase());
    }
}
