package com.mylab.learn.myarchetype.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterClassName;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPrimitivesRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class DomainTest {

	private PojoValidator pojoValidator;
	private List<PojoClass> pojoClasses;

	private Class[] classArray = { SimpleText.class, Translation.class,
			TemplateEntity.class, Aircraft.class, Destination.class };

	@Before
	public void setup() {
		pojoValidator = new PojoValidator();
		FilterClassName filterClassName = new FilterClassName(this.buildRegex());
		pojoClasses = PojoClassFactory.getPojoClasses(this.getClass()
				.getPackage().getName(), filterClassName);

		// Create Rules to validate structure for POJO_PACKAGE
		pojoValidator.addRule(new NoPublicFieldsRule());
		pojoValidator.addRule(new NoPrimitivesRule());
		pojoValidator.addRule(new NoStaticExceptFinalRule());
		pojoValidator.addRule(new GetterMustExistRule());
		pojoValidator.addRule(new NoNestedClassRule());

		// Create Testers to validate behaviour for POJO_PACKAGE
		pojoValidator.addTester(new SetterTester());
		pojoValidator.addTester(new GetterTester());
	}

	@Test
	public void ensureExpectedPojoCount() {
		Affirm.affirmEquals("Classes added / removed?", this.classArray.length,
				pojoClasses.size());
	}

	@Test
	public void testPojoStructureAndBehavior() {
		for (PojoClass pojoClass : pojoClasses) {
			pojoValidator.runValidation(pojoClass);
		}
	}

	/*
	 * H E L P E R S
	 */

	private String buildRegex() {
		List<String> classList = new ArrayList<String>();
		for (Class clazz : this.classArray) {
			classList.add(clazz.getSimpleName() + '$');
		}

		// or expression
		return StringUtils.join(classList, '|');
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
