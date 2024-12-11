package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RandomUtils {

    private String firstName;
    private String lastName;
    private String fullName;
    private String gender;
    private String userEmail;
    private String userPhone;
    private String yearOfBirth;
    private String monthOfBirth;
    private String dayOfBirth;
    private String subject;
    private String hobby;
    private String picture;
    private String streetAddress;
    private String state;
    private String city;

    private String[] genders = new String[]{"Male", "Female", "Other"};
    private String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] hobbies = new String[]{"Sports", "Reading", "Music"};
    private String[] pictures = new String[]{"mypict.png", "mypictsecond.png"};
    private String[] states = new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};


    // Создаем HashMap для соответствия состояний и городов
    private Map<String, List<String>> citiesMap = new HashMap<>() {{
        put("NCR", List.of("Delhi", "Gurgaon", "Noida"));
        put("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"));
        put("Haryana", List.of("Karnal", "Panipat"));
        put("Rajasthan", List.of("Jaipur", "Jaiselmer"));
    }};

    Faker faker = new Faker(new Locale("en-GB"));

    public String getFirstName() {
        firstName = faker.name().firstName();
        return firstName;
    }

    public String getLastName() {
        lastName = faker.name().lastName();
        return lastName;
    }

    public String getFullName() {
        fullName = faker.name().fullName();
        return fullName;
    }

    public String getGender() {
        int randomNumber = getRandomNumber(0, 3);
        gender = genders[randomNumber];
        return gender;
    }

    public String getUserEmail() {
        userEmail = faker.internet().emailAddress();
        return userEmail;
    }

    public String getUserPhone() {
        userPhone = faker.number().digits(10);
        return userPhone;
    }

    public String getYearOfBirth() {
        int year = getRandomNumber(2020, 2024);
        yearOfBirth = String.valueOf(year);
        return yearOfBirth;
    }


    public String getMonthOfBirth() {
        int randomNumber = getRandomNumber(7, 12);
        monthOfBirth = months[randomNumber];
        return monthOfBirth;
    }

    public String getDayOfBirth() {
        int day = getRandomNumber(10, 16);
        dayOfBirth = String.valueOf(day);
        return dayOfBirth;
    }

    public String getSubject() {
        subject = faker.hobbit().character().toString();
        return subject;
    }

    public String getHobby() {
        int randomNumber = getRandomNumber(0, 2);
        hobby = hobbies[randomNumber];
        return hobby;
    }

    public String getPicture() {
        int randomNumber = getRandomNumber(0, 2);
        picture = pictures[randomNumber];
        return picture;
    }

    public String getStreetAddress() {
        streetAddress = faker.address().streetAddress();
        return streetAddress;
    }

    public String getState() {
        int randomNumber = getRandomNumber(0, states.length);
        state = states[randomNumber];
        return state;
    }

    public String getCity(String state) {
        List<String> cities = citiesMap.get(state);
        if (cities != null && !cities.isEmpty()) {
            int randomNumber = getRandomNumber(0, cities.size());
            city = cities.get(randomNumber);
            return city;
        }
        return null;
    }

    private int getRandomNumber(int numberStart, int numberEnd) {
        return faker.number().numberBetween(numberStart, numberEnd);
    }
}
