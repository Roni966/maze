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
       System.out.println(b);
    }
/*
    public void write(byte[]b) throws IOException {
      int cur= b[24];
      int counter=1;

      for(int i=25;i<b.length;i++){
            if(b[i]==cur){

                if(counter==255){
                    //out.write(b[i]);
                    this.write(counter);
                   // out.write(counter);
                    if(b[i]==0){
                      //  out.write(1);
                        this.write(counter);
                        //out.write(0);
                    }
                    else{
                        //out.write(0);
                        this.write(counter);
                      //  out.write(0);
                    }

                    counter=0;
                }
                counter++;
            }
            else{
                //out.write(b[i]);
              //  out.write(counter);
                this.write(counter);


                cur=b[i];
                counter=1;
            }
      }
    }*/
}
