package LLD.CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        children.add(fileSystem);
    }
    public void remove(FileSystem fileSystem) {
        children.remove(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + name);
        for (FileSystem child : children) {
            child.ls();
        }
    }
}
