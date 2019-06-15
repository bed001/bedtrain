package dao;

import beans.Profiles;
import beans.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfilesDAO {

    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ProfilesDAO(String jdbcUrl, String jdbcUsername,
                       String jdbcPassword) {
        this.jdbcUrl = jdbcUrl;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if(jdbcConnection == null || jdbcConnection.isClosed()){
            try{
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            jdbcConnection = DriverManager.getConnection(
                                jdbcUrl, jdbcUsername,jdbcPassword
            );
        }
    }
    protected void disconnect() throws SQLException{
            if(jdbcConnection!=null && !jdbcConnection.isClosed()){
                jdbcConnection.close();
            }
    }
    public boolean insertProfiles(Profiles profiles) throws SQLException{
        String sql = "INSERT INTO Profiles(login, email, name, surname, password, ip, role)" +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, profiles.getLogin());
        statement.setString(2, profiles.getEmail());
        statement.setString(3, profiles.getName());
        statement.setString(4, profiles.getSurname());
        statement.setString(5, profiles.getPassword());
        statement.setString(6, profiles.getIp());
        statement.setString(7, profiles.getRole());

        boolean rowInserted = statement.executeUpdate() > 0;
        System.out.println("--insertProfiles--");
        if (rowInserted == true) {
            System.out.println("Dobrze");
        } else {
            System.out.println("Błąd");
        }
        statement.close();
        disconnect();


        return rowInserted;
    }

    public List<Profiles> listAllProfiles() throws SQLException{
        List<Profiles> profilesList = new ArrayList<Profiles>();

        String sql = "SELECT * FROM Profiles";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String password = resultSet.getString("password");
            String ip = resultSet.getString("ip");
            Timestamp regstamp = resultSet.getTimestamp("regstamp");
            Role role = Role.valueOf(resultSet.getString("role"));

            Profiles profiles = new Profiles(id, login, email, name, surname, password, ip, regstamp, role);
            profilesList.add(profiles);
        }
        resultSet.close();
        statement.close();

        disconnect();
        System.out.println("--listAllProfiles--");
        for(Profiles profiles : profilesList) {
            System.out.println(profiles);
        }
        return profilesList;
    }

    public  boolean deleteProfiiles(Profiles profiles) throws SQLException{
        String sql = "DELETE FROM profiles where id = ? ";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, profiles.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        System.out.println("--rowDeleted--");
        if (rowDeleted == true) {
            System.out.println("Dobrze");
        } else {
            System.out.println("Błąd");
        }
        statement.close();
        disconnect();
        return rowDeleted;
    }
    public boolean updateProfiles(Profiles profiles) throws SQLException{
        String sql = "UPDATE Profiles Set login = ?, email = ?, name = ?, surname = ?, password = ? WHERE id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, profiles.getLogin());
        statement.setString(2, profiles.getEmail());
        statement.setString(3, profiles.getName());
        statement.setString(4, profiles.getSurname());
        statement.setString(5, profiles.getPassword());
        statement.setInt(6, profiles.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        System.out.println("--rowUpdated--");
        if (rowUpdated == true) {
            System.out.println("Dobrze");
        } else {
            System.out.println("Błąd");
        }
        statement.close();
        disconnect();
        return rowUpdated;
    }
    public  Profiles getProfiles(int id) throws SQLException{
        Profiles profiles = null;
        String sql = "SELECT * FROM Profiles WHERE id =? ";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int ids = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String password = resultSet.getString("password");
            String ip = resultSet.getString("ip");
            Timestamp regstamp = resultSet.getTimestamp("regstamp");
            Role role = Role.valueOf(resultSet.getString("role"));

            Profiles profile = new Profiles(ids, login, email, name, surname, password, ip, regstamp, role);

        }
        System.out.println("Dane profilu: " + profiles);
        resultSet.close();
        statement.close();
        return profiles;
    }
}

