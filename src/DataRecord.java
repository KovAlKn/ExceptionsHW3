import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataRecord {
    String data;
    String surname;
    String name;
    String patronym;
    String dateOfBirth;
    Integer phoneNumber;
    String sex;


    public DataRecord(String data) {
        this.data = data;
        String[] recordValues = data.split(" ");
        this.surname = recordValues[0];
        this.name = recordValues[1];
        this.patronym = recordValues[2];
        this.dateOfBirth = recordValues[3];
        this.phoneNumber = Integer.parseInt(recordValues[4]);
        this.sex = recordValues[5];

    }
public void recordToFile() throws IOException {
        String fileName= surname+".txt";
        //<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
        String context= String.format("<%s> <%s> <%s> <%s> <%s> <%s> \n", surname, name, patronym, dateOfBirth, phoneNumber, sex);
    System.out.println(context);
        try {
            File person = new File(fileName);
            if (person.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (IOException e) {
            System.err.println(e);
    }
    try (FileWriter write = new FileWriter(fileName, true)){
        write.write(context);
        write.flush();
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}

}


