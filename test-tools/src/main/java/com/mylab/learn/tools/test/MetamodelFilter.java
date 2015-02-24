package com.mylab.learn.tools.test;

import java.util.ArrayList;
import java.util.List;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

/**
 * Filter for Querydsl metamodel classes
 * 
 * @author cmartin
 *
 */
public class MetamodelFilter implements PojoClassFilter {
    private static final String METAMODEL_PREFIX = "Q";
    private static final Integer PREFIX_LENGTH = METAMODEL_PREFIX.length();

    private List<String> classNames = new ArrayList<String>();

    public MetamodelFilter(List<Class<?>> metamodelClasses) {
        for (Class<?> clazz : metamodelClasses) {
            this.classNames.add(clazz.getName());
        }
    }

    @Override
    public boolean include(PojoClass pojoClass) {
//        boolean result = false;
//        String className = pojoClass.getClazz().getSimpleName();
//        String classPackge = pojoClass.getClazz().getPackage().getName();
//
//        if (className.startsWith(METAMODEL_PREFIX)) {
//            // exclude class prefix
//            String canditateClass = new StringBuilder(classPackge).append('.')
//                    .append(className.substring(PREFIX_LENGTH)).toString();
//
//            result = !classNames.contains(canditateClass);
//        }
//
//        return result;
        
        return classNames.contains(pojoClass.getClazz().getName());
        
    }

}
