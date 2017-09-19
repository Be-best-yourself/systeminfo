package com.zfw.test;

import java.io.File;
public class FileTest implements Runnable{
	static int i=0;//线程数据共享
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			new Thread(new FileTest()).start();
			System.err.println(i);
		}
	}
	public static void test1(File file) {
		if (file.isDirectory()) {
			System.out.println(file.getName());
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				test1(file2);
				i++;
			}
		}else {
			System.out.println(file.getPath()+File.separator+file.getName());
		}
	}
	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		File file=new File("D:/迅雷下载");
		test1(file);
		long end= System.currentTimeMillis();
		System.out.println("time:"+(end-begin)/1000+"s");
		System.out.println(i);
	}
}
