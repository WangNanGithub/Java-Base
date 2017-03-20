package com.devil.pro.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Before;
import org.junit.Test;

public class XmlTest {
    Document document;
    
    @Before
    public void beforeTest() throws DocumentException {
        SAXReader reader = new SAXReader();
        document = reader.read(new File("src/main/java/com/devil/pro/xml/book.xml"));
    }
    
    // 读取book.xml
    @Test
    public void read(){
        Element root = document.getRootElement();
        Iterator<?> it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            // 未知属性名称情况下
            /*Iterator attrIt = element.attributeIterator();
            while (attrIt.hasNext()) {
            Attribute a  = (Attribute) attrIt.next();
            System.out.println(a.getValue());
            }*/
            // 已知属性名称情况下
            System.out.println("id: " + element.attributeValue("id"));
            // 未知元素名情况下
            /*Iterator eleIt = element.elementIterator();
            while (eleIt.hasNext()) {
            Element e = (Element) eleIt.next();
            System.out.println(e.getName() + ": " + e.getText());
            }*/
            // 已知元素名情况下
            System.out.println("title: " + element.elementText("title"));
            System.out.println("author: " + element.elementText("author"));
            System.out.println();
        }
    }
    
    // 解析XML形式的文本,得到document对象
    @Test
    public void stringXml() throws DocumentException{
        String text = "<user><name>devil</name><age>123</age></user>";
        Document document2 = DocumentHelper.parseText(text);
        System.out.println(document2.asXML()); 
    }
    
    @Test
    public void write() throws Exception {
        Document doc = DocumentHelper.createDocument();
        // 增加根节点
        Element books = doc.addElement("books");
        // 增加子元素
        Element book1 = books.addElement("book");
        Element title1 = book1.addElement("title");
        Element author1 = book1.addElement("author");
        // 增加子元素
        Element book2 = books.addElement("book");
        Element title2 = book2.addElement("title");
        Element author2 = book2.addElement("author");
        // 为子节点添加属性
        book1.addAttribute("id", "001");
        // 为元素1添加内容
        title1.setText("Harry Potter");
        author1.setText("J K. Rowling");
        book2.addAttribute("id", "002");
        title2.setText("Learning XML");
        author2.setText("Erik T. Ray");
        // 实例化输出格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置输出编码
        format.setEncoding("UTF-8");
        // 创建需要写入的File对象
        File file = new File("D:" + File.separator + "books.xml");
        // 生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        // 开始写入，write方法中包含上面创建的Document对象
        writer.write(doc);
        System.out.println("success!"); 
    }
}
