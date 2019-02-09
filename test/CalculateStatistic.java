import com.text.model.FileLineModel;
import com.text.model.FileModel;
import com.text.service.fileService.FileLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CalculateStatistic {
    private FileLoader fileLoader = new FileLoader();

    @Test
    public void CalculateStatiticInLineTest() throws IOException {
        List<FileLineModel> lines = fileLoader.getStatisticFromFile(new FileModel("C:\\Users\\Stanislav\\Downloads\\Testing\\txt_stat\\src\\resources\\test.txt"));
        Assert.assertEquals(3,lines.size());
        Assert.assertEquals(java.util.Optional.ofNullable("understanding".length()).get(),lines.get(0).getLongestWord());
        Assert.assertEquals(java.util.Optional.ofNullable("of".length()).get(),lines.get(0).getShortersWord());
        Assert.assertEquals(java.util.Optional.ofNullable("That would allow the understanding of VMS (including some text sequences)".length()).get(),lines.get(0).getLength());
        System.out.println(lines);
    }

    @Test
    public void CalculateStatiticWitoutSreamInLineTest() throws IOException {
        List<FileLineModel> lines = fileLoader.getStatisticFromFileWithoutStream(new FileModel("C:\\Users\\Stanislav\\Downloads\\Testing\\txt_stat\\src\\resources\\test.txt"));
        Assert.assertEquals(3,lines.size());
        Assert.assertEquals(java.util.Optional.ofNullable("understanding".length()).get(),lines.get(0).getLongestWord());
        Assert.assertEquals(java.util.Optional.ofNullable("of".length()).get(),lines.get(0).getShortersWord());
        Assert.assertEquals(java.util.Optional.ofNullable("That would allow the understanding of VMS (including some text sequences)".length()).get(),lines.get(0).getLength());
        System.out.println(lines);
    }
}
