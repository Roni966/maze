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

        return 0;
    }
}
