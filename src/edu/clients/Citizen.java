package edu.clients;

import edu.communications.Address;
import edu.communications.Emailable;
import edu.services.docs.IncomingDocument;
import edu.services.docs.OutcomingDocument;

import java.util.ArrayList;

/**
 * Created by yurii.pyvovarenko on 3/4/14.
 *
 * Citizen objects contain information on Requests (IncomingDocs of Organization) and Responses (OutcomingDocs of Organization).
 * Also it has data to approve to Organization, that this is real citizen (officialId field = INN).
 */
public class Citizen implements Requester, Emailable {

    private static long lastCitizenId;

    private long citizenId;
    private FullName fullName;
    private String emailAddress;
    private Address address;
    private ArrayList<IncomingDocument> requests;
    private ArrayList<OutcomingDocument> responses;
    private String officialId;

    public Citizen() {
        this.citizenId = Citizen.lastCitizenId;
        Citizen.lastCitizenId++;
    }

    public Citizen(String surname, String name, String secondName) {
        this.fullName = new FullName(surname, name, secondName);
        this.citizenId = Citizen.lastCitizenId;
        Citizen.lastCitizenId++;
        this.requests = new ArrayList<IncomingDocument>();
    }

    public void addRequest(IncomingDocument request) {
        this.requests.add(request);
    }

    public ArrayList<IncomingDocument> getRequests() {
        return this.requests;
    }

    public String getRequestsString() {
        String result = "";
        for (int i = 0; i < getRequests().size(); i++) {
            result = result + getRequests().get(i);
        }
        return result;
    }

    public FullName getFullName() {
        return fullName;
    }

    public String getFullNameString() {
        return fullName.toString();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public String getAddressString() {
        return address.toString();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return citizenId;
    }

    public String getName() {
        return this.getFullNameString();
    }

    public String getOfficialId() {
        return officialId;
    }

    public void setOfficialId(String officialId) {
        this.officialId = officialId;
    }

    public ArrayList<OutcomingDocument> getResponses() {
        return responses;
    }

    public String getResponsesString() {
        String result = "";
        for (int i = 0; i < getResponses().size(); i++) {
            result = result + getResponses().get(i);
        }
        return result;
    }

    public void addResponse(OutcomingDocument response) {
        if (null == getResponses()) {
            this.responses = new ArrayList<OutcomingDocument>();
        }
        this.responses.add(response);
    }

    public String toString() {
        return this.getFullName().name;
    }
}
