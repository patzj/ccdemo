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
            rawBytes[i] -= Cryptor.BUFFER;
            setKey(getKey() % Cryptor.LIMIT);
            rawBytes[i] += getKey();

            int rem = rawBytes[i] % LIMIT;
            if(rem > 0)
                rawBytes[i] = (byte) rem;

            rawBytes[i] += Cryptor.BUFFER;
            temp.append((char) rawBytes[i]);
        }
        System.out.println(getKey());
        setProcessed(temp.toString().toUpperCase());
    }
}
