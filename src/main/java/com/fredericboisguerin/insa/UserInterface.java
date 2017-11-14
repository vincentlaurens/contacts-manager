package com.fredericboisguerin.insa;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    public UserInterface() throws InvalidEmailException, InvalidContactNameException, IOException {
        Scanner sc = new Scanner(System.in);
        boolean inMenu = true;
        ContactsManager monContact = new ContactsManager();
        ContactDAO monContactDAO = new ContactDAO();
        while (inMenu) {
            System.out.println("--------------------\n 1-Créer un nouveau contact\n 2-Chercher un contact \n 3-Afficher les contact\n 4-Enregistrement des données \n 5-Recuperation des contacts \n 6-Quitter le menu \n  ---------------------");
            System.out.println("Faite votre choix:");
            int choixMenuUser  = sc.nextInt();
            switch (choixMenuUser) {
                //créer contect
                case 1:
                    System.out.println("Entrez le nom du nouveau contact:");
                    String nomnewContact = sc.next();
                    System.out.println("Entrez l'email du nouveau contact:");
                    String emailnewContact = sc.next();
                    System.out.println("Entrez le numéro de téléphone du nouveau contact:");
                    String phonenumbernewContact = sc.next();
                    monContact.addContact(nomnewContact,emailnewContact,phonenumbernewContact);
                   // monContactDAO.write_Contacts_in_CSV_File(monContact);
                    break;
                //chercher contact
                case 2:
                    System.out.println("Entrez le nom du contact recherché:");
                    String nomACherche = sc.next();
                    monContact.searchContactByName(nomACherche);
                    break;
                //afficher liste
                case 3:
                    monContact.printAllContacts();

                    break;
                case 4:
                    System.out.println("Données enregistrées  !!!");
                    monContactDAO.write_Contacts_in_CSV_File(monContact);
                    break;

                case 5:
                    System.out.println("Données extraites du fichier  !!!");
                    monContactDAO.read_Contacts_in_CSV_File(monContact);
                    break;
                case 6:
                    monContactDAO.write_Contacts_in_CSV_File(monContact);
                    inMenu = false;
                    System.out.println("Vous avez quitté le menu !!!");
                    break;
                //default
                default:
                    System.out.println("Attention : Votre choix n'appartient pas au menu !!!");
                    break;
            }
        }
    }
    public static void main(String[] args){
        try{
            UserInterface runUserInterface = new UserInterface();
        }catch (InvalidContactNameException e){
            System.out.println("--------------\nAttention :"+e.getMessage()+"\n--------------------");
        }catch (InvalidEmailException emailException){
            System.out.println("--------------\nAttention :"+emailException.getMessage()+"\n---------------");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
