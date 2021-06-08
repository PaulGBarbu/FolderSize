import java.nio.file.Path;
import java.nio.file.Paths;

public class Folder {
    private String root;
    private String name;
    private Long size;

    public Folder(String root, String name) {
        this.root = root;
        this.name = name;
        this.size = Util.getSizeOfFolder(getPath());
    }

    private Path getPath() {
        return Paths.get(root + "\\" + name);
    }

    public void print() {
        String formatted = String.format("%-12s %-15s", Util.humanReadableByteCountBin(size), name);
        //System.out.println(size + "\t\t" + name);
        System.out.println(formatted);
    }

    public Long getSize() {
        return size;
    }
}
