package com.mylab.learn.myairline.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mylab.learn.tools.test.MetamodelFilter;
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
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.ValidationHelper;

public class DomainTest {

    private PojoValidator pojoValidator;
    private List<PojoClass> pojoClasses;

    @SuppressWarnings("rawtypes")
    private List metamodelClasses = Arrays.asList(AbstractEntity.class, Airline.class,
            Aircraft.class, Location.class, Route.class, Trip.class);

    @Before
    public void setup() {
        pojoValidator = new PojoValidator();
        FilterNonConcrete filterNonConcrete = new FilterNonConcrete();
        FilterNestedClasses filterNestedClasses = new FilterNestedClasses();
        @SuppressWarnings("unchecked")
        MetamodelFilter metamodelFilter = new MetamodelFilter(metamodelClasses);

        FilterChain filterChain = new FilterChain(filterNonConcrete, filterNestedClasses,
                metamodelFilter);

        pojoClasses = PojoClassFactory.getPojoClasses(
                this.getClass().getPackage().getName(),
                filterChain
                );

        // Create Rules to validate structure for POJO_PACKAGE
        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoPrimitivesRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());

        // Create Testers to validate behaviour for POJO_PACKAGE
        pojoValidator.addTester(new GetterTester());
        pojoValidator.addTester(new SetterTester());
    }

    @Test
    public void testPojoStructureAndBehavior() {
        for (PojoClass pojoClass : pojoClasses) {
            pojoValidator.runValidation(pojoClass);
            ValidationHelper.getBasicInstance(pojoClass).toString();
            ValidationHelper.getMostCompleteInstance(pojoClass).toString();
//            System.out.println(pojoClass.getClazz().getName());
        }
    }

    // @Test
    // public void testToString() {
    // for (PojoClass pojoClass : pojoClasses) {
    // }
    // }

    // @Test
    // public void testDomainMethods() {
    // Company company = new Company();
    // Assert.assertFalse(company.hasAircrafts());
    // Aircraft aircraft = new Aircraft();
    // company.addAircraft(aircraft);
    // Assert.assertTrue(company.hasAircrafts());
    // Assert.assertTrue(company.aircraftCount() == 1);
    // company.removeAircraft(aircraft);
    // Assert.assertFalse(company.hasAircrafts());
    // Assert.assertTrue(company.aircraftCount() == 0);
    //
    // aircraft = new Aircraft();
    // Assert.assertFalse(aircraft.hasDestinations());
    // Destination destination = new Destination();
    // aircraft.addDestination(destination);
    // Assert.assertTrue(aircraft.hasDestinations());
    // Assert.assertTrue(aircraft.destinationCount() == 1);
    // aircraft.removeDestination(destination);
    // Assert.assertFalse(aircraft.hasDestinations());
    // Assert.assertTrue(aircraft.destinationCount() == 0);
    //
    // }

    @Test
    public void testAdditionalMethods() {
        Airline airline = new Airline();
        Long id = 1L;
        Integer version = 1;
        airline.setId(id);
        airline.setVersion(version);

        Assert.assertEquals("setId", id, airline.getId());
        Assert.assertEquals("setVersion", version, airline.getVersion());

    }

    // @Test
    // public void testDomainUtils() {
    // List<Aircraft> entities = new ArrayList<Aircraft>();
    // Assert.assertFalse(DomainUtils.hasUniqueResult(entities));
    //
    // entities.add(new Aircraft());
    // Assert.assertTrue(DomainUtils.hasUniqueResult(entities));
    //
    // entities.add(new Aircraft());
    // Assert.assertFalse(DomainUtils.hasUniqueResult(entities));
    //
    // Assert.assertFalse(DomainUtils.isObject(null));
    // Assert.assertTrue(DomainUtils.isObject(new Aircraft()));
    //
    // Aircraft aircraft = null;
    // Assert.assertFalse(DomainUtils.isEntity(aircraft));
    // aircraft = new Aircraft();
    // Assert.assertFalse(DomainUtils.isEntity(aircraft));
    // aircraft.setId(1L);
    // Assert.assertTrue(DomainUtils.isEntity(aircraft));
    // }

    @Test
    public void testDomainFactory() {
        String name = "name";
        String registration = "registration";
        String airportName = "airportName";
        String shortCode = "GRU";
        Airline airline = new Airline();
        Location origin = new Location();
        Location destination = new Location();

        DomainFactory.newAirline(name);
        DomainFactory.newAircraft(name, registration, airline);
        DomainFactory.newDestination(airportName, shortCode);
        DomainFactory.newRoute(airportName, origin, destination);

		new DomainFactory();
	}
}
