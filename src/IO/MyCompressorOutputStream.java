package IO;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

    private OutputStream out;

    public MyCompressorOutputStream(OutputStream OS){
        out=OS;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    public void write(byte[] b) throws IOException {
        for (int i = 0; i < 24; i++) {
            this.write(b[i] & 0xFF);
        }
        for (int i = 24; i < b.length; i+=3) {
            if (b.length - i > 2) {
                if ((b[i] == 0) && (b[i + 1] == 0) && (b[i + 2] == 0)) {
                    this.write(2);
                } else if ((b[i] == 0) && (b[i + 1] == 0) && (b[i + 2] == 1)) {
                    this.write(3);
                } else if ((b[i] == 0) && (b[i + 1] == 1) && (b[i + 2] == 0)) {
                    this.write(4);
                } else if ((b[i] == 0) && (b[i + 1] == 1) && (b[i + 2] == 1)) {
                    this.write(5);
                } else if ((b[i] == 1) && (b[i + 1] == 0) && (b[i + 2] == 0)) {
                    this.write(6);
                } else if ((b[i] == 1) && (b[i + 1] == 0) && (b[i + 2] == 1)) {
                    this.write(7);
                } else if ((b[i] == 1) && (b[i + 1] == 1) && (b[i + 2] == 0)) {
                    this.write(8);
                } else {
                    this.write(9);
                }
            }
        }
        int i = b.length % 3;
        for (int j = b.length - i; j < b.length; j++) {
            this.write(b[j]);
        }
    }
/*
    private OutputStream out;


    public MyCompressorOutputStream(OutputStream OS){
        out=OS;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    public void write(byte[]b) throws IOException {
        int cur = 0;
        int counter = 0;
        for(int i = 0; i<b.length; i++) {
            if (i < 24) {
                this.write(b[i] & 0xFF);
            }
            else {
                if (b[i] == cur) {
                    if (counter == 255) {
                        //out.write(b[i]);
                        this.write(counter);
                        // out.write(counter);
                        this.write(0);
                        counter = 0;
                    }
                    counter++;
                } else {
                    //out.write(b[i]);
                    //  out.write(counter);
                    this.write(counter);
                    cur = b[i];
                    counter = 1;
                }
            }
        }
        this.write(counter);
    }
 */
}
