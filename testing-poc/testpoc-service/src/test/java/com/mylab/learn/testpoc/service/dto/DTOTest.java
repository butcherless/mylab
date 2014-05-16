package com.mylab.learn.testpoc.service.dto;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mylab.learn.myarchetype.test.ExclusionListFilter;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterNestedClasses;
import com.openpojo.reflection.filters.FilterNonConcrete;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPrimitivesRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.utils.ValidationHelper;

public class DTOTest {
    private PojoValidator pojoValidator;
    private List<PojoClass> pojoClasses;

    private Class[] exclusionArray = { DTOTest.class };

    @Before
    public void setup() {
        pojoValidator = new PojoValidator();
        FilterNonConcrete filterNonConcrete = new FilterNonConcrete();
        FilterNestedClasses filterNestedClasses = new FilterNestedClasses();
        ExclusionListFilter exclusionListFilter = new ExclusionListFilter(exclusionArray);

        FilterChain filterChain =
                new FilterChain(filterNonConcrete, filterNestedClasses, exclusionListFilter);
        pojoClasses = PojoClassFactory.getPojoClasses(
                this.getClass().getPackage().getName(), filterChain);

        // Create Rules to validate structure for POJO_PACKAGE
        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoPrimitivesRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());

        // Create Testers to validate behaviour for POJO_PACKAGE
        pojoValidator.addTester(new GetterTester());
    }

    @Test
    public void testPojoStructureAndBehavior() {
        for (PojoClass pojoClass : pojoClasses) {
            pojoValidator.runValidation(pojoClass);
        }
    }

    @Test
    public void testToString() {
        for (PojoClass pojoClass : pojoClasses) {
            ValidationHelper.getBasicInstance(pojoClass).toString();
            ValidationHelper.getMostCompleteInstance(pojoClass).toString();
        }
    }
}
