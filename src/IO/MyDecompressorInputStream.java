package IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDecompressorInputStream extends InputStream {

    private InputStream in;
    public MyDecompressorInputStream(InputStream IS){
        in=IS;
    }

    @Override
    public int read() throws IOException {
        return this.in.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        int val = in.read();
        int counter = 0;
        int num = 0;
        while (val != -1) {
            if (counter < 24) {
                b[counter] = (byte) val;
                counter++;
            }
            else {
                for (int i = 0; i < val; i++) {
                    if (num == 0) {
                        b[counter] = (byte) 0;
                        counter++;
                    } else {
                        b[counter] = (byte) 1;
                        counter++;
                    }
                }
                if (num == 0) {
                    num = 1;
                } else {
                    num = 0;
                }
            }
            val = in.read();
        }
        return this.in.read(b);
    }
}
