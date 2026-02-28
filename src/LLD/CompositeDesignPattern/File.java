package LLD.CompositeDesignPattern;

public class File implements FileSystem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println("Filename: " + name);
    }
}
