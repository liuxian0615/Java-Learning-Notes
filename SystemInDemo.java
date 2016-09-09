package ioDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemInDemo {

	public static void main(String[] args) throws IOException {
		
//		input_key_1();
		
		input_key_2();		
	}

	private static void input_key_2() throws IOException {
		// 把字节流转换成字符流，再进行键盘录入
		InputStream in = System.in;
		
		InputStreamReader isr = new InputStreamReader(in);
		
		BufferedReader bufr = new BufferedReader(isr);
		
		String line = null;
		
		while((line = bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
//			System.out.println(line.toUpperCase());
			System.out.println(line);
		}
	}

	public static void input_key_1() throws IOException {
		// 字节流对象键盘录入
		InputStream in = System.in;
		
		StringBuilder sb = new StringBuilder();
		
		int ch = 0;
		
		while( (ch = in.read())!=-1 )
		{
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				String temp = sb.toString();
				if("over".equals(temp))
					break;
				System.out.println(temp.toUpperCase());
				sb.delete(0, sb.length());
			}
			else
				sb.append((char)ch);
		}
	}

}
