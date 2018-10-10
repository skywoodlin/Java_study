package basic.io.homework2;


import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader{

    //1，持有一个流对象。
    private Reader r;

    //2,因为是缓冲区对象，所以内部必须维护了数组。
    private char[] buffer = new char[1024];

    //3,定义角标。
    private int index = 0;

    //4，定义变量，记录住数组中元素的个数。
    private int count = 0;


    //5，一初始化就必须明确被缓冲的对象。
    public MyBufferedReader(Reader r){
        super();
        this.r = r;
    }


    /**
     * 读取一个字符的方法，而且是高效的。
     *
     * @throws IOException
     */

    public int myRead() throws IOException{
        if(count == 0){
            //通过被缓冲流对象的read方法，就可以将设备上的数据存储到数组中。
            count = r.read(buffer);
            index = 0;
        }

        if(count < 0)
            return -1;

        char ch = buffer[index];
        index++;//角标每取一次都要自增。
        count--;//既然取出一个，数组的数量要减少，一旦减到0，就在从设备上获取一批数据存储到数组中。

        return ch;

    }

    /**
     * 读取一行文本。
     *
     * @throws IOException
     */
    public String myReadLine() throws IOException{
        //1,定义临时缓冲区，用于存储一行文本。
        StringBuilder sb = new StringBuilder();

        //1,不断的调用myRead方法冲缓冲区中取出数据。
        int ch = 0;
        while((ch = myRead()) != -1){

            //在存储前要判断行终止符 。
            if(ch == '\r')
                continue;
            if(ch == '\n')
                return sb.toString();
            //对独到的字符进行临时存储。
            sb.append((char) ch);
        }

        //如果文本结尾处有数据，但没有行结束符。
        //数据已被读到，并存储到StringBuilder中。只要判断StringBuilder的长度即可。
        if(sb.length() != 0)
            return sb.toString();

        return null;

    }

    /**
     * 定义一个缓冲区的关闭方法。
     *
     * @throws IOException
     */
    public void myClose() throws IOException{
        //其实就是在关闭被缓冲区的流对象。
        r.close();
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException{

        return 0;
    }


    @Override
    public void close() throws IOException{
    }
}
