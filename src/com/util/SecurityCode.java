package com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class SecurityCode {
	 public static final int WIDTH = 100;
	 public static final int HEIGHT = 25;
	 public static String checkstring ;
	 
	 //得到验证码的BtyArrayInputStream流
	 public static ByteArrayInputStream getImageAsInputStream() 
	 {
	  BufferedImage image = getRandomImage();
	  return convertImageToStream(image);
	 }
	 
	 //得到验证码图片
	 public static BufferedImage getRandomImage() {
	  BufferedImage randomImage = new BufferedImage(WIDTH, HEIGHT,
	    BufferedImage.TYPE_INT_RGB);
	  Graphics g = randomImage.getGraphics();
	  setBackground(g);
	  setBorder(g);
	  paintLine(g);
	  checkstring = setRandomString((Graphics2D) g);
	  
	  g.dispose();
	  return randomImage;
	 }
	 //设置边框
	 private static void setBorder(Graphics g) {
	  g.setColor(Color.WHITE);
	  g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	 }
	 //随机数
	 private static String setRandomString(Graphics2D g) {
	  StringBuilder sb = new StringBuilder();
	  g.setFont(new Font("宋体", Font.BOLD, 22));
	  String randomString = "abcdefghijkmnpqrstuvwsyz23456789";
	  for (int i = 0; i < 4; i++) {
	   g.setColor(Color.red);
	   int x = 20 * i + 10;
	   String str = randomString.charAt(new Random().nextInt(randomString
	     .length())) + "";
	   sb.append(str);
	   int roll = new Random().nextInt() % 30;
	   g.rotate(roll * Math.PI / 180, x, 20);
	   g.drawString(str, x, 20);
	   g.rotate(-roll * Math.PI / 180, x, 20);
	  }
	  return sb.toString();
	 }
	 //画干扰线
	 private static void paintLine(Graphics g) {
	  g.setColor(Color.GREEN);
	  for (int i = 0; i < 5; i++) {
	   int x1 = new Random().nextInt(WIDTH);
	   int y1 = new Random().nextInt(HEIGHT);
	   int x2 = new Random().nextInt(WIDTH);
	   int y2 = new Random().nextInt(HEIGHT);
	   g.drawLine(x1, y1, x2, y2);
	  }
	 }
	 //设置背景颜色
	 private static void setBackground(Graphics g) {
	  // TODO Auto-generated method stub
	  g.setColor(Color.WHITE);
	  g.fillRect(0, 0, WIDTH, HEIGHT);
	 }
	 
	 //将image验证码转化成字节数组输入流
	 private static ByteArrayInputStream convertImageToStream(BufferedImage image) {
	  ByteArrayInputStream inputStream = null;
	  ByteArrayOutputStream bos = new ByteArrayOutputStream();
	  JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
	  try {
	   jpeg.encode(image);
	   byte[] bts = bos.toByteArray();
	   inputStream = new ByteArrayInputStream(bts);
	  } catch (ImageFormatException e) {
	   e.printStackTrace();
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	  return inputStream;
	 }
	}
