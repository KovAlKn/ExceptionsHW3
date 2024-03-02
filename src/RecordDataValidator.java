import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

public class RecordDataValidator {
    String data;
    private String[] recordValues;

    public RecordDataValidator(String data) {
        this.data = data;
        recordValues=data.split(" ");
    }

    public boolean validateSize(String data)throws RuntimeException {
        try {
            if (Objects.equals(recordValues[0], "")) {
                throw new RecordSizeException(0);
            }
            if (recordValues.length != 6) {
                throw new RecordSizeException(recordValues.length);
            }
        } catch (RecordSizeException e) {
            System.out.println(RecordSizeException.getSizeExceptin());
            return false;
        }
        return true;
    }
    public int validatePersonName() throws RuntimeException{
        try{
            for(int i=0; i<3; i++){
                if(!checkForString(recordValues[i])){
                    throw new IllegalArgumentException();
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println("ФИО должно состоять только из букв!");
            return 0;
        }
        return 1;
    }

    public int validateDateOfBirth()throws RuntimeException {
        try{
            if(!dateOfBirthcheck(recordValues[3])) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("Не верный формат даты! Должно быть: dd.mm.yyyyyy Введено: "+recordValues[3]);
            return 0;
        }
        return 1;
    }

    public int validatePhoneNumber()throws RuntimeException {
        try{
            Integer phone=Integer.parseInt(recordValues[4]);
        }catch (NumberFormatException e){
            System.out.println("Не верный формат тел. номера! Должен состоять только из цифр. Введено: "+recordValues[4]);
            return 0;
        }
        return 1;
    }

    public int validateSex() throws RuntimeException {
        try {
            if (!Pattern.matches("[m,f]", recordValues[5])){
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e){
            System.out.println("Пол указан не верно!");
            return 0;
        }
        return 1;
    }

    boolean checkForString(String word){
        return(Pattern.matches("[a-zA-Zа-яёА-ЯЁ]+", word));
    }

    boolean dateOfBirthcheck(String word){
        return(Pattern.matches("(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1[012])[.]((19|20)\\d\\d)", word));
    }


}
