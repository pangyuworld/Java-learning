package com.pang.factory.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ShapeFactory
 * @Package com.pang.factory.tutorial
 * @description:
 * @date 2019/10/7 12:34
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if ("circle".equalsIgnoreCase(shapeType)) {
            return new Circle();
        }
        if ("square".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        if ("Rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }
        return null;
    }
}
