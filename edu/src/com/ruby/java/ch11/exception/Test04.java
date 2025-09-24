package com.ruby.java.ch11.exception;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test04 {
	public static void main(String[] args) {
		byte[] arr = null;
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			arr = out.toByteArray();
			String s = new String(arr);
			System.out.println(s);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("b.txt"))) {
			bo.write(arr);
		}	catch(Exception e) {
			e.printStackTrace();
		}
	}
}