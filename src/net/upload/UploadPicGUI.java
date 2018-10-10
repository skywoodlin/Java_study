package net.upload;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class UploadPicGUI extends javax.swing.JFrame {
    private JTextField jTextField1;
    private JButton jButton1;
    private JButton jButton2;
    private JTextArea jTextArea1;
    private File uploadFile;

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UploadPicGUI inst = new UploadPicGUI();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public UploadPicGUI() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);
            {
                jTextField1 = new JTextField();
                getContentPane().add(jTextField1);
                jTextField1.setBounds(12, 32, 382, 42);
            }
            {
                jButton1 = new JButton();
                getContentPane().add(jButton1);
                jButton1.setText("\u6d4f\u89c8...");
                jButton1.setBounds(400, 32, 99, 42);
                jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });
            }
            {
                jTextArea1 = new JTextArea();
                getContentPane().add(jTextArea1);
                jTextArea1.setBounds(12, 93, 382, 156);
            }
            {
                jButton2 = new JButton();
                getContentPane().add(jButton2);
                jButton2.setText("\u4e0a\u4f20\u56fe\u7247");
                jButton2.setBounds(400, 93, 99, 156);
                jButton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jButton2ActionPerformed(evt);
                    }
                });
            }
            pack();
            this.setSize(525, 295);
        } catch (Exception e) {
            //add your error handling code here
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG Images", "jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {


            uploadFile = chooser.getSelectedFile();
            if(uploadFile.length()>1024*1024*3){
                jTextField1.setText("文件过大，重新选择");
                return;
            }
            jTextField1.setText(uploadFile.getAbsolutePath());




        }


    }

    private void uploadFile(File uploadFile) {

        try {
            Socket s = new Socket("192.168.1.253",10006);

            FileInputStream fis = new FileInputStream(uploadFile);

            OutputStream out = s.getOutputStream();

            byte[] buf = new byte[1024];

            int len = 0;
            while((len=fis.read(buf))!=-1){
                out.write(buf,0,len);
            }
            //告诉服务端写完了。
            s.shutdownOutput();

            //读取服务端数据。
            InputStream in = s.getInputStream();
            byte[] bufIn = new byte[1024];
            int lenIn = in.read(bufIn);
            String str = new String(bufIn,0,lenIn);
//			System.out.println(str);
            jTextArea1.setText(str);


            fis.close();
            s.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }





    }

    private void jButton2ActionPerformed(ActionEvent evt) {

        if(uploadFile!=null)
            uploadFile(uploadFile);
        else
            jTextArea1.setText("没有选择文件");

    }

}
