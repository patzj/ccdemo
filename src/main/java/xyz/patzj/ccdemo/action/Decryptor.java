package xyz.patzj.ccdemo.action;

/**
 * @author patzj
 */
public class Decryptor {

    private int key;
    private String cipher;
    private StringBuilder plain;

    public Decryptor() { }

    public Decryptor(String cipher) {
        this.cipher = cipher;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public int getKey() {
        return  key;
    }

    public void setKey(int key) {
        if(key > 0)
            this.key = (-1) * key;
        else
            this.key = key;
    }

    public String getPlain() {
        return plain.toString();
    }

    public void doDecrypt() {

    }
}
