package cn.itcast.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;

/**
 * 完成插件签名：
 * 告诉mybatis当前插件用来拦截哪个对象的哪个方法
 */
@Intercepts({@Signature(type = StatementHandler.class,
        method = "parameterize",
        args = java.sql.Statement.class)})
public class MyFirstPlugin implements Interceptor {

    /**
     * intercept拦截
     * 拦截目标对象的目标方法的执行
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin......intercept：" + invocation.getMethod());
        // 动态的改变一下sql运行的参数：以前2号用户，实际从数据库查询3号用户
        System.out.println("当前拦截到的对象："+invocation.getTarget());
        // 拿到StatementHandler===>ParameterHandler===>parameterObject
        Object target = invocation.getTarget();
        // 拿到target的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句用的参数是："+value);
        metaObject.setValue("parameterHandler.parameterObject", 3);
        // 执行目标方法
        Object proceed = invocation.proceed();

        // 返回执行后的返回值
        return proceed;
    }

    /**
     * 包装目标对象的
     * 包装：为目标对象创建一个代理对象
     */
    @Override
    public Object plugin(Object o) {
        System.out.println("MyFirstPlugin......plugin:mybatis将要包装的对象" + o);
        // 我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们的目标对象
        Object wrap = Plugin.wrap(o, this);
        // 返回为当前target创建的动态代理
        return wrap;
    }

    /**
     * setProperties：
     * 将插件注册时property属性设置进来
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息：" + properties);
    }
}
