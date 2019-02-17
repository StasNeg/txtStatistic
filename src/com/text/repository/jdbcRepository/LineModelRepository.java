package com.text.repository.jdbcRepository;

import com.text.model.FileLineModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.text.repository.MySqlConnection.getConnection;

public class LineModelRepository {
    private FileModelRepository fileModelRepository = new FileModelRepository();

    public Integer saveOrUpdate(int fileId, FileLineModel model) {
        int result = 0;
        if (fileModelRepository.getById(fileId) != null) {
            String queryInsert = "INSERT INTO line_stat ("
                    + " line_number, file_id, longest_word, horters_word, line_length, average_word_length) VALUES ("
                    + " ?,?,?,?,?,?)";
            String queryUpdate = "update line_stat set " +
                    "longest_word = ?," +
                    "horters_word = ?," +
                    "line_length = ?," +
                    "average_word_length = ?" +
                    " where line_number = ? and file_id=?";
            try {
                // set all the preparedstatement parameters
                PreparedStatement st;
                if (!hasByFileIdAndLineNumber(fileId, model.getLineNumber())) {
                    st = getConnection().prepareStatement(queryInsert);
                    st.setInt(1, model.getLineNumber());
                    st.setInt(2, fileId);
                    st.setInt(3, model.getLongestWord());
                    st.setInt(4, model.getShortersWord());
                    st.setInt(5, model.getLength());
                    st.setDouble(6, model.getAverageWordLength());
                } else {
                    st = getConnection().prepareStatement(queryUpdate);
                    st.setInt(1, model.getLongestWord());
                    st.setInt(2, model.getShortersWord());
                    st.setInt(3, model.getLength());
                    st.setDouble(4, model.getAverageWordLength());
                    st.setInt(5, model.getLineNumber());
                    st.setInt(6, fileId);
                }
                // execute the preparedstatement insert
                result = st.executeUpdate();
                st.close();
            } catch (SQLException se) {
                // log exception
                System.out.println(se.getSQLState());
            }
        }
        return result;
    }

    public boolean hasByFileIdAndLineNumber(int fileId, int lineNumber) {
        String selectSQL = "SELECT * FROM line_stat WHERE line_number = ? and file_id = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(selectSQL);
            preparedStatement.setInt(1, lineNumber);
            preparedStatement.setInt(2, fileId);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("exeption " + e.getLocalizedMessage());
        }
        return false;
    }

    public boolean deleteByFileId(int fileId) {
        String deleteSQL = "DELETE FROM line_stat WHERE file_id = ? ";
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = getConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1, fileId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exeption " + e.getLocalizedMessage());
        }
        return result > 0;
    }


}
