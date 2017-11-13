package com.fredericboisguerin.insa;



import java.io.*;
import java.util.ArrayList;

import com.opencsv.*;

public class ContactDAO {
    private File file;
    private FileReader file_reader;
    private FileWriter file_writer;
    private CSVWriter writer;
  //  private ArrayList<String> chaineCSV;
    private String[] entries;

    public ContactDAO(String File_CSV_Path, String File_CSV_Name) throws FileNotFoundException, IOException {
        this.file = new File(File_CSV_Path + File_CSV_Name);
        this.file_reader = new FileReader(file);
        this.file_writer = new FileWriter(file);
       // this.chaineCSV = new ArrayList<>();

    }

    public void write_Contacts_in_CSV_File(Contact persit) throws IOException{
        writer = new CSVWriter(this.file_writer, '\n');
        if (file.length() >0){
            for (int i=0; i<file.length();i++){
        }
        this.entries = new String[(int) file.length()];
        this.entries[0] = persit.utiliseName() +";" +persit.utiliseemail()+ "; "+ persit.utilisePhoneNumber(); //this.chaineCSV.get(i);
        try {
        }
            writer.writeNext(this.entries);
            writer.flush();
                //  writer.close();
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
}

