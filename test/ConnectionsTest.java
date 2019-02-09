import com.text.repository.MySqlConnection;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionsTest {
    @Test
    public void JDBCConnectionTest() throws SQLException {
        Connection con = MySqlConnection.getConnection();
        Assert.assertNotNull(con);
    }
}
