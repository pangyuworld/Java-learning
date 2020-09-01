package com.ioc;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BeanInfoDemo
 * @Package com.ioc
 * @description: {@link java.beans.BeanInfo} 实例
 * @date 2019/12/27 21:39
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    // PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    Class<?> properType= propertyDescriptor.getPropertyType();
                    if ("age".equals(properType)){
                        // 为“age"字段添加ProperEditor
                        // String -> Integer
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        // propertyDescriptor.createPropertyEditor()
                    }
                });

    }
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value=Integer.valueOf(text);
            setValue(value);
        }
    }
}
