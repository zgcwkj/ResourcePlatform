package com.zgcwkj.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 生成验证码
 * 
 * @author zgcwkj
 * @since 2018-11-15
 */
public class ValidateCode {
    private String validateCode = "";
    private String validateColor = "FFFFFF";

    /**
     * 实例验证码
     */
    public ValidateCode() {
        validateCode = new RandomCode(true, true, false).getRandom(4);
    }

    /**
     * 实例验证码
     */
    public ValidateCode(int length) {
        validateCode = new RandomCode(true, true, false).getRandom(length);
    }

    /**
     * 获取验证码
     */
    public String GetValidate() {
        return validateCode;
    }

    /**
     * 背景颜色 不传参数时为随机
     */
    public void GetColor() {
        validateColor = new RandomCode(true, false, false).getRandom(6);
    }

    /**
     * 背景颜色 不传参数时为随机
     */
    public void GetColor(String color) {
        validateColor = color;
    }

    /**
     * 获取生成的图片
     * 
     * @param RandomText 随机码
     * @return
     */
    public BufferedImage getImage() {
        // 创建缓存
        BufferedImage bi = new BufferedImage(validateCode.length() * 20, 35, BufferedImage.TYPE_INT_RGB);
        // 获得画布
        Graphics g = bi.getGraphics();
        // 设置颜色
        g.setColor(new Color(Integer.parseInt(validateColor, 16)));
        // 填充区域
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        // 设置颜色
        g.setColor(Color.lightGray);
        // 画图片的背景噪音线
        for (int i = 0; i < 12; i++) {
            int x1 = new Random().nextInt(bi.getWidth());
            int y1 = new Random().nextInt(bi.getHeight());
            int x2 = new Random().nextInt(bi.getWidth());
            int y2 = new Random().nextInt(bi.getHeight());
            g.drawLine(x1, y1, x2, y2);
        }

        Graphics2D g2d = (Graphics2D) g;// 转换为Graphics2D类型
        Font font = new Font("Georgia", Font.BOLD, 25); // 创建字体对象
        g2d.setFont(font); // 设置字体
        // 创建循环渐变的GraphientPaint对象
        GradientPaint paint = new GradientPaint(0, 0, Color.BLUE, bi.getWidth(), bi.getHeight(), Color.GRAY, true);
        g2d.setPaint(paint);// 设置渐变
        g2d.drawString(validateCode, 5, (bi.getHeight() + 10) / 2); // 绘制文本

        // 设置颜色
        g.setColor(Color.WHITE);
        // 画图片的前景噪音点
        for (int i = 0; i < 10; i++) {
            int x1 = new Random().nextInt(bi.getWidth());
            int y1 = new Random().nextInt(bi.getHeight());
            int x2 = new Random().nextInt(bi.getWidth());
            int y2 = new Random().nextInt(bi.getHeight());
            g.drawLine(x1, y1, x2, y2);
        }
        return bi;
    }
}