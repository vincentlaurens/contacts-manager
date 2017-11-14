package com.fredericboisguerin.insa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ContactsManager {
    private Contact newContact;
    private Contact parcoursearch;
    ArrayList<Contact> contactList;

    public ContactsManager() throws IOException {
        this.contactList = new ArrayList<Contact>();
    }

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException, IOException {

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
    public void removeContactByName(String name){
        boolean vraiSiTrouveAuMoinsUnContact =  false;
        for( Contact courant : this.contactList){
            String nomAcompare = courant.utiliseName();
            nomAcompare = nomAcompare.toLowerCase();
            if( nomAcompare.contains(name)){
                System.out.println(courant.toString());
                this.contactList.remove(courant);
                vraiSiTrouveAuMoinsUnContact = true;
            }
        }
        if(!vraiSiTrouveAuMoinsUnContact){
            System.out.println("Le contact que vous voulez supprime n'existe pas!!!");
        }
    }

    public void modifyContactByName(String name, String newName, String newEmail, String newPhoneNumber) throws InvalidContactNameException, InvalidEmailException {
        boolean vraiSiTrouveAuMoinsUnContact =  false;
        for( Contact courant : this.contactList){
            String nomAcompare = courant.utiliseName();
            nomAcompare = nomAcompare.toLowerCase();

            if( nomAcompare.contains(name)){
                if(newName=="identique"){
                    newName = courant.utiliseName();
                }
                if(newEmail=="identique"){
                    newEmail = courant.utiliseemail();
                }
                if(newPhoneNumber == "identique"){
                    newPhoneNumber = courant.utilisePhoneNumber();
                }
                if (newEmail == null) {
                    throw new InvalidContactNameException("Le champ nom est null!!!");
                }
                if (newEmail == "") {
                    throw new InvalidContactNameException("Le champ nom est vide!!!");
                }
                if (null != newEmail) {
                    String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(newEmail);
                    if (!matcher.matches()) {
                        throw new InvalidEmailException("Email not valid!!!");
                    }
                }
                System.out.println(courant.toString());
                courant.modifyContact(newName, newEmail, newPhoneNumber);
                vraiSiTrouveAuMoinsUnContact = true;
            }
        }
        if(!vraiSiTrouveAuMoinsUnContact){
            System.out.println("Le contact que vous voulez modifier n'existe pas!!!");
        }
    }

}


