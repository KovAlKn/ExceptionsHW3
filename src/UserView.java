import util.Commands;

import java.io.IOException;
import java.util.Scanner;


public class UserView {
    public UserView() {
    }

    public void run() throws IOException {
        Commands com;
        while(true){
            try{
            System.out.println("e - exit \n" +
                    "c - create\n");
            String command = prompt("Enter the command: ");
            com = Commands.valueOf(command);

            if(com==Commands.e) return;
            if(com==Commands.c) {
                String record = createRecord();
                RecordDataValidator validator = new RecordDataValidator(record);

                int checkResult=0;
                if (validator.validateSize(record)) {
                    checkResult+=validator.validatePersonName();
                    checkResult+= validator.validateDateOfBirth();
                    checkResult+= validator.validatePhoneNumber();
                    checkResult+= validator.validateSex();
                }
                if (checkResult==4) {
                    System.out.println("Данные корректные");
                    DataRecord dataRecord = new DataRecord(record);
                    dataRecord.recordToFile();
                } else System.out.println("Данные не корректные");}

            } catch (IllegalArgumentException e) {
                    System.out.println("Указана неверная команда!");
                }

        }
    }
    private String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    private String createRecord(){
        String recordData= prompt("Введите данные через пробел: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        return recordData;
    }
}
