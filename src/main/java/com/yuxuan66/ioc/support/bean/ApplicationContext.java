package com.yuxuan66.ioc.support.bean;

import com.yuxuan66.ioc.support.annotation.Bean;
import com.yuxuan66.ioc.support.annotation.Inject;
import com.yuxuan66.ioc.support.common.ClassScanner;
import com.yuxuan66.ioc.support.common.StrUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Sir丶雨轩
 * @date 2020/5/18
 */
public class ApplicationContext implements BeanFactory {

    private final String packageName;

    private Map<String, Object> beans = new HashMap<String, Object>();

    private ApplicationContext(String packageName) {
        this.packageName = packageName;
    }

    private void refresh() {
        Set<Class<?>> classes = ClassScanner.getClasses(packageName);

        //初始化Bean
        classes.forEach(clazz -> {

            Bean bean = clazz.getAnnotation(Bean.class);

            if (bean != null) {

                String beanName = StrUtil.toLowerCaseFirstOne(clazz.getSimpleName());

                try {
                    beans.put(beanName, clazz.getConstructor().newInstance());
                } catch (RuntimeException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }

        });

        //注入Bean
        beans.forEach((beanName, bean) -> {

            //获取所有字段
            Field[] fields = bean.getClass().getDeclaredFields();

            for (Field field : fields) {
                Inject inject = field.getAnnotation(Inject.class);
                if (inject != null) {
                    String injectBeanName = inject.value();
                    if (injectBeanName.length() == 0) {
                        injectBeanName = field.getName();
                    }
                    Object _bean = beans.get(injectBeanName);
                    if (_bean == null) {
                        throw new RuntimeException("bean " + injectBeanName + " not found");
                    }
                    field.setAccessible(true);
                    try {
                        field.set(bean, _bean);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }


        });


    }

    public static ApplicationContext start(String packageName) {
        ApplicationContext applicationContext = new ApplicationContext(packageName);

        applicationContext.refresh();

        return applicationContext;
    }


    @Override
    public <T> T getBean(Class<T> type) {
        for (Map.Entry<String, Object> stringObjectEntry : beans.entrySet()) {
            if(stringObjectEntry.getValue().getClass().equals(type)){
                return (T) stringObjectEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return beans.get(beanName);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> clazz) {
        return (T) getBean(beanName);
    }

}
