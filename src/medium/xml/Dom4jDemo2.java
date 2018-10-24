package medium.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by xjlin on 2018/10/22.
 */
public class Dom4jDemo2{
    private static final String PATH = "d:\\project_study\\Java_study\\properties\\xmlstudy\\book.xml";
//    public static void main(String[] args) throws Exception{
////        find();
//    }
    @Test
    public void attr() throws Exception {
        SAXReader reader = new SAXReader();
        Document dom = reader.read(PATH);
        Element root = dom.getRootElement();

        Element bookEle = root.element("书");

        //添加属性

        bookEle.addAttribute("出版社", "黑马出版社");

        //获取属性
        System.out.println(bookEle.attributeValue("出版社"));


        //删除属性
        Attribute attr = bookEle.attribute("出版社");
        bookEle.remove(attr);


        XMLWriter writer = new XMLWriter(new FileOutputStream(PATH), OutputFormat.createPrettyPrint());
        writer.write(dom);
        writer.close();
    }

    @Test
    public void del() throws Exception {
        SAXReader reader = new SAXReader();
        Document dom = reader.read(PATH);
        Element root = dom.getRootElement();

        //找到爸爸
        Element price2Ele = root.element("书").element("特价");
        price2Ele.getParent().remove(price2Ele);

        XMLWriter writer = new XMLWriter(new FileOutputStream(PATH), OutputFormat.createPrettyPrint());
        writer.write(dom);
        writer.close();
    }


    @Test
    public void update() throws Exception {
        SAXReader reader = new SAXReader();
        Document dom = reader.read(PATH);
        Element root = dom.getRootElement();

        //有多个则拿第一个
        root.element("书").element("特价").setText("29.0元");
        XMLWriter writer = new XMLWriter(new FileOutputStream(PATH), OutputFormat.createPrettyPrint());
        writer.write(dom);
        writer.close();
    }

    @Test
    public void find() throws Exception {
        SAXReader reader = new SAXReader();
        Document dom = reader.read(PATH);
        Element root = dom.getRootElement();

        List<Element> list = root.elements();
        Element book2Ele = list.get(1);

        System.out.println(book2Ele.element("书名").getText());
//        System.out.println(root);
    }

    /**
     * 比较原始的插入dom
     * @throws Exception
     */
    @Test
    public void add_old() throws Exception {
        SAXReader reader = new SAXReader();
        Document dom = reader.read(PATH);

        //凭空创建<特价>节点， 设置标签体
        Element price2Ele = DocumentHelper.createElement("特价");
        price2Ele.setText("38.0元");
        //获取父标签<书>
        Element root = dom.getRootElement();
        Element bookEle = root.element("书");//第一个
        bookEle.add(price2Ele);

        //将内存中得dom树， 写回源xml文件
        FileWriter writer = new FileWriter(PATH);
        dom.write(writer);
        writer.flush();
        writer.close();
    }

    /**
     * 封装好的插入dom， 可以格式化
     * @throws Exception
     */
    @Test
    public void add_new() throws Exception {
        SAXReader reader = new SAXReader();
        Document dom = reader.read(PATH);

        //凭空创建<特价>节点， 设置标签体
        Element price2Ele = DocumentHelper.createElement("特价");
        price2Ele.setText("38.0元");
        //获取父标签<书>
        Element root = dom.getRootElement();
        Element bookEle = root.element("书");//第一个
        bookEle.add(price2Ele);

        //将内存中得dom树， 写回源xml文件(新版本， 加上prettyPrinter)
        XMLWriter writer = new XMLWriter(new FileOutputStream(PATH), OutputFormat.createPrettyPrint());
        writer.write(dom);
        writer.close();
    }
}
