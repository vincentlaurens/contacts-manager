package com.fredericboisguerin.insa;



import java.io.*;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO{
    private static String FILEPATH = "src/ressources/contactList.csv";
    private List<String[]> listeContacttoSave;

    public ContactDAO()throws IOException {
        this.listeContacttoSave = new ArrayList<String[]>();
    }

    public void write_Contacts_in_CSV_File(ContactsManager monContact) throws IOException{

        for (Contact courant : monContact.contactList) {
            String[] entries = courant.savetoCsvFormat();
            this.listeContacttoSave.add(entries);
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter(FILEPATH))) {
            writer.writeAll(this.listeContacttoSave);
        }
    }
    public void read_Contacts_in_CSV_File(ContactsManager monContact) throws IOException, InvalidEmailException, InvalidContactNameException {
        try (CSVReader reader = new CSVReader(new FileReader(FILEPATH))){
            String[] nextContact, contactInfo;

            String nameContactLu;
            String emailContactLu;
            String phoneNumberContactLu;

            monContact.contactList.clear();

            while ((nextContact = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                String ContactLu = nextContact[0];

                contactInfo = ContactLu.split(",");
                nameContactLu = contactInfo[0];
                emailContactLu = contactInfo[1];
                phoneNumberContactLu = contactInfo[2];

                //System.out.println(nomContactLu+","+emailContactLu+","+phoneNumberContactLu);

                monContact.addContact(nameContactLu, emailContactLu, phoneNumberContactLu);



            }
        }
    }
}

