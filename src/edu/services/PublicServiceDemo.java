package edu.services;

import edu.clients.Citizen;
import edu.communications.Address;
import edu.services.docs.*;
import edu.services.orgs.PublicService;
import edu.services.servants.InformationResponsible;

/**
 * Created by yurii.pyvovarenko on 05.03.14.
 *
 * Implements main workfllow of the Public Service System
 */
public class PublicServiceDemo {
    static int statusNumber = 0;
    public static void main (String[] args) {
        System.out.println("------------- PublicServiceDemo ------------- ");

        /* INITIALIZATION start */
        String[] infoRequestLifecycleString = {"Created", "Assigned", "Replied"};
        DocumentLifecycle infoRequestLifecycle = createLinearLifecycle(infoRequestLifecycleString);
        DocumentType infoRequestDocType = new DocumentType("Information_Request", "InfoReq_",infoRequestLifecycle);
        infoRequestDocType.setFinalized(true);

        String[] outcomingDocLifecycleString = {"Created", "Passed_for_sending", "Sent"};
        DocumentLifecycle outcomingDocLifecycle = createLinearLifecycle(outcomingDocLifecycleString);
        DocumentType outcomingDocType = new DocumentType("Outcoming_Document", "Out_",outcomingDocLifecycle);
        outcomingDocType.setFinalized(true);

        Citizen citizen = new Citizen("Petrenko","Taras","Ivanovych");
        citizen.setEmailAddress("citizen@gmail.com");
        citizen.setOfficialId("1234567890");
        Address citizenAddress = new Address();
        citizenAddress.setCountry("Ukraine");
        citizenAddress.setRegion("Kyivska obl.");
        citizenAddress.setCity("Kyiv");
        citizenAddress.setCityArea("Shevchenkivski");
        citizenAddress.setStreet("Khreshchatyk");
        citizenAddress.setBuilding("1A");
        citizenAddress.setApartment("123H");
        citizenAddress.setZipCode("01001");
        citizen.setAddress(citizenAddress);

        PublicService publicService = new PublicService("Improvements service");
        publicService.setHierarchyLevel(1);
        publicService.setParentOrgId((long)0);
        publicService.setOrgId((long)0);
        publicService.setEmailAddress("contact@improvements.service.com");
        Address pubServiceAddress = new Address();
        pubServiceAddress.setCountry("Ukraine");
        pubServiceAddress.setRegion("Kyivska obl.");
        pubServiceAddress.setCity("Kyiv");
        pubServiceAddress.setCityArea("Shevchenkivski");
        pubServiceAddress.setStreet("Saksaganskogo");
        pubServiceAddress.setBuilding("104");
        pubServiceAddress.setZipCode("01002");
        publicService.setAddress(pubServiceAddress);
        /* INITIALIZATION end */

        /* Assume a user (Citizen wants to create s Request */
        if (( citizen.getRequesterOfficialId() != null) && (citizen.getRequesterOfficialId() != "")) {
            if ( citizen.getRequesterOfficialId().length() != 10 ) {
                System.out.println("RequesterOfficialId is wrong: " + citizen.getRequesterOfficialId() + ". We can not allow to create a request. You still may email to us.");
                System.exit(2);
            }
        } else {
            System.out.println("There's no RequesterOfficialId: " + citizen.getRequesterOfficialId() + ". We can not allow to create a request. You still may email to us.");
            System.exit(1);
        }

        InformationRequest infoRequest =
                new InformationRequest(infoRequestDocType, citizen, publicService);
        infoRequestDocType.setDocTypeInUse(true);
        infoRequest.setText("What parks and streets improvements are planned for 2014 in Kyiv?");
        infoRequest.setAddressForReply(citizen.getAddressString());
        infoRequest.setEmailForReply(citizen.getEmailAddress());

        if (infoRequest != null) {
            citizen.addRequest(infoRequest);
            System.out.println("citizen: " + citizen.getFullNameString());
            System.out.println("    citizenId: " + citizen.getCitizenId());
            System.out.println("\npublicService: " + publicService.getOrgName() + "\n");
            System.out.println(infoRequest.toString());
        } else {
            System.out.println("infoRequest is NULL");
        }

        /* The user can modify the Request data until it isReceivedByPublicService */
        infoRequest.setReceivedByPublicService(true);
        InformationResponsible informationResponsibleServant =
                new InformationResponsible(publicService, "Karpenko","Petro","Ivanovych");

        infoRequest.setIncomingDocResponsible(informationResponsibleServant);
        infoRequest.setNextDocumentStatus();

        printStatusAndAssignee(infoRequest, infoRequest.getIncomingDocResponsibleName());


        OutcomingDocument outcomingDocument =
                new OutcomingDocument(outcomingDocType, informationResponsibleServant, publicService);
        outcomingDocType.setDocTypeInUse(true);
        outcomingDocument.setText(informationResponsibleServant.getInformationForReply());
        infoRequest.setReactionDocument(outcomingDocument);
        outcomingDocument.setInitiatingDocument(infoRequest);
        outcomingDocument.setNextDocumentStatus();

        outcomingDocument.publishToRequester(citizen);
        outcomingDocument.setNextDocumentStatus();
        infoRequest.setNextDocumentStatus();
        infoRequest.setFinalized(true);

        printStatusAndAssignee(infoRequest, infoRequest.getAuthorName());

        Email email = new Email(publicService.getEmailAddress(), citizen.getEmailAddress(),
                informationResponsibleServant.getInformationForReply());
        email.sendEmail();
        publicService.sendDocumentToAddress(outcomingDocument,citizen.getAddress());
        outcomingDocument.setNextDocumentStatus();
        outcomingDocument.setFinalized(true);

        System.out.println("\ninfoRequest statuses history: " + infoRequest.getStatusesHistoryString());
        System.out.println("\ncitizen sent the next requests:\n   " + citizen.getRequestsString());
        System.out.println("\ncitizen got the next responses:\n   " + citizen.getResponsesString());

    }

    private static DocumentLifecycle createLinearLifecycle(String[] orgDocStatusesStrings) {
        DocumentLifecycle infoRequestLifecycle = new DocumentLifecycle(orgDocStatusesStrings);
        infoRequestLifecycle.setStartStatusIndex(0);
        infoRequestLifecycle.setFinalStatusIndex(orgDocStatusesStrings.length - 1);
        infoRequestLifecycle.setFinalized(true);
        return infoRequestLifecycle;
    }

    static void printStatusAndAssignee(OrganizationDocument orgDocument, String assigneeName) {
        System.out.println("\n" + statusNumber + ". " + orgDocument.getDocumentTypeName() + " status set to " + orgDocument.getDocumentStatusString() +
                " to " + assigneeName);
        statusNumber++;
    }
}