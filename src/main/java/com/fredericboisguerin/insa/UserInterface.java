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
            System.out.println("--------------------\n 1-Créer un nouveau contact\n 2-Chercher un contact \n 3-Afficher les contact\n 4-Enregistrement des données \n 5-Recuperation des contacts \n 6-Modification d'un contact \n 7-Suppression d'un Contact \n 8-Quitter le menu \n  ---------------------");
            System.out.println("Faite votre choix:");
            int choixMenuUser = sc.nextInt();
            switch (choixMenuUser) {
                //créer contect
                case 1:
                    System.out.println("Entrez le nom du nouveau contact:");
                    String nomnewContact = sc.next();
                    System.out.println("Entrez l'email du nouveau contact:");
                    String emailnewContact = sc.next();
                    System.out.println("Entrez le numéro de téléphone du nouveau contact:");
                    String phonenumbernewContact = sc.next();
                    monContact.addContact(nomnewContact, emailnewContact, phonenumbernewContact);
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
                    System.out.println("Entrez le nom du contact à modifier:");
                    String nomAmodifier = sc.next();
                    System.out.println("Voulez vous modifier tous les champs?\n 1-Si modif nom + email + numéro de tel\n 2- Si modif nom + email\n 3- Si modif email + numéro de tel\n 4- Si modif nom + numéro de tel\n 5- Si modif Nom\n 6- Si modif Email\n 7- Si modif Numero de tel");
                    System.out.println("Faite votre choix:");
                    int choixMenumodif = sc.nextInt();
                    switch (choixMenumodif) {
                        //créer contect
                        case 1:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie1 = sc.next();
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie1 = sc.next();
                            System.out.println("Entrez le nouveau  numero de telephone:");
                            String nouveauPhoneNumbersaisie1 = sc.next();

                            monContact.modifyContactByName(nomAmodifier, nouveauNomsaisie1, nouveauEmailsaisie1, nouveauPhoneNumbersaisie1);
                            break;
                        case 2:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie2 = sc.next();
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie2 = sc.next();

                            monContact.modifyContactByName(nomAmodifier, nouveauNomsaisie2, nouveauEmailsaisie2, "identique");
                            break;
                        case 3:
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie3 = sc.next();
                            System.out.println("Entrez le nouveau  numero de telephone:");
                            String nouveauPhoneNumbersaisie3 = sc.next();

                            monContact.modifyContactByName(nomAmodifier, "identique", nouveauEmailsaisie3, nouveauPhoneNumbersaisie3);
                            break;
                        case 4:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie4 = sc.next();
                            System.out.println("Entrez le nouveau  numero de telephone:");
                            String nouveauPhoneNumbersaisie4 = sc.next();

                            monContact.modifyContactByName(nomAmodifier, nouveauNomsaisie4, "identique", nouveauPhoneNumbersaisie4);
                            break;
                        case 5:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie5 = sc.next();
                            monContact.modifyContactByName(nomAmodifier, nouveauNomsaisie5, "identique", "identique");
                            break;
                        case 6:
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie6 = sc.next();

                            monContact.modifyContactByName(nomAmodifier, "identique", nouveauEmailsaisie6, "identique");
                            break;
                        case 7:
                            System.out.println("Entrez le nouveau  numero de telephone:");
                            String nouveauPhoneNumbersaisie7 = sc.next();

                            monContact.modifyContactByName(nomAmodifier, "identique", "identique", nouveauPhoneNumbersaisie7);
                            break;
                        default:
                            System.out.println("Attention : Votre choix n'appartient pas au menu !!!");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Entrez le nom du contact à supprimer:");
                    String nomASupprimer = sc.next();
                    monContact.removeContactByName(nomASupprimer);
                    break;
                case 8:
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

    public static void main(String[] args) {
        try {
            UserInterface runUserInterface = new UserInterface();
        } catch (InvalidContactNameException e) {
            System.out.println("--------------\nAttention :" + e.getMessage() + "\n--------------------");
        } catch (InvalidEmailException emailException) {
            System.out.println("--------------\nAttention :" + emailException.getMessage() + "\n---------------");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

