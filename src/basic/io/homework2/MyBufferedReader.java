package basic.io.homework2;


import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader{

    //1������һ��������
    private Reader r;

    //2,��Ϊ�ǻ��������������ڲ�����ά�������顣
    private char[] buffer = new char[1024];

    //3,����Ǳꡣ
    private int index = 0;

    //4�������������¼ס������Ԫ�صĸ�����
    private int count = 0;


    //5��һ��ʼ���ͱ�����ȷ������Ķ���
    public MyBufferedReader(Reader r){
        super();
        this.r = r;
    }


    /**
     * ��ȡһ���ַ��ķ����������Ǹ�Ч�ġ�
     *
     * @throws IOException
     */

    public int myRead() throws IOException{
        if(count == 0){
            //ͨ���������������read�������Ϳ��Խ��豸�ϵ����ݴ洢�������С�
            count = r.read(buffer);
            index = 0;
        }

        if(count < 0)
            return -1;

        char ch = buffer[index];
        index++;//�Ǳ�ÿȡһ�ζ�Ҫ������
        count--;//��Ȼȡ��һ�������������Ҫ���٣�һ������0�����ڴ��豸�ϻ�ȡһ�����ݴ洢�������С�

        return ch;

    }

    /**
     * ��ȡһ���ı���
     *
     * @throws IOException
     */
    public String myReadLine() throws IOException{
        //1,������ʱ�����������ڴ洢һ���ı���
        StringBuilder sb = new StringBuilder();

        //1,���ϵĵ���myRead�����建������ȡ�����ݡ�
        int ch = 0;
        while((ch = myRead()) != -1){

            //�ڴ洢ǰҪ�ж�����ֹ�� ��
            if(ch == '\r')
                continue;
            if(ch == '\n')
                return sb.toString();
            //�Զ������ַ�������ʱ�洢��
            sb.append((char) ch);
        }

        //����ı���β�������ݣ���û���н�������
        //�����ѱ����������洢��StringBuilder�С�ֻҪ�ж�StringBuilder�ĳ��ȼ��ɡ�
        if(sb.length() != 0)
            return sb.toString();

        return null;

    }

    /**
     * ����һ���������Ĺرշ�����
     *
     * @throws IOException
     */
    public void myClose() throws IOException{
        //��ʵ�����ڹرձ���������������
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
