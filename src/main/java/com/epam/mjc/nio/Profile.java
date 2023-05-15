package com.epam.mjc.nio;

import java.io.*;
import java.io.FileReader;
import java.util.Objects;

public class Profile {

    private String name;
    private Integer age;
    private String email;
    private Long phone;

    public Profile(File file) {
        try {
            readData(file);
        } catch (IOException e) {
            throw new MyOwnRuntimeException(e.getMessage());
        }
    }

    public Profile(String name, Integer age, String email, Long phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void readData(File file) throws IOException{

        String s;
        String[] sts = new String[4];
        int i = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try (InputStream inputStream = null) {

            while ((s = reader.readLine()) != null) {
                String line = s.split(":")[1];
                sts[i++] = line;

            }
        } catch (IOException e) {
            throw new MyOwnRuntimeException("My message");
        } finally {
            reader.close();
        }


        this.name = sts[0].substring(1);
        this.email = sts[2].substring(1);
        this.age = Integer.valueOf(sts[1].substring(1));
        this.phone = Long.valueOf(sts[3].substring(1));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Profile{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return getName().equals(profile.getName())
                && getAge().equals(profile.getAge())
                && getEmail().equals(profile.getEmail())
                && getPhone().equals(profile.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getEmail(), getPhone());
    }
}
