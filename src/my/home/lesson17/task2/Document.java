package my.home.lesson17.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Document {
    List<String> numbersOfDocument;
    List<String> telephoneNumbers;

    List<String> emails;

    public Document(){
        numbersOfDocument = new ArrayList<>();
        telephoneNumbers = new ArrayList<>();
        emails = new ArrayList<>();
    }
    public Document(List<String > numbersOfDocument, List<String> telephoneNumbers, List<String> emails){
        this.numbersOfDocument = numbersOfDocument;
        this.telephoneNumbers = telephoneNumbers;
        this.emails= emails;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
    public String getEmail(int index){
        return emails.get(index);
    }
    public void setEmail(String str){
        emails.add(str);
    }

    public List<String> getNumbersOfDocument() {
        return numbersOfDocument;
    }
    public String getNumberOfDocument(int index){
        return numbersOfDocument.get(index);
    }

    public void setNumbersOfDocument(List<String> numbersOfDocument) {
        this.numbersOfDocument = numbersOfDocument;
    }
    public void setNumberOfDocument(String str){
        numbersOfDocument.add(str);
    }

    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }
    public String getTelophoneNumber(int index){
        return telephoneNumbers.get(index);
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }
    public void setTelephoneNumber(String str){
        telephoneNumbers.add(str);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return Objects.equals(numbersOfDocument, document.numbersOfDocument) && Objects.equals(telephoneNumbers, document.telephoneNumbers) && Objects.equals(emails, document.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbersOfDocument, telephoneNumbers, emails);
    }

    @Override
    public String toString() {
        return "Document{" +
                "numbersOfDocument=" + numbersOfDocument +
                ", telephoneNumbers=" + telephoneNumbers +
                ", emails=" + emails +
                '}';
    }
}
