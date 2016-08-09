package ru.sbt.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Артем on 09.08.2016.
 */
public class BeanUtils {
    public static void assign(Object to, Object from) {
        Class<?> toClass = to.getClass();
        Class<?> fromClass = from.getClass();

        Set<Method> toMethodSet = new HashSet<>();  //creating set of setters
        for (Method method : toClass.getMethods()) {
            if (method.getName().startsWith("set") &&
                    method.getName().charAt(3) < 91 &&
                    method.getName().charAt(3) > 64 &&
                    method.getReturnType() == void.class &&
                    method.getParameterCount() == 1) {
                toMethodSet.add(method);
            }
        }

        Set<String> fromMethodNamesSet = new HashSet<>();    //creating set of getters
        for (Method method : fromClass.getMethods()){
            if(method.getName().startsWith("get") &&
                    method.getName().charAt(3) < 91 &&
                    method.getName().charAt(3) > 64 &&
                    method.getReturnType() != void.class &&
                    method.getParameterCount() == 0) {
                fromMethodNamesSet.add(method.getName());
            }
        }

        for(Method method : toMethodSet){
            String potentialGetter = "get" + method.getName().substring(3);
            try{
                if(fromMethodNamesSet.contains(potentialGetter)){

                    method.invoke(to, fromClass.getMethod(potentialGetter).invoke(from));
                }
            }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e){
            }
        }
    }


}
