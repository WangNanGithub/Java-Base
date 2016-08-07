package com.devil.pro.xml;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

public class TestXml4 {
	public static void main(String[] args) throws Exception {
		// DOM4j中，获得Document对象的方式有三种：
		// 1.读取XML文件,获得document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/main/java/com/ys/pro/xml/book.xml"));
		System.out.println(document.asXML());
		// 2.解析XML形式的文本,得到document对象.
		String text = "<csdn></csdn>";
		Document document2 = DocumentHelper.parseText(text);
	}
}
