package com.pang.prototype.tutorial;

import java.util.HashMap;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ShapeCache
 * @Package com.pang.prototype
 * @description:
 * @date 2019/10/7 11:51
 */
public class ShapeCache {

    private static HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cacheShape = shapeMap.get(shapeId);
        return (Shape) cacheShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);
        Triangle rectangle = new Triangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(), rectangle);
        Square square = new Square();
        square.setId("3");
        shapeMap.put(square.getId(), square);
    }
}
