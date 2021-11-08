package mine.practice.springdemo.dataSource;

/**
 * @author : whc
 * @version : 1.0
 * 动态数据源上下文处理类
 */
public class DynamicDataSourceContextHolder {

    /**
     * 放置数据源的线程池
     */
    private static final ThreadLocal<String> DATASOURCE_CONTEXT_KEY_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源方法
     * @param key 数据源名称
     */
    public static void setContextKey(String key) {
        DATASOURCE_CONTEXT_KEY_HOLDER.set(key);
    }

    /**
     * 获取当前数据源名称方法
     * 如果没有设定的数据源 就获取master数据源
     * 否则使用设定的数据源
     * @return
     */
    public static String getContextKey() {
        String key = DATASOURCE_CONTEXT_KEY_HOLDER.get();
        return key == null?DataSourceConstants.DS_MASTER:key;
    }

    /**
     * 移除当前数据源方法 该方法需要在每次查询完成之后调用
     */
    public static void removeContextKey() {
        DATASOURCE_CONTEXT_KEY_HOLDER.remove();
    }
}
