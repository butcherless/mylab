package com.mylab.learn.myarchetype.domain;

import java.util.List;

import org.junit.Assert;
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
import com.openpojo.validation.test.impl.SetterTester;

public class DomainTest {

	private PojoValidator pojoValidator;
	private List<PojoClass> pojoClasses;

	private Class[] exclusionArray = { DomainTest.class, DomainFactory.class };

	@Before
	public void setup() {
		pojoValidator = new PojoValidator();
		FilterNonConcrete filterNonConcrete = new FilterNonConcrete();
		FilterNestedClasses filterNestedClasses = new FilterNestedClasses();
		ExclusionListFilter exclusionListFilter = new ExclusionListFilter(exclusionArray);

		FilterChain filterChain = new FilterChain(filterNonConcrete, filterNestedClasses, exclusionListFilter);
		pojoClasses = PojoClassFactory.getPojoClasses(this.getClass().getPackage().getName(), filterChain);

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
		TemplateEntity template = new TemplateEntity();
		Assert.assertNotNull("templateEntity", template.toString());

		SimpleText simpleText = new SimpleText();
		Assert.assertNotNull("simpleText", simpleText.toString());

		Translation translation = new Translation();
		Assert.assertNotNull("translation", translation.toString());
	}

	@Test
	public void testDomainFactory() {
		DomainFactory.newTemplateEntity("name");
		new DomainFactory();
	}
}
