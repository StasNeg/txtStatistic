package com.text.repository.jdbcRepository;

import com.text.model.FileModel;

import java.sql.*;

import static com.text.repository.MySqlConnection.getConnection;

public class FileModelRepository {
    public Long saveOrUpdate(FileModel model) {
        long result = 0l;
        String queryInsert = "INSERT INTO file ("
                + " filename ) VALUES ("
                + " ?)";
        String queryUpdate = "update file set filename = ? where id = ?";

        try {
            // set all the preparedstatement parameters
            PreparedStatement st;
            if (model.isNew()) {
                st = getConnection().prepareStatement(queryInsert);
                st.setString(1, model.getName());
            } else {
                st = getConnection().prepareStatement(queryUpdate);
                st.setInt(2, model.getId());
                st.setString(1, model.getName());
            }
            // execute the preparedstatement insert
            result = st.executeUpdate();
            st.close();
        } catch (SQLException se) {
            // log exception
            System.out.println(se.getSQLState());
        }
        return result;
    }

    public FileModel getById(int id) {
        String selectSQL = "SELECT * FROM file WHERE id=? ";
        PreparedStatement preparedStatement = null;
        FileModel result = null;
        try {
            preparedStatement = getConnection().prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int fileId = rs.getInt("id");
                String fileName = rs.getString("filename");
                result = new FileModel(fileId, fileName );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public FileModel getByName(String name) {
        String selectSQL = "SELECT * FROM file WHERE filename=? ";
        PreparedStatement preparedStatement = null;
        FileModel result = null;
        try {
            preparedStatement = getConnection().prepareStatement(selectSQL);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int fileId = rs.getInt("id");
                String fileName = rs.getString("filename");
                result = new FileModel(fileId, fileName );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void truncateTable() {
        try (Connection connection = getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate("TRUNCATE file");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
