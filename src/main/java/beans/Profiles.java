package beans;

import java.sql.Timestamp;

public class Profiles {
    protected int id;
    protected String login;
    protected String email;
    protected String name;
    protected String surname;
    protected String password;
    protected String ip;
    protected Timestamp regstamp;
    protected Role role;

    public Profiles() {
    }

    public Profiles(int id) {
        this.id = id;
    }

    public Profiles(String login, String email,
                    String name, String surname,
                    String password, String ip, Role role) {

        this.login = login;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.ip = ip;
        this.role = role;
    }

    public Profiles(int id, String login, String email, String name, String surname, String password, String ip, Timestamp regstamp, Role role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.ip = ip;
        this.regstamp = regstamp;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getRegstamp() {
        return regstamp;
    }

    public void setRegstamp(Timestamp regstamp) {
        this.regstamp = regstamp;
    }

    public String getRole() {
        return role.name();
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
