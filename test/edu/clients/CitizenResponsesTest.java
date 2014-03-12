package edu.clients;

import edu.services.docs.DocumentLifecycle;
import edu.services.docs.DocumentType;
import edu.services.docs.OutcomingDocument;
import edu.services.servants.InformationResponsible;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yurii.pyvovarenko on 3/11/14.
 */
public class CitizenResponsesTest extends CitizenTestsBasics {
    OutcomingDocument outcomingDocument;

    @Before
    public void createInfoReqDocType_Citizen_PubService() {
        initCitizenAndPublicService();

        String[] outcomingDocLifecycleString = {"Created", "Passed_for_sending", "Sent"};
        DocumentLifecycle outcomingDocLifecycle = new DocumentLifecycle(outcomingDocLifecycleString);
        DocumentType outcomingDocType = new DocumentType("Outcoming_Document", "Out_",outcomingDocLifecycle);
        outcomingDocType.setFinalized(true);

        InformationResponsible informationResponsibleServant =
                new InformationResponsible(publicService, "Karpenko","Petro","Ivanovych");

        outcomingDocument =
                new OutcomingDocument(outcomingDocType, informationResponsibleServant, publicService);
    }

    @Test
    public void GetResponsesTest() throws Exception {
        //given

        //when
        citizen.addResponse(outcomingDocument);

        //then
        org.junit.Assert.assertTrue("Should be not empty string of response", citizen.getResponses().size() > 0);
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
}