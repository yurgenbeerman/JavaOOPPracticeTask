package edu.services.docs;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by yurii.pyvovarenko on 05.03.14.
 */
public final class Email extends Text {
    private String emailFromAddress;
    private String emailToAddresses;
    private String emailCCAddresses;
    private String emailBCCAddresses;
    private GregorianCalendar emailSentDate;

    public Email(String emailFromAddress, String emailToAddress, String emailText) {
        this.emailFromAddress = emailFromAddress;
        this.emailToAddresses = emailToAddress;
        this.setText(emailText);
    }

    /* IMPORTANT! all setters must check "if (! isEmailSent)" */
    public void sendEmail() {
        //...
        this.emailSentDate = new GregorianCalendar();
        this.isFinalized = true;

    }

    public String getEmailFromAddress() {
        return emailFromAddress;
    }

    public void setEmailFromAddress(String emailFromAddress) {
        if (! isFinalized) {
            this.emailFromAddress = emailFromAddress;
        }
    }

    public String getEmailToAddresses() {
        return emailToAddresses;
    }

    public void setEmailToAddresses(String emailToAddresses) {
        if (! isFinalized) {
            this.emailToAddresses = emailToAddresses;
        }
    }

    public String getEmailCCAddresses() {
        return emailCCAddresses;
    }

    public void setEmailCCAddresses(String emailCCAddresses) {
        if (! isFinalized) {
            this.emailCCAddresses = emailCCAddresses;
        }
    }

    public String getEmailBCCAddresses() {
        return emailBCCAddresses;
    }

    public void setEmailBCCAddresses(String emailBCCAddresses) {
        if (! isFinalized) {
            this.emailBCCAddresses = emailBCCAddresses;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (! isFinalized) {
            this.text = text;
        }
    }

    public GregorianCalendar getEmailSentDate() {
        return emailSentDate;
    }

    public void setEmailSentDate(GregorianCalendar emailSentDate) {
        if (! isFinalized) {
            this.emailSentDate = emailSentDate;
        }
    }
}
