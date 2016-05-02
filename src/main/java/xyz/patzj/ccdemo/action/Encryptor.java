package xyz.patzj.ccdemo.action;

/**
 * @author patzj
 */
public class Encryptor {

    private int key;
    private String plain;
    private StringBuilder cipher;

    public Encryptor() { }

    public Encryptor(String plain, int key) {
        this.plain = plain;
        this.key = key;
    }

    public String getPlain() {
        return plain;
    }

    public void setPlain(String plain) {
        this.plain = plain;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if(key > 0)
            this.key = key;
        else
            this.key = (-1) * key;
    }

    public String getCipher() {
        return cipher.toString();
    }

    public void doEncrypt() {

    }
}
