package com.fredericboisguerin.insa;

public class Contact {
    private String name;
    private String email;
    private String phoneNumber;
    private String chaine_retour;


    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        if (this.email == null && this.phoneNumber != null) {
            chaine_retour =  this.name + ", " + this.phoneNumber;
        }
        if (this.email != null && this.phoneNumber == null) {
            chaine_retour =  this.name + ", " + this.email;
        }
        if (this.email == null && this.phoneNumber == null) {
            chaine_retour =  this.name;
        }
        if (this.email != null && this.phoneNumber != null) {
            chaine_retour =  this.name + ", " + this.email + ", " + this.phoneNumber;
        }
        return chaine_retour;
    }

   public String utiliseName(){
        return this.name;
    }
    public String utiliseemail(){
        return this.email;
    }
    public String utilisePhoneNumber(){
        return this.phoneNumber;
    }
    public String[] savetoCsvFormat(){
        return new String[]{this.name + "," + this.email + "," + this.phoneNumber};
    }

}
