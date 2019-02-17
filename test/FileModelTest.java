import com.text.model.FileModel;
import com.text.repository.jdbcRepository.FileModelRepository;
import com.text.repository.jdbcRepository.LineModelRepository;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileModelTest {
    private static FileModelRepository repository = new FileModelRepository();
    private static LineModelRepository linerepository = new LineModelRepository();

    @BeforeClass
    public static void beforeTest() {
        repository.saveOrUpdate(new FileModel("first"));
    }


    @Test
    public void insertFileName() {
        Assert.assertEquals(java.util.Optional.of(1L).get(), repository.saveOrUpdate(new FileModel("myNewFile1")));
        Assert.assertEquals(java.util.Optional.of(1L).get(), repository.saveOrUpdate(new FileModel(1, "myNewFile1")));
    }

    @Test
    public void getById() {
        if (repository.getById(1) == null) ;
        Assert.assertEquals(java.util.Optional.of(1L).get(), repository.saveOrUpdate(new FileModel(1, "myNewFile1")));
        Assert.assertEquals("myNewFile1", repository.getById(1).getName());


    }

    @AfterClass
    public static void afterClass() {
        repository.truncateTable();
    }

}
