package com.itcrazy.alanmall.common.client.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * 验证码生成图片
 *
 */
public class LoginImageValidCode {

	public static int LINE_CNT = 4;// 随机背景中线条数量

	public static int IMG_WIDTH = 60;// 随机数背景宽度

	public static int IMG_HEIGHT = 20;// 随机数背景高度

	private LoginImageValidCode() {
	}

	/**
	 * 随机出现颜色
	 */
	public static Color getColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * 得到图片流
	 */
	public static ByteArrayInputStream getRandomImgInputStream(String randomStr) {
		// 在内存中创建图象
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getColor(200, 250));
		g.fillRect(0, 0, IMG_WIDTH, IMG_WIDTH);
		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getColor(160, 200));
		for (int i = 0; i < LINE_CNT; i++) {
			int x = random.nextInt(IMG_WIDTH);
			int y = random.nextInt(IMG_WIDTH);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(6位数字)
		for (int i = 0; i < randomStr.length(); i++) {
			char rand = randomStr.charAt(i);
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// 直接生成
			g.drawString(String.valueOf(rand), 13 * i + 6, 16);
		}

		// 图象生效
		g.dispose();
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageOutputStream imageOut = ImageIO
					.createImageOutputStream(output);
			ImageIO.write(image, "JPEG", imageOut);
			imageOut.close();
			input = new ByteArrayInputStream(output.toByteArray());
		} catch (Exception e) {
			System.out.println("验证码图片产生出现错误：" + e.toString());
			return null;
		}

		return input;
	}

}
