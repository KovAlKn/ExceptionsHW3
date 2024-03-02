public class RecordSizeException extends RuntimeException{
    String sizeExceptin;
    static Integer size;
    public RecordSizeException(int size) {
        this.size = size;
    }

    public static String getSizeExceptin() {
        return ("Введено не корректное количество данных. Треуется - 6, введено - "+size);
    }

}
