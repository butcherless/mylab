package com.mylab.learn.myarchetype.test;

import org.junit.Assert;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;

public class ExclusionListFilterTest {

    @Test
    public void testExclusionListFilter() {
        Class[] classes = { Integer.class };
        ExclusionListFilter filter = new ExclusionListFilter(classes);

        PojoClass pojoClass = PojoClassFactory.getPojoClass(Long.class);
        Assert.assertTrue(filter.include(pojoClass));

        pojoClass = PojoClassFactory.getPojoClass(Integer.class);
        Assert.assertFalse(filter.include(pojoClass));
    }
}
