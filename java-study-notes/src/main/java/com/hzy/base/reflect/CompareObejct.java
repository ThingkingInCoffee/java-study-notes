package com.hzy.base.reflect;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
/**
 * 对比两个对象的差值
 * Created by Administrator on 2018/7/9.
 */
public class CompareObejct<T> {
 
    private T original;   
 
    private T current;

    public static void main(String[] args) {

    }

    /**
     * * 记录修改数据的日志
     * * @Param
     * * Class<T> c 修改对应的实体类
     * * T old 修改前的数据
     * * T update 修改的值（通过JSON转换为bean）
     * * @rerturn 返回经过更新后的数据
     */
    public <T> T saveUpdateLog(Class<T> c, T old, T update) {
        try {
//            TUpdateLog updateLog = new TUpdateLog();
            CompareObejct<T> compareObejct = new CompareObejct<T>();
            compareObejct.setOriginal(old);
            compareObejct.setCurrent(update);
            String updateContrast = compareObejct.contrastObj(c);
            if (!"".equals(updateContrast) && updateContrast != null) {
//                updateLog.setUpdateContrast(updateContrast);
                //通过注解获取tableName
//                Table annotation = c.getAnnotation(Table.class);
//                String tableName = annotation.name();
//                updateLog.setTableName(tableName);
//                updateLog.setBeforeUpdateEntity(JSON.toJSONString(old));
//                JiuyiUtil.copyProperties(old, update, false, true);
//                updateLog.setAfterUpdateEntity(JSON.toJSONString(update));
//                updateLogDao.save(updateLog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }


    /**
     *
     * @param cls
     * @return
     */
    public String contrastObj(Class<T> cls){
        StringBuilder sb = new StringBuilder();
        try{
            Field[] fields = cls.getDeclaredFields();
            for(Field field: fields){
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(),cls);
                Method getMethod = pd.getReadMethod();
                String type = field.getType().getName();
                if(!"java.util.Set".equals(type)){
                    Object o1 = getMethod.invoke(this.original);
                    Object o2 = getMethod.invoke(this.current);
                    if(null != o2){
                        String s1 = o1 == null ? "" :o1.toString();
                        String s2 = o2 == null ? "" :o2.toString();
                        if(!s1.equals(s2)){
                            //System.out.println("不一样的属性：" + field.getName() + " 属性值：[" + s1 + "," + s2 + "]");
                            sb.append(field.getName() + ":" + "[" + s1 + "," + s2 + "];");
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 复制对象属性（对象类型必须相同）
     *
     * @param orig 资源对象
     * @param dest 目标对象
     * @param clazz 源对象类
     * @param ignoreNull 是否忽略空（true:忽略，false：不忽略）
     * @param ignoreExist  是否只复制dest值为空的数据  true 是，false 否
     * @return
     */
    public static <T> T copyProperties(T orig, T dest, Class<?> clazz, boolean ignoreNull,boolean ignoreExist) {
        if (orig == null || dest == null)
            return null;
        if(!clazz.isAssignableFrom(orig.getClass()))
            return null;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(orig);
                Object value2 = field.get(dest);
                System.out.println(field + "----" + value2);
                if(!java.lang.reflect.Modifier.isFinal(field.getModifiers())){
                    if(!(ignoreNull && value == null)){
                        if(ignoreExist && value2 != null){

                        }else{
                            field.set(dest, value);
                        }

                    }

                }
                field.setAccessible(false);
            } catch (Exception e) {
            }
        }

        if(clazz.getSuperclass() == Object.class){
            return dest;
        }

        return copyProperties(orig, dest, clazz.getSuperclass(), ignoreNull,ignoreExist);
    }

 
 
    public T getOriginal() {
        return original;
    }
 
    public void setOriginal(T original) {
        this.original = original;
    }
 
    public T getCurrent() {
        return current;
    }
 
    public void setCurrent(T current) {
        this.current = current;
    }
}