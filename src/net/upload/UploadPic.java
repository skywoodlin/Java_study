package net.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadPic implements Runnable {

    private Socket s;

    public UploadPic(Socket s) {
        super();
        this.s = s;
    }

    @Override
    public void run() {

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "......connected");

        File file = getFile("e:\\server_pic", ip);

        InputStream in;
        try {
            in = s.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

            // 回馈客户端数据。
            OutputStream out = s.getOutputStream();
            out.write("上传图片成功".getBytes());

            fos.close();
            s.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static File getFile(String dir, String ip) {
        File pic_dir = new File(dir);
        if (!pic_dir.exists()) {
            pic_dir.mkdir();
        }

        int count = 1;
        File file = new File(pic_dir, ip + "(" + count + ").jpg");
        while (file.exists()) {
            count++;
            file = new File(pic_dir, ip + "(" + count + ").jpg");
        }
        return file;
    }

}
