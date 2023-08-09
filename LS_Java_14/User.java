package LS_Java_14;

public class User {
    private String surname;
    private String name;
    private String patronymic;

    private String dateOfBirth;
    private String phoneNumber;
    private String gender;

    public User(String surname, String name, String patronymic, 
    String dateOfBirth, String phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getInfoUser() {
        return "<" + surname + ">" + "<" + name + ">" + 
        "<" + patronymic + ">" + "<" + dateOfBirth + ">" + 
        "<" + phoneNumber + ">" + "<" + gender + ">";
    }

    public String getUserSurname() {
        return this.surname + ".txt";
    }
}
