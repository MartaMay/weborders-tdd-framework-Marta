package pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    // POJO

    private String name;
    private int age;
    private LocalDate dob;


    public static void main(String[] args) {
        Student student = new Student();


    }

}
