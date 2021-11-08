package mine.practice.springdemo.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author : whc
 * @version : 1.0
 * 动态数据源更换类
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 需要实现该方法 决定路由策略
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }
}
