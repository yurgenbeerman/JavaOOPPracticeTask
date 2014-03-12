package edu.clients;

import edu.communications.Address;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yurii.pyvovarenko on 3/11/14.
 */
public class CitizenFieldsTest {
    Citizen citizen;

    @Before
    public void createCitizen() {
        citizen = new Citizen();
    }

    @Test
    public void GetFullNameTest() throws Exception {
        //given
        citizen = new Citizen("Petrenko","Taras","Ivanovych");

        //when

        //then
        org.junit.Assert.assertNotNull("full name shouldn't be null", citizen.getFullName());
    }

    @Test
    public void testGetFullNameString() throws Exception {
        //given
        citizen = new Citizen("Petrenko","Taras","Ivanovych");

        //when

        //then
        org.junit.Assert.assertEquals("full name should be " + "Petrenko Taras Ivanovych",
                "Petrenko Taras Ivanovych", citizen.getFullNameString());
    }

    @Test
    public void testGetEmailAddress() throws Exception {
        //given

        //when
        citizen.setEmailAddress("citizen@gmail.com");

        //then
        org.junit.Assert.assertEquals("citizen@gmail.com", citizen.getEmailAddress());
    }

    @Test
    public void testGetEmailAddressNull() throws Exception {
        //given

        //when

        //then
        org.junit.Assert.assertNull(citizen.getEmailAddress());
    }

    @Test
    public void testSetEmailAddress() throws Exception {
        //given

        //when
        citizen.setEmailAddress("citizen@gmail.com");

        //then
        org.junit.Assert.assertNotNull(citizen.getEmailAddress());
    }

    @Test
    public void testGetAddress_whenNull() throws Exception {
        //when

        //then
        org.junit.Assert.assertNull(citizen.getAddress());
     }

    @Test
    public void testGetAddress_whenNotNull() throws Exception {
        //when
        Address citizenAddress = new Address();
        citizen.setAddress(citizenAddress);

        //then
        org.junit.Assert.assertNotNull(citizen.getAddress());
    }


    @Test
    public void testGetAddressString() throws Exception {
        //when
        Address citizenAddress = new Address();
        citizenAddress.setCountry("Ukraine");
        //citizenAddress.setRegion("Kyivska obl.");
        citizenAddress.setCity("Kyiv");
        //citizenAddress.setCityArea("Shevchenkivski");
        citizenAddress.setStreet("Khreshchatyk");
        citizenAddress.setBuilding("1A");
        citizenAddress.setApartment("123H");
        citizenAddress.setZipCode("01001");
        citizen.setAddress(citizenAddress);

        //then
        org.junit.Assert.assertEquals("01001, Ukraine, Kyiv, st. Khreshchatyk, b. 1A, apt. 123H", citizen.getAddressString());
    }

    @Test
    public void testSetAddress() throws Exception {
        //when
        Address citizenAddress = new Address();
        citizen.setAddress(citizenAddress);

        //then
        org.junit.Assert.assertEquals(citizenAddress, citizen.getAddress());
    }

    @Test
    public void testGetRequesterOfficialId() throws Exception {

    }

    @Test
    public void testGetRequesterName() throws Exception {

    }

    @Test
    public void testGetRequesterAddress() throws Exception {

    }

    @Test
    public void testGetOfficialId() throws Exception {

        /*
        citizen.setOfficialId("1234567890");
        */
    }

    @Test
    public void testSetOfficialId() throws Exception {

        /*
        citizen.setOfficialId("1234567890");
        */
    }

    @Test
    public void testToString() throws Exception {

    }
}