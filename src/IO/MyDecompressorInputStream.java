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
           // byte b= (byte)in.read();
            //return b &0xFF;
      //  return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
       /* byte [] byteArray= new byte[b.length];
        int counter=0;
       // return super.read(b);
        //  return 0;
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i];j++){
                if(i%2==0) {
                    byteArray[counter] = 0;
                    counter++;
                }
                else{
                    byteArray[counter] = 1;
                }
            }
        }
*/

        return this.in.read(b);
    }
}
