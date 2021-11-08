package mine.practice.springdemo.annotation;

import mine.practice.springdemo.dataSource.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author : whc
 * @version : 1.0
 * 使用注释更加方便地切换数据源
 */

@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DS {

    String value() default DataSourceConstants.DS_MASTER;
}
