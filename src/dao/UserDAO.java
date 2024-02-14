package dao;

import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String BASE_URL = "http://localhost/proyecto/";

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try {
            URL url = new URL(BASE_URL + "readUser.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                User user = new User();
                user.setUserId(jsonObject.getLong("UserId"));
                user.setName(jsonObject.getString("Name"));
                user.setEmail(jsonObject.getString("Email"));
                user.setPassword(jsonObject.getString("Password"));
                user.setPhone(jsonObject.getString("Phone"));
                user.setRole(User.UserRole.valueOf(jsonObject.getString("Role")));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean create(User user) {
        try {
            String urlParameters = "name=" + user.getName() + "&email=" + user.getEmail() + "&password=" + user.getPassword() + "&phone=" + user.getPhone() + "&role=" + user.getRole();
            byte[] postData = urlParameters.getBytes();
            int postDataLength = postData.length;

            URL url = new URL(BASE_URL + "createUser.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(postDataLength));
            connection.setDoOutput(true);
            connection.getOutputStream().write(postData);

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(User user) {
        try {
            String urlParameters = "userId=" + user.getUserId() + "&name=" + user.getName() + "&email=" + user.getEmail() + "&password=" + user.getPassword() + "&phone=" + user.getPhone() + "&role=" + user.getRole();
            byte[] postData = urlParameters.getBytes();
            int postDataLength = postData.length;

            URL url = new URL(BASE_URL + "updateUser.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(postDataLength));
            connection.setDoOutput(true);
            connection.getOutputStream().write(postData);

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Long id) {
        try {
            String urlParameters = "userId=" + id;
            byte[] postData = urlParameters.getBytes();
            int postDataLength = postData.length;

            URL url = new URL(BASE_URL + "deleteUser.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(postDataLength));
            connection.setDoOutput(true);
            connection.getOutputStream().write(postData);

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private User mapUser(JSONObject jsonObject) {
        User user = new User();
        user.setUserId(jsonObject.getLong("UserId"));
        user.setName(jsonObject.getString("Name"));
        user.setEmail(jsonObject.getString("Email"));
        user.setPassword(jsonObject.getString("Password"));
        user.setPhone(jsonObject.getString("Phone"));
        user.setRole(User.UserRole.valueOf(jsonObject.getString("Role")));
        return user;
    }
}

