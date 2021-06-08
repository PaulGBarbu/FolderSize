import Progress.ProgressBarRotating;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StartUp {
    static Long prevTotalSize = 0L;
    public static void main(String[] args) {
        StartUp app = new StartUp();
        Path currentPath;
        prevTotalSize = 0L;
        String input;

        currentPath = app.getCurrentPath();

        do {
            Long totalSize = 0L;
            app.displayHeader(currentPath.toString());

            List<Folder> folders = app.getSubFolders(currentPath);
            folders.sort(Comparator.comparing(Folder::getSize).reversed());

            for (Folder f : folders) {
                if(f.getSize() != -1) // Access Denied
                    totalSize = totalSize + f.getSize();
            }

            app.showFolderSize(totalSize, prevTotalSize);

            for (Folder f : folders) {
                f.print();
            }


            input = app.readInput("Press r/R to repeat or press enter to exit...");
        } while(input.toUpperCase().equals("R"));

    }

    private void showFolderSize(Long totalSize, Long prevTotalSize) {
        System.out.print("Folder Size: " + Util.humanReadableByteCountBin(totalSize) + ". ");
        if(prevTotalSize != 0L && !prevTotalSize.equals(totalSize)) {
            System.out.println("Removed " + Util.humanReadableByteCountBin(prevTotalSize - totalSize) + ".");
        }
        System.out.println("\n");
        StartUp.prevTotalSize = totalSize;
    }

    private String readInput(String s) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(s);
        String result = null;

        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Folder> getSubFolders(Path currentPath) {
        File file = new File(currentPath.toString());
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        List<Folder> folders = new ArrayList<>();

        for (String s : directories) {
            folders.add(new Folder(currentPath.toString(), s));
        }

        return folders;
    }

    private Path getCurrentPath() {
        Path currentRelativePath = Paths.get("");
        return currentRelativePath.toAbsolutePath();
    }

    private void displayHeader(String path) {
        int dots = path.length();

        System.out.println("\n");
        for (int i = 0; i < dots; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.println(path);

        for (int i = 0; i < dots; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

}
