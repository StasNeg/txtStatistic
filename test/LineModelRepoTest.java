import com.text.model.FileLineModel;
import com.text.model.FileModel;
import com.text.repository.jdbcRepository.FileModelRepository;
import com.text.repository.jdbcRepository.LineModelRepository;
import org.junit.Assert;
import org.junit.Test;

public class LineModelRepoTest {
    private final static LineModelRepository repository = new LineModelRepository();
    private final static FileModelRepository filerepository = new FileModelRepository();
    @Test
    public void saveOrUpdateTest(){
        FileModel file = new FileModel("newFile");
        filerepository.saveOrUpdate(file);
        file = filerepository.getByName("newFile");
        Assert.assertEquals(java.util.Optional.of(1).get(),repository.saveOrUpdate(file.getId(), new FileLineModel(1,2,3,4,5,6.2)));
    }
}
