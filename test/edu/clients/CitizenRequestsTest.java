package edu.clients;
import edu.services.docs.DocumentLifecycle;
import edu.services.docs.DocumentType;
import edu.services.docs.IncomingDocument;
import edu.services.orgs.PublicService;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by yurii.pyvovarenko on 3/11/14.
 */
public class CitizenRequestsTest {
    DocumentType infoRequestDocType;
    Citizen citizen;
    PublicService publicService;
    IncomingDocument infoRequest;

    @Before
    public void createLifecycleDocTypeCitizenPubServiceIncomDoc() {
        String[] infoRequestLifecycleString = {"Created", "Assigned", "Replied"};
        DocumentLifecycle infoRequestLifecycle = new DocumentLifecycle(infoRequestLifecycleString);
        infoRequestLifecycle.setFinalized(true);

        infoRequestDocType = new DocumentType("Information_Request", "InfoReq_",infoRequestLifecycle);
        infoRequestDocType.setFinalized(true);

        citizen = new Citizen("surname", "name", "secondName");

        publicService = new PublicService("Improvements service");
        infoRequest = new IncomingDocument(infoRequestDocType, citizen, publicService);
    }

    @Test
    public void shouldBeOneRequest_whenFirstAddRequest() throws Exception {
        //given

        //when
        citizen.addRequest(infoRequest);

        //then
        org.junit.Assert.assertEquals("Size of requests array should be 1", 1, citizen.getRequests().size());

    }

    @Test
    public void shouldIncreaseRequestsNumber_whenAddRequest() throws Exception {
        //given
        citizen.addRequest(infoRequest);
        int result = citizen.getRequests().size();

        //when
        citizen.addRequest(infoRequest);
        citizen.addRequest(infoRequest);

        //then
        org.junit.Assert.assertEquals("Size of requests array should be " + (result + 2) + " but is " + citizen.getRequests().size(), result + 2, citizen.getRequests().size());

    }

    @Test
    public void shouldBeNotEmptyString_whenGetRequestsString() throws Exception {
        //given

        //when
        citizen.addRequest(infoRequest);

        //then
        org.junit.Assert.assertNotNull("After addition the first request should not be null", citizen.getRequests().get(0));
    }

    @Test
    public void GetRequestsStringTest() throws Exception {
        //given

        //when
        citizen.addRequest(infoRequest);

        //then
        org.junit.Assert.assertNotSame("After addition the first request should not be empty string","", citizen.getRequestsString());
    }

    @Test
    public void testGetCitizenId() throws Exception {
        //given

        //when

        //then
        org.junit.Assert.assertTrue("citizenId should be > 0", citizen.getCitizenId() > 0);
    }

    /* TODO move to separate class tests of Citizen Responses methods */
    @Test
    public void testGetResponses() throws Exception {
        //given

        //when

        //then
    }

    @Test
    public void testGetResponsesString() throws Exception {
        //given

        //when

        //then
    }

    @Test
    public void testAddResponse() throws Exception {
        //given

        //when

        //then
    }



    /* TODO move to separate class tests of Citizen fields getters and setters */
    @Test
    public void GetFullNameTest() throws Exception {
        //given

        //when

        //then
    }

    @Test
    public void testGetFullNameString() throws Exception {

    }

    @Test
    public void testGetEmailAddress() throws Exception {

    }

    @Test
    public void testSetEmailAddress() throws Exception {

    }

    @Test
    public void testGetAddress() throws Exception {

    }

    @Test
    public void testGetAddressString() throws Exception {

    }

    @Test
    public void testSetAddress() throws Exception {

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

    }

    @Test
    public void testSetOfficialId() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }
}
