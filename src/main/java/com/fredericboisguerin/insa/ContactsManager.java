package com.fredericboisguerin.insa;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ContactsManager {
    private Contact newContact;
    private Contact parcoursearch;
    ArrayList<Contact> contactList;

    public ContactsManager() {
        contactList = new ArrayList<Contact>();
    }

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException {

        if (name == null) {
            throw new InvalidContactNameException("Le champ nom est null!!!");
        }
        if (name == "") {
            throw new InvalidContactNameException("Le champ nom est vide!!!");
        }
        if (null != email) {
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new InvalidEmailException("Email not valid!!!");
            }
        }
        newContact = new Contact(name, email, phoneNumber);
        if (contactList.isEmpty()) {
            contactList.add(0, newContact);
        } else {
            contactList.add(newContact);
        }
    }

    public void printAllContacts() {
        if (contactList.isEmpty() || contactList == null) {
            System.out.println("Liste de contacts vide !!!");
        } else {
            for (Contact parcourprint : contactList) {
                System.out.println(parcourprint.toString());
            }
        }
    }


    public void searchContactByName(String name){
        boolean vraiSiTrouveAuMoinsUnContact =  false;
        for( Contact courant : contactList){
            String nomAcompare = courant.utiliseName();
            nomAcompare = nomAcompare.toLowerCase();
            if( nomAcompare.contains(name)){
                System.out.println(courant.toString());
                vraiSiTrouveAuMoinsUnContact = true;
            }
        }
        if(!vraiSiTrouveAuMoinsUnContact){
            System.out.println("Aucun contact trouvé");
        }
    }
}


